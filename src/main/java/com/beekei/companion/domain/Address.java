package com.beekei.companion.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Address {

    @Column(name = "zip_code", length = 50, nullable = false)
    private String zipCode;

}
