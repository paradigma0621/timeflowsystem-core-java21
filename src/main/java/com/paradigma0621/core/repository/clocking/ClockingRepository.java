package com.paradigma0621.core.repository.clocking;

import com.paradigma0621.core.dto.QueryParameterDto;

public interface ClockingRepository {
    /*Optional<PersonDto> findPersonNameById(QueryParameterDto queryParameterDto);
    Optional<List<PersonDto>> findAll(QueryParameterDto queryParameterDto);
    Optional<Long> findTotalPerson(QueryParameterDto queryParameterDto);*/
    void saveOne(QueryParameterDto queryParameterDto);
}