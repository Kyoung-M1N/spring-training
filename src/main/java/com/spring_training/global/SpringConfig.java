// package com.spring_training.global;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.spring_training.domain.member.repository.MemberRepository;
// import com.spring_training.domain.member.service.MemberService;

// /*
//  * 스프링빈 등록 기능을 하는 클래스를 생성하고 @Configuration으로 스프링빈을 등록하는 클래스임을 선언
//  * @Configuration과 @Bean을 통해 스프링빈으로 등록할 클래스의 생성자를 이용하여 스프링빈을 등록
//  * 현재 코드에서 MemberRepository에 대한 구현클래스가 변경될 예정이므로 자바코드를 통해 스프링빈을 등록
//  */
// @Configuration // 자바 코드로 직접 스프링 빈 등록
// public class SpringConfig {
//     // SpringDataJpaMemberRepository가 MemberRepository를 상속받고 있으며 SpringDataJpa가 
//     // 자동으로 구현체를 만들어 스프링빈으로 등록하기 때문에 memberRepository인스턴스를 생성하고 의존성을 
//     // 주입할 수 있게 된다
//     private final MemberRepository memberRepository;
//     // private EntityManager entityManager;

//     // // @Autowired
//     // public SpringConfig(EntityManager entityManager) {
//     //     this.entityManager = entityManager;
//     // }

//     public SpringConfig(MemberRepository memberRepository) {
//         this.memberRepository = memberRepository;
//     }

//     // @Bean
//     // public MemberService memberService() {
//     //     // return new MemberService(memberRepository());
//     //     return new MemberService(memberRepository);
//     // }

//     // @Bean
//     // public MemberRepository memberRepository() {
//         // return new MemoryMemberRepository();
//         // return new JpaMemberRepository(entityManager);
//         // EntityManager를 주입한다.
//     // }
// }

// /*
//  * DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있다.
//  * 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장
//  * 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용
//  * 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 자바코드를 통해 스프링 빈으로 등록
//  * @Autowired를 통한 DI는 helloController, memberService등과 같이 스프링이 관리하는 객체에서만 동작
//  * 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
//  */