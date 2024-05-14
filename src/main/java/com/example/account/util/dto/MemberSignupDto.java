package com.example.account.util.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignupDto {
    @NotEmpty(message = "userId는 필수값입니다.")
    private String userId;

    @NotEmpty(message = "password는 필수값입니다.")
    private String password;

    @Email(message = "이메일 형식을 맞춰주세요.")
    private String email;

    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$", message = "전화번호 형식을 맞춰주세요.")
    private String phone;
}
