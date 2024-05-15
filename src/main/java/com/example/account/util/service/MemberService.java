package com.example.account.util.service;

import com.example.account.util.domain.Members;
import com.example.account.util.dto.MemberLoginDto;
import com.example.account.util.dto.MemberSignupDto;
import com.example.account.util.dto.MemberWithdrawDto;
import com.example.account.util.repository.MemberRepository;
import com.example.account.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public ResponseEntity<CustomApiResponse<?>> signup(MemberSignupDto dto) {
        // 회원 존재 여부
        Optional<Members> byUserId = memberRepository.findByUserId(dto.getUserId());

        // 동일한 userId 가지고 있으면 회원가입 불가
        if(byUserId.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(CustomApiResponse.createFailWithoutData(HttpStatus.BAD_REQUEST.value(), "중복된 아이디입니다."));
        }

        // 동일한 userId 없으면 회원가입
        Members newMember = Members.builder()
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();

        // 새로운 member 저장하기
        memberRepository.save(newMember);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CustomApiResponse.createSuccess(HttpStatus.CREATED.value(), null, "회원가입에 성공하였습니다."));
    }

    public ResponseEntity<CustomApiResponse<?>> login(MemberLoginDto dto) {
        Optional<Members> byUserId = memberRepository.findByUserId(dto.getUserId());
        Optional<Members> byPassword = memberRepository.findByUserId(dto.getPassword());

        if(byUserId.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(CustomApiResponse.createFailWithoutData(HttpStatus.BAD_REQUEST.value(), "존재하지 않는 회원입니다."));
        }

        else if(byPassword.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(CustomApiResponse.createFailWithoutData(HttpStatus.BAD_REQUEST.value(), "비밀번호가 일치하지 않습니다."));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "로그인에 성공했습니다."));
    }

    public ResponseEntity<CustomApiResponse<?>> withdraw(MemberWithdrawDto dto) {
        Optional<Members> byUserId = memberRepository.findByUserId(dto.getUserId());

        if(byUserId.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(CustomApiResponse.createFailWithoutData(HttpStatus.NOT_FOUND.value(), "id가" + dto.getUserId() +"인 회원은 존재하지 않습니다."));
        }

        memberRepository.delete(byUserId.get());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원이 정상적으로 탈퇴되었습니다."));
    }
}

