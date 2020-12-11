package com.example.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //인터넷 url을 통해서 주소 해석을 할 때, 콘트롤러 안에 있는 내용을 가장 먼저 확인.
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }



}
