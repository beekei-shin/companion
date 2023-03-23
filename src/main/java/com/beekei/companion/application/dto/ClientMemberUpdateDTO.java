package com.beekei.companion.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class ClientMemberUpdateDTO implements MemberUpdateDTO {

    private final long memberId;

    private final String nickname;

    public static MemberUpdateDTO create(long memberId, String nickname) {
        return ClientMemberUpdateDTO.builder()
            .memberId(memberId)
            .nickname(nickname)
            .build();
    }

}
