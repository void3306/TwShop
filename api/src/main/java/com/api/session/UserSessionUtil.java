package com.api.session;


import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class UserSessionUtil {

    private static final Map<String, String> MESSAGE = new ConcurrentHashMap<>();


    public void addCode(String token,String code) {
        MESSAGE.put(token,code);
    }


    public String getCode(String token) {
       return  MESSAGE.get(token);
    }

    public String getCurrentUserCookie(){
        return "shUserId";
    }



}
