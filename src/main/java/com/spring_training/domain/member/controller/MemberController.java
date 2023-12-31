package com.spring_training.domain.member.controller;

import java.util.List;

import com.spring_training.domain.member.Member;
import com.spring_training.domain.member.dto.MemberDto;
import com.spring_training.domain.member.service.MemberService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.beans.factory.annotation.Autowired;

// controller가 외부 요청을 받고, 응답을 리턴
// service에서 비즈니스 로직 구현
// repository에서 데이터를 저장 및 관리

/*
 * controller가 memberService에 의존하고 service가 repository에 의존하기
 * 때문에 어노테이션을 통해 스프링 빈에 등록 
 * 기본적으로 같은 패키지(또는 하위)에 포함된 클래스만 컴포넌트 스캔이 된다.
 * component 스캔방법으로 스프링 빈 등록 @Component로도 가능하며 @Service, @Repository,
 * @Controller는 @Component를 포함하고 있다.
 * 기본적으로 스프링빈에 등록된 객체는 싱글톤으로 등록되기 때문에 같은 인스턴스를 사용한다.
 */
@Controller //component 스캔 방법으로 스프링빈 등록
public class MemberController {
    private final MemberService memberService;

    // controller가 MemberService에 의존하기 때문에 스프링 빈에 등록된 객체를 
    // 스프링 컨테이너에서 찾아 넣어준다.(의존성 주입)
    // @Autowired  // 생성자가 하나인 경우 생략 가능
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    // get요청으로 "/members/new"가 조회될 때 아래의 함수가 실행됨
    public String createForm() {
        return "members/createMemberForm";
    }
    
    @PostMapping(value = "/members/new")
    // post로 값을 받아오기 위해 @PostMapping어노테이션 사용
    // "/members/new"라는 경로에서 post요청이 발생하면 아래의 함수가 호출됨
    // 이때 MemberForm의 setName이 자동으로 호출되고 입력받은 name의 값이 전달됨
    public String create(MemberDto memberDto) {
        memberService.signUp(memberDto);

        return "redirect:/"; // "/"의 경로로 복귀시킴
    }
    
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
/*
 * controller는 주로 service와 repository등에서 데이터를 가져와 view에 전송하는 역할을 한다.
 * 따라서 controller는 service와 repository등에 의존한다.
 * @controller를 통해 스프링은 동작시에 스프링 컨테이너에 controller객체를 스프링 빈으로 등록된다.
 * 스프링빈으로 등록된 객체는 스프링이 관리한다.
 */
