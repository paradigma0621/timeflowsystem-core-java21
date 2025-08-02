package com.paradigma0621.core.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ResponseDto<T> {
    private Long code;
    private String message;
    private T value;
    private List<String> details;


    public ResponseDto(Long code, String message, T value) {
        this.code = code;
        this.message = message;
        this.value = value;
        this.details = Collections.emptyList();
    }

    public ResponseDto(Long code, String message, T value, List<String> details) {
        this.code = code;
        this.message = message;
        this.value = value;
        this.details = details;
    }
}