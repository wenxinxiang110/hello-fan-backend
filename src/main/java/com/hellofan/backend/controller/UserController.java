package com.hellofan.backend.controller;

import com.hellofan.backend.dto.UserDto;
import com.hellofan.backend.model.User;
import com.hellofan.backend.service.UserService;
import com.hellofan.backend.utils.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
        //user.getUserName()先判断是否11位数字，是的话当作手机号码处理；否则当作用户名
        JSONObject jsonObject=new JSONObject();

        String result=userService.verifyUserInfo(user.getUserName(),user.getPassword());
        if(result.equals("false")) {
            jsonObject.put("loginStatus","false");
        }
        else {
            jsonObject.put("loginStatus","true");
            jsonObject.put("userName",result);
        }

        return jsonObject.toString();

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
}
