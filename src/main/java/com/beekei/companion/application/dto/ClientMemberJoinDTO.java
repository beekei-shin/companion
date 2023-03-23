package com.beekei.companion.application.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class ClientMemberJoinDTO implements MemberJoinDTO {
    private final String email;
    private final String password;
    private final String nickname;

    public static ClientMemberJoinDTO create(String email, String password, String nickname) {
        return ClientMemberJoinDTO.builder()
            .email(email)
            .password(password)
            .nickname(nickname)
            .build();
    }

}
