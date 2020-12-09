package com.example.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        String str = "요즘은 붕어빵이 제철";
        model.addAttribute("data", str);
        return "hello"; //hello.html을 가리키고 있음

    }
}