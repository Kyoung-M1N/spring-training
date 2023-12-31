package com.spring_training.domain.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder    //객체 생성 시 builder패턴 사용
@AllArgsConstructor //builder를 사용하기 위한 생성자(매개변수 있음) 자동 생성
@NoArgsConstructor  //조회를 위한 생성자(매개변수 없음) 자동 생성
/*
 * @Entity어노테이션을 통해 해당 클래스를 DB에 접근하기 위한 Entity로써 mapping한다.
 * 해당 entity는 jpa가 관리하게 된다.
 */
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
     * @Id를 통해 해당 필드를 pirmary key와 mapping한다.
     * IDENTITY는 DB가 자동으로 생성해주는 값이라는 의미이다.
     */
    private long id;
    private String name;
    private String email;
    private String password;
}
