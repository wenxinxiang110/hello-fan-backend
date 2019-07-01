package com.hellofan.backend.service;


import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.hellofan.backend.dao.UserDao;
import com.hellofan.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    private StringRedisTemplate s;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;

    @Autowired
    UserDao userDao;


    /*
    *调用腾讯云发送验证码到用户
    *
     */

    /**
     * 存放验证码的hashmap,key为手机号,value为验证码
     */
    Map<String,String> codeMap=new HashMap<>();


    @Override
    public Boolean sendMsg(String countryCode, String phoneNum,String flag) {
        Boolean isSend=true;
        //随机生成的验证码
        String randomcode=(int)((Math.random()*9+1)*1000)+"";
        System.out.println("randomcode="+randomcode);

        // 短信应用SDK AppID
        int appid = 1400209835; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "7ea3f772ec147d95aa3f0d5ff492f85a";
        try {
            //调用腾讯云接口发送验证码
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNum,
                    "【易骑公众号】您的验证码是："+randomcode, "", "");
            System.out.println("issendsuccess"+result);
            //将验证码保存到Redis中
//            s.opsForValue().set(phoneNum,randomcode
//                    ,300, TimeUnit.SECONDS
//            );
            //验证码保存
            codeMap.put(phoneNum,randomcode);
            //15s后移除验证码
            Timer timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    codeMap.remove(phoneNum);
                }
            },15000);
        } catch (Exception e) {
            // HTTP响应码错误
            isSend=false;
            e.printStackTrace();
        }
        finally {
            return isSend;
        }
    }

    @Override
    public Boolean verify(String phoneNum, String code) {
        //从Redis中获取验证码
//        String trueCode=s.opsForValue().get(phoneNum);
//        return code.equals(trueCode);
        return code.equals(codeMap.get(phoneNum));
    }

    @Override
    public void register(User user) {
        userDao.insertUser(user);
    }

    @Override
    public boolean isNameRepeat(String name) {

        int temp=userDao.findUserByName(name);
        if(temp==0)
            return false;
        else
            return true;
    }

    @Override
    public boolean isPhoneNumRepeat(String phoneNum) {
        int temp=userDao.findUserByPhoneNum(phoneNum);
        if(temp==0)
            return false;
        else
            return true;
    }

    @Override
    public boolean verifyUserInfo(String userName, String password) {
        if(userName!=null&&password!=null&&!userName.equals("")&&!password.equals("")) {
            int result=userDao.verifyUserInfoByName(userName,password);
            System.out.println("result"+result);
            if(result!=1) {
                return false;
            }
            else
                return true;
        }
        return false;
    }

    @Override
    public boolean updatePassword(String phoneNum, String password) {
        userDao.updateByPhoneNum(phoneNum,password);
        return false;
    }

    @Override
    public void deleteRandomCode(String phoneNum) {
        try {
            codeMap.remove(phoneNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //randomcode=null;
    }

//    @Override
//    public void update(User user) {
//        //如果数据存在就更新
//        Update update=new Update();
//        if(user.getDeposit()!=null)
//            update.set("deposit",user.getDeposit());
//        if(user.getStatus()!=null)
//            update.set("Status",user.getStatus());
//        if(user.getName()!=null)
//            update.set("Name",user.getName());
//        if(user.getIdNum()!=null)
//            update.set("IdNum",user.getIdNum());
//
//        mongoTemplate.updateFirst(
//                new Query(Criteria.where("phoneNum").is(user.getPhoneNum())),  //查询语句
//                update,        //要更新的值
//                user.getClass()
//        );
//    }


}
