package com.beekei.companion.config.exception;

import com.beekei.companion.presentation.payload.VoidResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<VoidResponse> apiExceptionHandler(ApiException e) {
        final VoidResponse response = new VoidResponse(e.getResponseType(), e.getMessage());
        final HttpStatus httpStatus = e.getResponseType().getHttpStatus();
        return new ResponseEntity<>(response, httpStatus);
    }

}
