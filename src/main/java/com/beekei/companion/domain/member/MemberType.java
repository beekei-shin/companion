package com.beekei.companion.domain.member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemberType {

    CLIENT("사용자", 10),
    BUSINESS("사업자", 20),
    ADMIN("관리자", 90),
    ROOT("사용자", 99);

    private final String description;
    private final int level;

}
