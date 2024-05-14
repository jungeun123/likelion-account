package com.example.account.util.controller;

import com.example.account.util.dto.MemberSignupDto;
import com.example.account.util.response.CustomApiResponse;
import com.example.account.util.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private  final MemberService memberService;

    // 회원가입
    @PostMapping("sign-up")
    public ResponseEntity<CustomApiResponse<?>> signup(@RequestBody MemberSignupDto dto) {
        ResponseEntity<CustomApiResponse<?>> result = memberService.signup(dto);
        return result;
    }

    // 로그인

    // 회원탈퇴
}
