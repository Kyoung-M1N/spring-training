package com.spring_training.domain.member.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.spring_training.domain.member.Member;
import com.spring_training.domain.member.dto.MemberDto;
import com.spring_training.domain.member.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberApiController {

    private final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }
    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<Member> signup(@RequestBody MemberDto dto) {
        return ResponseEntity.ok(memberService.signUp(dto));
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Member> login(@RequestBody MemberDto dto) {
        return ResponseEntity.ok(memberService.findOne(dto));
    }
}
