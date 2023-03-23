package com.beekei.companion.config.exception;

import com.beekei.companion.presentation.payload.ResponseType;
import lombok.Getter;

@Getter
public class NotExistDataException extends ApiException{

    public NotExistDataException() {
        super(ResponseType.NOT_EXIST_DATA);
    }

    public NotExistDataException(String message) {
        super(ResponseType.NOT_EXIST_DATA, message);
    }

}
