package com.beekei.companion.presentation.clientMember.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientMemberUpdateRequest {

    @NotBlank
    @Length(min = 1, max = 20)
    private String nickname;

}
