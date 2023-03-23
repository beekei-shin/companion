package com.beekei.companion.application;

import com.beekei.companion.application.dto.MemberJoinDTO;
import com.beekei.companion.config.exception.DuplicateDataException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface MemberJoinService extends MemberDuplicateCheckService {

    default void apply(MemberJoinDTO memberJoinDTO) {
        // 이메일 중복 검사
        if (this.emailDuplicateCheck(memberJoinDTO.getEmail()))
            throw new DuplicateDataException("Duplicate email");
        // 닉네임 중복 검사
        if (this.nicknameDuplicateCheck(memberJoinDTO.getNickname()))
            throw new DuplicateDataException("Duplicate nickname");
        // 회원 저장
        this.memberSave(memberJoinDTO);
    }

    @Transactional
    void memberSave(MemberJoinDTO memberJoinDTO);

}
