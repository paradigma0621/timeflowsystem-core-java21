package com.paradigma0621.core.exception.handler;

import com.paradigma0621.core.dto.ResponseDto;
import com.paradigma0621.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> nullPointerException(NullPointerException ex) {
        log.error("message", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error in global exception handler: " + ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseDto> businessExceptionHandler(BusinessException ex) {
        log.error("BusinessException in handler: ", ex);

        ResponseDto<Object> response = new ResponseDto<>(
                400L,
                "Error in global exception handler: " + ex.getMessage(),
                null,
                Collections.emptyList()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
