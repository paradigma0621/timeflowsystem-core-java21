package com.paradigma0621.core.repository.person;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;

import java.util.*;

public interface PersonRepository {
    Optional<PersonDto> findPersonNameById(QueryParameterDto queryParameterDto);
    Optional<List<PersonDto>> findAll(QueryParameterDto queryParameterDto);
    Optional<Long> findTotalPerson(QueryParameterDto queryParameterDto);
    void saveOne(QueryParameterDto queryParameterDto);
}