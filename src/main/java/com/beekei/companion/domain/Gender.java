package com.beekei.companion.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Gender {

    M("남"),
    W("여");

    private final String description;

}
