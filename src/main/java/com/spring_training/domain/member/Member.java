package com.spring_training.domain.member;

import java.util.List;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder // 객체 생성 시 builder패턴 사용
@AllArgsConstructor // builder를 사용하기 위한 생성자(매개변수 있음) 자동 생성
@NoArgsConstructor // 조회를 위한 생성자(매개변수 없음) 자동 생성
/*
 * @Entity어노테이션을 통해 해당 클래스를 DB에 접근하기 위한 Entity로써 mapping한다.
 * 해당 entity는 jpa가 관리하게 된다.
 */
public class Member implements UserDetails {
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
    // private Collection<GrantedAuthority> authorities; // 권한목록

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("admin"));
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부 : 만료 안됨
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠김 여부: 잠기지 않음
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호 만료 여부 : 만료 안됨
    }

    @Override
    public boolean isEnabled() {
        return true; // 활성화 여부 : 활성화됨
    }

    public String getEmail() {
        return email;
    }

}
