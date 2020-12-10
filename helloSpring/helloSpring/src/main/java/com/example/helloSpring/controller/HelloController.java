package com.example.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        String str = "요즘은 붕어빵이 제철";
        model.addAttribute("data", str);
        return "hello"; //hello.html을 가리키고 있음
    }

    @GetMapping("hello-mvc")
    public String hello_mvc(@RequestParam("name") String name, Model model) { //get 방식으로 파라미터 값 받아옴.
        model.addAttribute("name", name);
        return "hello_template";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloSpirng(@RequestParam("name") String name) {
        return "*** hello *** " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

