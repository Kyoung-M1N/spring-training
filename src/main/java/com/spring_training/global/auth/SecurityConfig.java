package com.spring_training.global.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // csrf사용 안 함
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/api/**", "/error")
                        .permitAll()
                        // .anyRequest().hasAnyAuthority("USER"))
                        .anyRequest().authenticated())
                .sessionManagement((customize -> customize.disable()))
                .formLogin((customize -> customize
                        .usernameParameter("email")
                        .passwordParameter("password")));
                // .formLogin(custom -> custom.disable())
                // .logout((customize -> customize
                //         .logoutUrl("/logout")
                //         .logoutSuccessUrl("/")));
        // localhost:8080의 모든 경로에 대한 접근 허용
        return http.build();
    } // SecurityFilterChain으로 주어진 기능을 통해 코드로 설정

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
