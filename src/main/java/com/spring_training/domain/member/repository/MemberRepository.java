package com.spring_training.domain.member.repository;

import java.util.Optional;

import com.spring_training.domain.member.Member;

import java.util.List;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
