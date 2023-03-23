package com.beekei.companion.domain.pet;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PetType {

    DOG("강아지"),
    CAT("고양이"),
    BIRD("조류"),
    REPTILE("파충류"),
    INSECT("곤충"),
    ETC("기타");

    private final String description;

}
