package com.beekei.companion.config.exception;

import com.beekei.companion.presentation.payload.ResponseType;
import lombok.Getter;
@Getter
public class DuplicateDataException extends ApiException {

    public DuplicateDataException() {
        super(ResponseType.DUPLICATE_DATA);
    }

    public DuplicateDataException(String message) {
        super(ResponseType.DUPLICATE_DATA, message);
    }

}
