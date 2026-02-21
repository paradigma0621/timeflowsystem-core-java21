package com.paradigma0621.core.service;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import com.paradigma0621.core.exception.ResourceNotFoundException;
import com.paradigma0621.core.repository.person.PersonRepository;
import com.paradigma0621.core.service.person.PersonService;
import com.paradigma0621.core.service.commons.parameters.QueryParameterMountPersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    QueryParameterMountPersonService queryParameterMountPersonService;

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService service;

    @Test
    void deveRetornarPersonComSucessoQuandoOMesmoEEncontrado() {
        var personId = 1L;
        var customerId = 12L;
        var expected = new PersonDto(personId, "Oswaldo", now(), "1AB23", 1L, 1L, false, LocalDate.now(), now());
        when(queryParameterMountPersonService.mountFindPersonDto(anyLong(), anyLong()))
                .thenReturn(new QueryParameterDto("sql", null));
        when(personRepository.findById(any())).thenReturn(Optional.of(expected));

        var actual = service.findBy(personId, customerId);

        assertEquals(expected, actual);
        verify(queryParameterMountPersonService, times(1)).mountFindPersonDto(anyLong(),
                                                                                                      anyLong());
        verify(personRepository, times(1)).findById(any());
    }

    @Test
    void deveLancarExcecaoDePersonNaoEncontradoComStatus404() {
        var nonExistentPersonId = 9999L;
        var customerId = 1L;

        when(queryParameterMountPersonService.mountFindPersonDto(anyLong(), anyLong()))
                .thenReturn(new QueryParameterDto("sql", null));
        when(personRepository.findById(any())).thenReturn(Optional.empty());

        var ex = assertThrows(ResourceNotFoundException.class,
                () -> service.findBy(nonExistentPersonId, customerId));
        assertEquals("Person not found", ex.getMessage());
        verify(queryParameterMountPersonService, times(1)).mountFindPersonDto(anyLong(), anyLong());
        verify(personRepository, times(1)).findById(any());
    }

}
