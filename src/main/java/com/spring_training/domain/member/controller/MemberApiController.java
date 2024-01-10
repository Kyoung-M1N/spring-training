package com.spring_training.domain.member.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring_training.domain.member.Member;
import com.spring_training.domain.member.dto.MemberDto;
import com.spring_training.domain.member.service.MemberService;

@RestController
// @RequestMapping("/api")
public class MemberApiController {

    private final MemberService memberService;
    private final UserDetailsService userService;

    public MemberApiController(MemberService memberService, UserDetailsService userService) {
        this.memberService = memberService;
        this.userService = userService;
    }
    
    @PostMapping("/api/signup")
    @ResponseBody
    public ResponseEntity<Member> signup(@RequestBody MemberDto dto) {
        return ResponseEntity.ok(memberService.signUp(dto));
    }

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseEntity<UserDetails> login(@RequestBody MemberDto dto) {
        // return ResponseEntity.ok(memberService.findOne(dto));
        return ResponseEntity.ok(userService.loadUserByUsername(dto.getEmail()));
    }
}
