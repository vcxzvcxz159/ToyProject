package com.example.toyproject.domain.entity;

import com.example.toyproject.constant.Role;
import com.example.toyproject.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;
    private String name;

    private String email;

    private String address;

    private Role role;

    public static Member createmember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setAddress(memberDto.getAddress());
        member.setPassword(passwordEncoder.encode(memberDto.getPassword())); // password encode
        member.setRole(Role.USER);
        return member;
    }
}
