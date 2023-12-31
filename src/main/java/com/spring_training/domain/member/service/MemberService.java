package com.spring_training.domain.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.spring_training.domain.member.Member;
import com.spring_training.domain.member.dto.MemberDto;
import com.spring_training.domain.member.repository.MemberRepository;

@Transactional
/*
 * @Transaction미은 특정 작업이 성공했을 경우에만 작업의 결과를 저장하도록 하는 어노테이션이다.
 * 작업이 실패했을 경우에는 작업의 내용이 저장되지 않으며 작업이 실행되기 이전의 상태와 같도록 유지한다.
 * DB에 접근하여 데이터에 대한 작업을 수행할 경우에는 항상 transactional을 해야 한다.
 */
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member signUp(MemberDto memberDto) {
        validateDuplicatedName(memberDto);
        Member member = Member.builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .build();

        return memberRepository.save(member);
    }

    private void validateDuplicatedName(MemberDto memberDto) {
        memberRepository.findByName(memberDto.getName())
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
