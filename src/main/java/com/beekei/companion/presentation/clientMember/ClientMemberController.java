package com.beekei.companion.presentation.clientMember;

import com.beekei.companion.application.ClientMemberJoinService;
import com.beekei.companion.application.ClientMemberUpdateService;
import com.beekei.companion.application.dto.ClientMemberJoinDTO;
import com.beekei.companion.application.dto.ClientMemberUpdateDTO;
import com.beekei.companion.presentation.clientMember.payload.ClientMemberJoinRequest;
import com.beekei.companion.presentation.clientMember.payload.ClientMemberUpdateRequest;
import com.beekei.companion.presentation.payload.ResponseType;
import com.beekei.companion.presentation.payload.VoidResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "member/client")
@RequiredArgsConstructor
public class ClientMemberController {

    private final ClientMemberJoinService clientMemberJoinService;

    private final ClientMemberUpdateService clientMemberUpdateService;

    @PostMapping(name = "사용자 회원 가입", consumes = MediaType.APPLICATION_JSON_VALUE)
    public VoidResponse clientMemberJoin(@RequestBody @Valid ClientMemberJoinRequest request) {
        System.out.println("사용자 회원 가입");
        clientMemberJoinService.apply(ClientMemberJoinDTO.create(request.getEmail(), request.getPassword(), request.getNickname()));
        return new VoidResponse(ResponseType.SUCCESS);
    }

    @PutMapping(name = "사용자 회원 수정", value = "{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public VoidResponse clientMemberUpdate(@PathVariable Long memberId, @RequestBody @Valid ClientMemberUpdateRequest request) {
        System.out.println("사용자 회원 수정");
        clientMemberUpdateService.apply(ClientMemberUpdateDTO.create(memberId, request.getNickname()));
        return new VoidResponse(ResponseType.SUCCESS);
    }


}
