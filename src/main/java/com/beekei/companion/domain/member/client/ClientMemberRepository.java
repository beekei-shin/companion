package com.beekei.companion.domain.member.client;

import com.beekei.companion.domain.member.Member;

import java.util.Optional;

public interface ClientMemberRepository {
    ClientMember save(ClientMember clientMember);
    Optional<ClientMember> findById(Long memberId);
}
