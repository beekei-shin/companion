package com.beekei.companion.presentation.payload;

import lombok.Getter;

@Getter
public class VoidResponse extends DefaultResponse {

    public VoidResponse(ResponseType responseType) {
        super(responseType);
    }

    public VoidResponse(ResponseType responseType, String message) {
        super(responseType, message);
    }

}
