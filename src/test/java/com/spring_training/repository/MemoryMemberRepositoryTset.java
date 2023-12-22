// package com.spring_training.repository;

// import java.util.List;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.Test;

// import com.spring_training.domain.member.Member;

// import static org.assertj.core.api.Assertions.*;

// class MemoryMemberRepositoryTset {
//     MemoryMemberRepository memberRepository = new MemoryMemberRepository();

//     @AfterEach
//     public void afterEach() {
//         memberRepository.clearStore();
//         /*
//         현재 테스트코드에 member1의 kymin과 member2의 kyoung-min처럼 같은 인스턴스에 같은 값을
//         가진 경우에 단위별 테스트에서는 문제가 없으나 전체 테스트에서 오류가 나는 경우가 있으므로 
//         단위 테스트가 끝날 때마다 특정 작업을 수행하는 AfterEach를 통해 인스턴스를 초기화한다.
//         이는 테스트가 순서나 의존관계에 상관없이 동작하도록 설계되어야 한다는 점에서 중요하다.
//         */
//     }

//     @Test
//     public void save() {
//         Member member = new Member();
//         member.setName("kymin");
//         memberRepository.save(member);
//         Member result = memberRepository.findById(member.getId()).get();
//         assertThat(member).isEqualTo(result);
//     }

//     // @Test
//     // public void findById() {
//     //     memberRepository.
//     // }

//     @Test
//     public void findByName() {
//         Member member1 = new Member();
//         member1.setName("kymin");
//         memberRepository.save(member1);

//         Member member2 = new Member();
//         member2.setName("kyoung-min");
//         memberRepository.save(member2);

//         Member result = memberRepository.findByName("kymin").get();

//         assertThat(member1).isEqualTo(result);
//     }

//     @Test
//     public void findAll() {
//         Member member1 = new Member();
//         member1.setName("kymin");
//         memberRepository.save(member1);

//         Member member2 = new Member();
//         member2.setName("kyoung-min");
//         memberRepository.save(member2);

//         List<Member> result = memberRepository.findAll();

//         assertThat(result).containsOnly(member1, member2);
//     }
// }
