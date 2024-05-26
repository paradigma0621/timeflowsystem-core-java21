package com.paradigma0621.core.service;

import com.paradigma0621.core.controller.PersonController;
import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import com.paradigma0621.core.repository.person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Optional;

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
    void testGetExistentPerson() {
        Long personId = 1L;
        var expected = new PersonDto(personId, "Oswaldo");
        when(personRepository.findPersonNameById(any())).thenReturn(Optional.of(expected));

        var actual = service.findById(personId);

        assertEquals(expected, actual);
        verify(queryParameterMountPersonService, times(1)).mountFindPersonDto(anyLong());
        verify(personRepository, times(1)).findPersonNameById(any());
    }

    @Test
    void testGetNonExistentPerson() {
        Long nonExistentPersonId = 9999L;
        var expected = new PersonDto(0L, "No one with this id");
        when(personRepository.findPersonNameById(any())).thenReturn(Optional.empty());

        var actual = service.findById(nonExistentPersonId);

        assertEquals(expected, actual);
        verify(queryParameterMountPersonService, times(1)).mountFindPersonDto(anyLong());
        verify(personRepository, times(1)).findPersonNameById(any());
    }

}
