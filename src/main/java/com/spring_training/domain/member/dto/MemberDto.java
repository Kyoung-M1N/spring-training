package com.spring_training.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
/*
 * @Data 어노테이션은 객체가 가지고 있는 모든 필드에 대한 getter와 toString을 자동으로 생성해준다.
 * 또한 final로 선언되지 않은 필드에 한해 setter도 자동으로 생성해준다.
 */
@AllArgsConstructor
public class MemberDto {
    private String name;
    private String email;
    private String password;
}
/*
 * /members/new에서 입력받은 이름을 MemberController로 전달하는 객체(DTO?)
 */
