package com.example.account.accounts.service;

import com.example.account.accounts.dto.MemberLoginDto;
import com.example.account.accounts.dto.MemberSignupDto;
import com.example.account.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity<CustomApiResponse<?>> signup(MemberSignupDto dto);

    ResponseEntity<CustomApiResponse<?>> login(MemberLoginDto dto);

    ResponseEntity<CustomApiResponse<?>> withdraw(String userId);
}

