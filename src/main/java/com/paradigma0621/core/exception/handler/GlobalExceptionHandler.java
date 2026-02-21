package com.paradigma0621.core.exception.handler;

import com.paradigma0621.core.exception.BusinessException;
import com.paradigma0621.core.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ProblemDetail> nullPointerExceptionHandler(NullPointerException ex) {
        log.error("NullPointerException in handler: ", ex);

        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pd.setTitle("Unexpected error");
        pd.setDetail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(pd);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ProblemDetail> handleBusinessException(BusinessException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        log.error("BusinessException in handler: ", ex);

        ProblemDetail pd = ProblemDetail.forStatusAndDetail(
                status,
                (ex.getMessage() == null || ex.getMessage().isBlank())
                        ? "Error BusinessException in global exception handler."
                        : ex.getMessage()
        );
        pd.setTitle("Business rule violation");
        pd.setProperty("code", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(status).body(pd);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        log.error("ResourceNotFoundException in handler: ", ex);

        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pd.setTitle("Not found resource");
        pd.setDetail(ex.getMessage());
        pd.setProperty("code", 404L);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pd);
    }

}
