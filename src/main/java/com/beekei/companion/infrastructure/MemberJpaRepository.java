package com.beekei.companion.infrastructure;

import com.beekei.companion.domain.member.Member;
import com.beekei.companion.domain.member.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long>, MemberRepository {
}
