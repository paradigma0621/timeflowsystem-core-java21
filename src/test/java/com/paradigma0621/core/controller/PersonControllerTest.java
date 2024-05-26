package com.paradigma0621.core.controller;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    PersonService service;

    @InjectMocks
    PersonController controller;

    @Test
    void testGetPersonName() {
        var personDto = new PersonDto(1L, "Oswaldo");
        when(service.findById(anyLong())).thenReturn(personDto);
        var expected = personDto.name();

        var actual = controller.getJdbcPersonName(1L);

        assertEquals(expected, actual);
        verify(service, times(1)).findById(anyLong());
    }

}
