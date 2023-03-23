package com.beekei.companion.application.impl;

import com.beekei.companion.application.ClientMemberUpdateService;
import com.beekei.companion.application.dto.ClientMemberUpdateDTO;
import com.beekei.companion.application.dto.MemberUpdateDTO;
import com.beekei.companion.domain.member.client.ClientMember;
import com.beekei.companion.domain.member.client.ClientMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Primary
@Component
@RequiredArgsConstructor
public class ClientMemberUpdateServiceImpl implements ClientMemberUpdateService {

    private final ClientMemberRepository clientMemberRepository;

    @Override
    public Optional<ClientMember> getMember(Long memberId) {
        return clientMemberRepository.findById(memberId);
    }

    @Override
    public void updateMember(ClientMember member, MemberUpdateDTO memberUpdateDTO) {
        final ClientMemberUpdateDTO clientMemberUpdateDTO = (ClientMemberUpdateDTO) memberUpdateDTO;
        member.updateInfo(clientMemberUpdateDTO.getNickname());
    }

}
