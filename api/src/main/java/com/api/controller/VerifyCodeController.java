package com.api.controller;

import com.api.session.UserSessionUtil;
import com.google.code.kaptcha.Producer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;
import java.util.Base64;

@CrossOrigin
@RestController
@RequestMapping("verify")
public class VerifyCodeController {

    @Resource
    Producer producer;

    /**
     * 验证码接口
     * @return
     * @throws IOException
     */
    @GetMapping("/captcha")
    public HashMap<String, String> captcha() throws IOException {

        String key = UUID.randomUUID().toString();
        String code = producer.createText();
        HashMap<String, String> map = new HashMap<>();

        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        Base64.Encoder encoder = Base64.getEncoder();
        String str = "data:image/jpeg;base64,";

        String base64Img = str + encoder.encodeToString(outputStream.toByteArray());

        map.put("captcha", base64Img);
        map.put("token", key);
        System.out.println("set key:" + key);
        System.out.println("set code:" + code);
        UserSessionUtil.addCode(key, code);
        return map;

    }
}
