package com.spring_training.domain.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_training.domain.member.Member;

/*
 * JpaRepository를 상속받고있는 인터페이스가 있으면 SpringDataJpa가 구현체를 자동으로 만들고 스프링빈에
 * 등록해준다.
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    @Override
    // JpaRepository에 기본적인 CRUD기능과 페이징 기능이 포함되어있기 때문에
    // findByName(), findByEmail()처럼 메서드 이름 만으로 기능을 제공한다.
    Optional<Member> findByEmail(String email);
}
