package com.seymur.fileupload.exception.model;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidImageType  extends RuntimeException{
    public InvalidImageType() {
        super();
    }

    public InvalidImageType(String message) {
        super(message);
    }
}
