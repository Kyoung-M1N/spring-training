package com.spring_training.global.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring_training.domain.member.Member;
import com.spring_training.domain.member.repository.MemberRepository;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {
    private MemberRepository repository;

    public UserServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = repository.findByEmail(email).get();
        return member;
    }
}
