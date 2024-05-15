package com.example.account.util.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberWithdrawDto {
    @NotEmpty(message = "userId는 필수값입니다.")
    private String userId;
}
