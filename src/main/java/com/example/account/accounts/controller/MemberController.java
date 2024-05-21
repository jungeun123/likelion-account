package com.example.account.accounts.controller;

import com.example.account.accounts.dto.MemberLoginDto;
import com.example.account.accounts.dto.MemberSignupDto;
import com.example.account.accounts.service.MemberService;
import com.example.account.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 회원가입
    @PostMapping("sign-up")
    public ResponseEntity<CustomApiResponse<?>> signup(@Valid @RequestBody MemberSignupDto dto) {
        ResponseEntity<CustomApiResponse<?>> result = memberService.signup(dto);
        return result;
    }

    // 로그인
    @PostMapping("login")
    public ResponseEntity<CustomApiResponse<?>> login(@Valid @RequestBody MemberLoginDto dto) {
        ResponseEntity<CustomApiResponse<?>> result = memberService.login(dto);
        return result;
    }

    // 회원탈퇴
    @DeleteMapping("withdraw/{userId}")
    public ResponseEntity<CustomApiResponse<?>> withdraw(@PathVariable String userId) {
        ResponseEntity<CustomApiResponse<?>> result = memberService.withdraw(userId);
        return result;
    }
}
