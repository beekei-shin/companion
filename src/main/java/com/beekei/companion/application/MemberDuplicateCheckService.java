package com.beekei.companion.application;

import com.beekei.companion.domain.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface MemberDuplicateCheckService {

    @Transactional(readOnly = true)
    default boolean emailDuplicateCheck(MemberRepository memberRepository, String email) {
        return memberRepository.findByEmail(email).isPresent();
    }

    @Transactional(readOnly = true)
    default boolean nicknameDuplicateCheck(MemberRepository memberRepository, String nickname) {
        return memberRepository.findByNicknameAndIsDeleted(nickname, false).isPresent();
    }

}
