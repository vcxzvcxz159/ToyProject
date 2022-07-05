package com.example.toyproject.domain.repository;

import com.example.toyproject.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
