package com.spring_training.repository;

import com.spring_training.domain.Member;
import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
