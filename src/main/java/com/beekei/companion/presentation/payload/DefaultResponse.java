package com.beekei.companion.presentation.payload;

import lombok.Getter;

@Getter
public class DefaultResponse {

    private final int code;
    private final String message;

    public DefaultResponse(ResponseType responseType) {
        this.code = responseType.getCode();
        this.message = responseType.getDefaultMessage();
    }

    public DefaultResponse(ResponseType responseType, String message) {
        this.code = responseType.getCode();
        this.message = message;
    }

}
