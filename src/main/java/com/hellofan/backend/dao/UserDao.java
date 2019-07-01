package com.hellofan.backend.dao;

import com.hellofan.backend.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 数据访问层
 */
@Mapper
public interface UserDao {

     boolean insertUser(User user);

     Integer findUserByName(String name);

     Integer findUserByPhoneNum(String phoneNum);

     Integer verifyUserInfoByName(@Param("userName") String userName, @Param("password") String password);

     Integer verifyUserInfoByPhoneNum(@Param("phoneNum") String phoneNum, @Param("oldPassword") String oldPassword);

     void updateByPhoneNum(@Param("phoneNum") String phoneNum, @Param("newPassword") String newPassword);
}
