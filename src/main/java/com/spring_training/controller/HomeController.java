package com.spring_training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}

/*
 * controller를 이용하여 "/"에 대한 mapping을 해주었기 때문에 static/index.html이 없어도
 * template/home.html이 초기화면으로 설정됨
 * 스프링 컨테이너에서 static/index.html보다 우선적으로 controller의 mapping값을 탐색하기 때문
 */