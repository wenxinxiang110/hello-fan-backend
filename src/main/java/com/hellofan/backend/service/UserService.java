package com.hellofan.backend.service;


import com.hellofan.backend.model.User;

import java.util.Date;

public interface UserService {

    /**
     * @param countryCode 国家代码
     * @param phoneNum 手机号
     * @return 是否发送成功
     */
    Boolean sendMsg(String countryCode, String phoneNum,String flag);

    /**
     * @param phoneNum
     * @param code
     * @return 是否验证成功
     */
    Boolean verify(String phoneNum, String code);

    /**
     * 注册
     * @param user
     */
    void register(User user);

    /**
     * @param name
     * @return 判断是否重名 是返回true,否返回false
     */
    boolean isNameRepeat(String name);
//
//    void update(User user);

    /**
     * @param name
     * @return 判断是否重名 是返回true,否返回false
     */
    boolean isPhoneNumRepeat(String name);

    String verifyUserInfo(String userName ,String password);

    boolean updatePassword(String phoneNum, String password);

    void deleteRandomCode(String phonrNum);

    Date getUpdateTime(String userName);
}
