package com.hellofan.backend.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * 测试输入的字符串是否手机号
     * @param str 手机号
     * @return true/false
     */
    public static boolean isMobile(String str){
        Pattern p=Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
        Matcher m=p.matcher(str);
        return m.matches();
    }
}
