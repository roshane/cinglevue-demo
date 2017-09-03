package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by roshane on 9/3/17.
 */
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiResponse<?>> handleAllErrors(Throwable t) {
        return new ApiResponse.Builder<>()
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .withMessage(t.getMessage())
                .build();
    }
}
