package com.beekei.companion.application;

import com.beekei.companion.application.dto.MemberUpdateDTO;
import com.beekei.companion.config.exception.NotExistDataException;
import com.beekei.companion.domain.member.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public interface MemberUpdateService<U> {

    default void apply(MemberUpdateDTO memberUpdateDTO) {
        getMember(memberUpdateDTO.getMemberId()).ifPresentOrElse(
            member -> this.updateMember(member, memberUpdateDTO),
            () -> { throw new NotExistDataException("Not exist member"); });
    }

    @Transactional(readOnly = true)
    Optional<U> getMember(Long memberId);

    @Transactional
    void updateMember(U member, MemberUpdateDTO memberUpdateDTO);

}
