package com.project.tokoonline.exception;

import com.project.tokoonline.response.ResponUserHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException){
        return ResponUserHelper.error(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<?> internalError(InternalErrorException internalErrorException){
        return ResponUserHelper.error(internalErrorException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
