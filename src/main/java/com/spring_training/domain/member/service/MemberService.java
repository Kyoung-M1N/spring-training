package com.spring_training.domain.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring_training.domain.member.Member;
import com.spring_training.domain.member.dto.MemberDto;
import com.spring_training.domain.member.repository.MemberRepository;

@Service
@Transactional
/*
 * @Transactional은 특정 작업이 성공했을 경우에만 작업의 결과를 저장하도록 하는 어노테이션이다.
 * 작업이 실패했을 경우에는 작업의 내용이 저장되지 않으며 작업이 실행되기 이전의 상태와 같도록 유지한다.
 * DB에 접근하여 데이터에 대한 작업을 수행할 경우에는 항상 transactional을 해야 한다.
 */
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Member signUp(MemberDto memberDto) {
        validateDuplicatedEmail(memberDto);
        Member member = Member.builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .password(bCryptPasswordEncoder.encode(memberDto.getPassword()))
                .build();

        return memberRepository.save(member);
    }

    private void validateDuplicatedEmail(MemberDto memberDto) {
        memberRepository.findByEmail(memberDto.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                }); // 중복된 이메일 방지
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(MemberDto memberDto) {
        Optional<Member> result = memberRepository.findByEmail(memberDto.getEmail());
        return result.get();
    }
}
