package com.example.toyproject;

import com.example.toyproject.domain.entity.Member;
import com.example.toyproject.dto.MemberDto;
import com.example.toyproject.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(){
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail("vcxzvcxz159@gmail.com");
        memberDto.setName("전창현");
        memberDto.setAddress("서울시 마포구 합정동");
        memberDto.setPassword("1234");
        return Member.createmember(memberDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAddress(), savedMember.getAddress());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getRole(), savedMember.getRole());
    }
}
