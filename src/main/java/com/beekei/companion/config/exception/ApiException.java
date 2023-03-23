package com.beekei.companion.config.exception;

import com.beekei.companion.presentation.payload.ResponseType;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ResponseType responseType;
    private final String message;

    public ApiException(ResponseType responseType) {
        this.responseType = responseType;
        this.message = responseType.getDefaultMessage();
    }

    public ApiException(ResponseType responseType, String message) {
        this.responseType = responseType;
        this.message = message;
    }

}
