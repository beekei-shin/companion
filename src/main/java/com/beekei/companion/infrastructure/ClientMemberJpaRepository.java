package com.beekei.companion.infrastructure;

import com.beekei.companion.domain.member.client.ClientMember;
import com.beekei.companion.domain.member.client.ClientMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientMemberJpaRepository extends JpaRepository<ClientMember, Long>, ClientMemberRepository {
}
