package com.spring_training.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*
 * /members/new에서 입력받은 이름을 MemberController로 전달하는 객체(DTO?)
 */
