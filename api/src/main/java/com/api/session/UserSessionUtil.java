package com.api.session;


import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class UserSessionUtil {

    private static final Map<String, String> MESSAGE = new ConcurrentHashMap<>();


    public static void addCode(String token,String code) {
        MESSAGE.put(token,code);
    }


    public static String getCode(String token) {
       return  MESSAGE.get(token);
    }

    public static Long getUid(HttpServletRequest request){
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("shUserId")) {
                return Long.parseLong(cookie.getValue());
            }
        }
        return null;
    }

}
