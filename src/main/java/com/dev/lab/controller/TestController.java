package com.dev.lab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController  // ← 변경
public class TestController {

    @GetMapping("/me")  // / 빠져있었음
    public String me(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            log.error("로그인 안됨");
            return "로그인 안됨";
        }
        log.info("로그인 됨: {}", user.getAttributes().toString());
        return "로그인됨: " + user.getAttributes().toString();
    }
}