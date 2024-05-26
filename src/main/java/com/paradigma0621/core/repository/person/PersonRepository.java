package com.paradigma0621.core.repository.person;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;

import java.util.*;

public interface PersonRepository {
    Optional<PersonDto> findPersonNameById(QueryParameterDto queryParameterDto);
}