package com.api.controller;

import com.api.model.entity.User;
import com.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;
//    @Autowired
//    Producer producer;
//    @Autowired
//    private UserSessionUtil userSessionUtil;

    //
    @GetMapping("/list")
    public String  userlist(){

        User user = userService.getUser(11L);

        return user.toString();
    }


//    @GetMapping("/captcha")
//    public  HashMap<String, String> captcha() throws IOException {
//
//        String key = UUID.randomUUID().toString();
//        String code = producer.createText();
//        HashMap<String, String> map = new HashMap<>();
//
//        // 为了测试
////		key = "aaaaa";
////		code = "11111";
//
//        BufferedImage image = producer.createImage(code);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ImageIO.write(image, "jpg", outputStream);
//
//        BASE64Encoder encoder = new BASE64Encoder();
//        String str = "data:image/jpeg;base64,";
//
//        String base64Img = str + encoder.encode(outputStream.toByteArray());
//
//        map.put("captcha",base64Img);
//        map.put("token",key);
//        System.out.println("set key:"+key);
//        System.out.println("set code:"+code);
//        userSessionUtil.addCode(key,code);
//        return map;
//
//    }


}
