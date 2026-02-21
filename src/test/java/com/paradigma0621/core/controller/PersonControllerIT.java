package com.paradigma0621.core.controller;

import com.paradigma0621.core.helper.TestIntegrationHelper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static com.paradigma0621.core.controller.PersonCommon.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

class PersonControllerIT  extends TestIntegrationHelper {

    private static final String URI = "/persons/{personId}/by-customer";

    @Test
    @Sql(value = "/data/person/one-person-population.sql", executionPhase = BEFORE_TEST_METHOD)
    @Sql(value = "/data/person/drop-person-table.sql", executionPhase = AFTER_TEST_METHOD)
    void deveBuscarEEncontrarPessoa() {
        var expected = RESPONSE_PERSON_ONE_REGISTER;
        var parameter = new Parameter(expected, 1L, 12L);
        whenAndThen(parameter);
    }

    @Test
    @Sql(value = "/data/person/empty-person-table.sql", executionPhase = BEFORE_TEST_METHOD)
    @Sql(value = "/data/person/drop-person-table.sql", executionPhase = AFTER_TEST_METHOD)
    void deveRetornarProblemDetailQuandoDisparaBusinessException() {

        String expected = RESPONSE_NO_PERSON_FOUND;

        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(URI)
                        .queryParam("customerId", 999L)
                        .build(500L))
                .accept(MediaType.APPLICATION_PROBLEM_JSON)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .json(expected, false);
    }

    private void whenAndThen(Parameter parameter) {
        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(URI)
                        .queryParam("customerId", parameter.customerId)
                        .build(parameter.personId))
                .accept(MediaType.APPLICATION_PROBLEM_JSON)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .json(parameter.payload);
    }

    record Parameter(String payload, Long personId, Long customerId) {
    }

}