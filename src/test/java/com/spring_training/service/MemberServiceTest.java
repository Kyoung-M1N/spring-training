package com.spring_training.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.spring_training.domain.Member;
import com.spring_training.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    MemoryMemberRepository memberRepository;
    MemberService service;
    /*
     * 아래의 코드로 테스트를 수행하면 memberService가 사용하는 MemoryMemberRepository와
     * 테스트 코드에서 회원 데이터를 조회하는 MemoryMemberRepository의 인스턴스가 다르기 때문에
     * 유효하지 않은 검증이 될 수도 있다.
     * 따라서 memberService의 생성자를 통해 MemoryMemberRepository를 전달하여
     * memberService가 사용하는 MemoryMemberRepository와 테스트 코드에서 회원 데이터를 조회하는 
     * MemoryMemberRepository의 인스턴스가 같도록 만들어 준다.
     * 이 때 MemberService는 생성자를 통해 MemoryMemberRepository에 대한 의존성을 주입받는다.(DI)
     */

    // MemoryMemberRepository memberRepository = new MemberRepository();
    // MemberService service = new MemberService();

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        service = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("회원가입 기능 테스트")
    public void signUpTest() {
        // given
        Member member = new Member();
        member.setName("kymin");

        // when
        long savedId = service.signUp(member);

        // then
        long result = memberRepository.findById(savedId).get().getId();
        assertThat(result).isEqualTo(savedId);
    }

    @Test
    @DisplayName("중복된 이름 방지 기능 테스트")
    public void validateDuplicatedNameTest() {
        // given
        Member member1 = new Member();
        member1.setName("kymin");

        Member member2 = new Member();
        member2.setName("kymin");

        // when
        service.signUp(member1);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> service.signUp(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}

/*
 * 테스트코드를 직관적으로 이해할 수 있게 작성하려면 given, when, then의 순서로 작성하는 것이 좋다.
 * given : 주어진 소스 또는 데이터
 * when : 주어진 상황(테스트하려는 기능이 필요한)
 * then : 테스트 하려는 기능의 결과로 예상되는 값(비교 구문)
 * 알아보기 쉽게 주석을 달아주기도 한다.
 */