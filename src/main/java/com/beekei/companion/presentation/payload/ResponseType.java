package com.beekei.companion.presentation.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseType {

    SUCCESS(HttpStatus.OK, 200, "Api call success"),
    NOT_EXIST_DATA(HttpStatus.INTERNAL_SERVER_ERROR, 501, "Not exist data"),
    DUPLICATE_DATA(HttpStatus.INTERNAL_SERVER_ERROR, 502, "Duplicate data");

    private final HttpStatus httpStatus;
    private final int code;
    private final String defaultMessage;

}
