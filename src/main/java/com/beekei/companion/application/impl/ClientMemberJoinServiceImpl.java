package com.beekei.companion.application.impl;

import com.beekei.companion.application.ClientMemberJoinService;
import com.beekei.companion.application.dto.ClientMemberJoinDTO;
import com.beekei.companion.application.dto.MemberJoinDTO;
import com.beekei.companion.domain.member.MemberRepository;
import com.beekei.companion.domain.member.client.ClientMember;
import com.beekei.companion.domain.member.client.ClientMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Primary
@Component
@RequiredArgsConstructor
public class ClientMemberJoinServiceImpl implements ClientMemberJoinService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final ClientMemberRepository clientMemberRepository;

    @Override
    public boolean duplicateEmailCheck(MemberJoinDTO memberJoinDTO) {
        final ClientMemberJoinDTO clientMemberJoinDTO = (ClientMemberJoinDTO) memberJoinDTO;
        return memberRepository.findByEmail(clientMemberJoinDTO.getEmail()).isPresent();
    }

    @Override
    public boolean duplicateNicknameCheck(MemberJoinDTO memberJoinDTO) {
        final ClientMemberJoinDTO clientMemberJoinDTO = (ClientMemberJoinDTO) memberJoinDTO;
        return memberRepository.findByNicknameAndIsDeleted(clientMemberJoinDTO.getNickname(), false).isPresent();
    }

    @Override
    public void memberSave(MemberJoinDTO memberJoinDTO) {
        final ClientMemberJoinDTO clientMemberJoinDTO = (ClientMemberJoinDTO) memberJoinDTO;
        final ClientMember clientMember = ClientMember.create(
            clientMemberJoinDTO.getEmail(),
            passwordEncoder.encode(clientMemberJoinDTO.getPassword()),
            clientMemberJoinDTO.getNickname());
        clientMemberRepository.save(clientMember);
    }

}
