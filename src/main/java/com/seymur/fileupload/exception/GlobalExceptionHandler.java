package com.seymur.fileupload.exception;

import com.seymur.fileupload.exception.model.InvalidImageType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(InvalidImageType.class)
    public ResponseEntity<?> handleInvalidImageTypeException(InvalidImageType ex){
        Map<String,Object> response=new HashMap<>();
        response.put("errorCode",400);
        response.put("errorMessage",ex.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
