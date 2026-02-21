package com.paradigma0621.core.exception.handler;

import com.paradigma0621.core.exception.BusinessException;
import com.paradigma0621.core.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleBusinessExceptionQuandoMensagemInformadaUsaMensagemEBadRequest() {
        BusinessException ex = new BusinessException("Invalid data");

        ResponseEntity<ProblemDetail> response = handler.handleBusinessException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        ProblemDetail body = response.getBody();
        assertNotNull(body);
        assertEquals("Invalid data", body.getDetail());
        assertEquals("Business rule violation", body.getTitle());
        assertEquals(HttpStatus.BAD_REQUEST.value(), body.getProperties().get("code"));
    }

    @Test
    void nullPointerExceptionHandlerRetornaProblemDetailComErroInterno() {
        NullPointerException ex = new NullPointerException("missing");

        ResponseEntity<ProblemDetail> response = handler.nullPointerExceptionHandler(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        ProblemDetail body = response.getBody();
        assertNotNull(body);
        assertEquals("Unexpected error", body.getTitle());
        assertEquals("missing", body.getDetail());
    }

    @Test
    void resourceNotFoundExceptionHandlerRetornaHttpStatus404EProblemDetail() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Person not found");

        ResponseEntity<ProblemDetail> response = handler.resourceNotFoundExceptionHandler(ex);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        ProblemDetail pd = response.getBody();
        assertNotNull(pd);

        assertEquals(HttpStatus.NOT_FOUND.value(), pd.getStatus());
        assertEquals("Not found resource", pd.getTitle());
        assertEquals("Person not found", pd.getDetail());

        Object code = pd.getProperties().get("code");
        assertNotNull(code);
        assertEquals(404L, code);
    }
}
