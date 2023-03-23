package com.beekei.companion.presentation.clientMember.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientMemberJoinRequest {

    @NotBlank
    @Length(min = 1, max = 100)
    private String email;

    @NotBlank
    @Length(min = 8, max = 30)
    private String password;

    @NotBlank
    @Length(min = 1, max = 20)
    private String nickname;

}
