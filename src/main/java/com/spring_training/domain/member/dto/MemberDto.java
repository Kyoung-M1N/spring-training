package com.spring_training.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private String name;
    private String email;
    private String password;
}
/*
 * /members/new에서 입력받은 이름을 MemberController로 전달하는 객체(DTO?)
 */
