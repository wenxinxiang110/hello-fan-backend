package com.hellofan.backend.controller;

import com.hellofan.backend.dto.UserDto;
import com.hellofan.backend.model.User;
import com.hellofan.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public boolean login(@RequestBody User user) {
        System.out.println("name:"+user.getUserName()+" password"+user.getPassword());
        return userService.verifyUserInfo(user.getUserName(),user.getPassword());
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
