package com.spring_training.service;

import java.util.List;
import java.util.Optional;
import com.spring_training.domain.Member;
import com.spring_training.repository.MemberRepository;
import com.spring_training.repository.MemoryMemberRepository;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public long signUp(Member member) {
        validateDuplicatedName(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedName(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                }); // 중복된 이름 방지
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(long id) {
        return memberRepository.findById(id);
    }
}
