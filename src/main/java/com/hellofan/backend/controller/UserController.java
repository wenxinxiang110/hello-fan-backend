package com.hellofan.backend.controller;

import com.hellofan.backend.dto.UserDto;
import com.hellofan.backend.dto.UserInfo;
import com.hellofan.backend.model.generator.User;
import com.hellofan.backend.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @param phoneNum
     * @param flag findlost是找回,register注册
     * @return
     */
    @GetMapping("/genCode")
    public String genVerifyCode(String phoneNum,String flag) {
        //调用Service层
        if(flag.equals("register")) {
            if(userService.isPhoneNumRepeat(phoneNum)){
                return "phoneNumRepeat";
            }
            return userService.sendMsg("+86",phoneNum,flag).toString();
        }
        else {
            if(userService.isPhoneNumRepeat(phoneNum)){
                return userService.sendMsg("+86",phoneNum,flag).toString();
            }
            return "phoneNumNotExist";
        }

    }

    @GetMapping("/getUpdateTime")
    public Date getUpdateTime(String userName){
        // return studyPlanService.
        return userService.getUpdateTime(userName);
    }

    //校对验证码
    @GetMapping("/verifyCode")
    public String verifyCode(String phoneNum,String code) {
        return userService.verify(phoneNum,code).toString();
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto){

        String phoneNum=userDto.getUser().getPhoneNum();
        String code=userDto.getCode();
        String userName=userDto.getUser().getUserName();
        if(!userService.verify(phoneNum,code)) {
            return  "codeError";
        }
        if(userService.isNameRepeat(userName)) {
            return "userNameRepeat";
        }

        try{
            userService.register(userDto.getUser());
            userService.deleteRandomCode(userDto.getUser().getPhoneNum());
        }catch(Exception e) {
            return "false";
        }
        return "true";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        String result=userService.verifyUserInfo(user.getUserName(),user.getPassword());
        return result;

    }

    @GetMapping("/verify")
    public String verify(String code,String userName,String phoneNum) {
        if(!userService.verify(phoneNum,code)) {
            return "codeError";
        }
        if(userService.isNameRepeat(userName)) {
            return "userNameRepeat";
        }
        return "true";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@RequestBody UserDto userDto) {

        if (userService.verify(userDto.getUser().getPhoneNum(),userDto.getCode())) {
            try{
                 userService.updatePassword(userDto.getUser().getPhoneNum(),userDto.getUser().getPassword());
                userService.deleteRandomCode(userDto.getUser().getPhoneNum());
                 return "true";
            }catch(Exception e){
                e.printStackTrace();
                return "false";
            }
        }
        return "codeError";

    }

    @PostMapping("/updateSharedPreferences")
    public boolean updateSharedPreferences(@RequestBody User user){
        return userService.updateSharedPreferences(user);
    }

    @GetMapping("/getSharedPreferences")
    public User getSharedPreferences(String userName){
        return userService.getSharedPreferences(userName);
    }

    @GetMapping("/getUserInfo")
    public UserInfo getUserInfo(String userName){
        return userService.getUserInfo(userName);
    }

    @PostMapping("/saveUserInfo")
    public String saveUserInfo(UserInfo userInfo)
    {
        return userService.saveUserInfo(userInfo);
    }
}
