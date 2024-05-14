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
public class MemberLoginDto {
    @NotEmpty(message = "userId를 입력하세요.")
    private String userId;

    @NotEmpty(message = "password를 입력하세요.")
    private String password;
}
