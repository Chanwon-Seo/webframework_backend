package com.scw.webframework_backend.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginDto {

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private Long memberNumber;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
}
