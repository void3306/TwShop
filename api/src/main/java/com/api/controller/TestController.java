package com.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("test")
public class TestController {

        @RequestMapping("/hello")
        public String hello(){
            return "hello";
        }
}
