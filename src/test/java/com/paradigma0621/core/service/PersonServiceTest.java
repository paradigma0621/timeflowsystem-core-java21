package com.paradigma0621.core.service;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import com.paradigma0621.core.repository.person.PersonRepository;
import com.paradigma0621.core.service.person.PersonService;
import com.paradigma0621.core.service.commons.parameters.QueryParameterMountPersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void testGetExistentPerson() {
        Long personId = 1L;
        var expected = new PersonDto(personId, "Oswaldo", now(), "1AB23", 1L, 1L, false);
        when(queryParameterMountPersonService.mountFindPersonDto(anyLong())).thenReturn(new QueryParameterDto("sql", null));
        when(personRepository.findPersonNameById(any())).thenReturn(Optional.of(expected));

        var actual = service.findById(personId);

        assertEquals(expected, actual);
        verify(queryParameterMountPersonService, times(1)).mountFindPersonDto(anyLong());
        verify(personRepository, times(1)).findPersonNameById(any());
    }

    @Test
    void testGetNonExistentPerson() {
        Long nonExistentPersonId = 9999L;
        var expected = new PersonDto(0L, "No one with this id", null, "0", 0L, 0L, false);
        when(queryParameterMountPersonService.mountFindPersonDto(anyLong())).thenReturn(new QueryParameterDto("sql", null));
        when(personRepository.findPersonNameById(any())).thenReturn(Optional.empty());

        var actual = service.findById(nonExistentPersonId);

        assertEquals(expected, actual);
        verify(queryParameterMountPersonService, times(1)).mountFindPersonDto(anyLong());
        verify(personRepository, times(1)).findPersonNameById(any());
    }

}
