package com.spring_training.domain.member.dto;

public class MemberDto {
    private String name;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
/*
 * /members/new에서 입력받은 이름을 MemberController로 전달하는 객체(DTO?)
 */
