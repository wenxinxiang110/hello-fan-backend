package com.hellofan.backend.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @ClassName ResponseMap.java
 * @Description TODO
 * @createTime 2019年07月11日 11:09:00
 */
public class ResponseMap {
    public static Map<String ,Object> sucessOf(Object data,String message,String statusCode)
    {
        Map<String,Object> sucessMap= new HashMap<>();
        sucessMap.put("datas",data);
        sucessMap.put("message",message);
        sucessMap.put("statusCode",statusCode);
        return sucessMap;
    }
    public static Map<String ,Object> wrongOf(String message,String statusCode)
    {
        Map<String,Object> wrongMap= new HashMap<>();
        wrongMap.put("message",message);
        wrongMap.put("statusCode",statusCode);
        return wrongMap;
    }
}
