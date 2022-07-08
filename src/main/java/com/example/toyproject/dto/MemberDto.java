package com.example.toyproject.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberDto {

    @NotBlank(message = "이름 입력은 필수 입니다.")
    private String name;

    @NotEmpty(message = "비밀번호 입력은 필수 입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
    private String password;

    @NotEmpty(message = "이메일 입력은 필수 입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "주소 입력은 필수 입니다.")
    private String address;
}
