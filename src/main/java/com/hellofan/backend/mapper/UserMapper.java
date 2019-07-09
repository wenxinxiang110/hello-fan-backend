package com.hellofan.backend.mapper;

import com.hellofan.backend.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 数据访问层
 */
@Mapper
public interface UserMapper {

     boolean insertUser(User user);

     Integer findUserByName(String name);

     Integer findUserByPhoneNum(String phoneNum);

     String findUserNameByPhone(@Param("phoneNum") String phoneNum);

     Integer verifyUserInfoByName(@Param("userName") String userName, @Param("password") String password);

     Integer verifyUserInfoByPhoneNum(@Param("phoneNum") String phoneNum, @Param("oldPassword") String oldPassword);

     void updateByPhoneNum(@Param("phoneNum") String phoneNum, @Param("newPassword") String newPassword);

     Date getUpdateTime(@Param("userName") String userName);

     void updateUserTime(@Param("userName") String userName, @Param("date") Date date);
}
