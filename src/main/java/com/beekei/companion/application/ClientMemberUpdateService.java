package com.beekei.companion.application;

import com.beekei.companion.domain.member.client.ClientMember;
import org.springframework.stereotype.Service;

@Service
public interface ClientMemberUpdateService extends MemberUpdateService<ClientMember> {
}
