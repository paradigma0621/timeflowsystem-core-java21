package com.paradigma0621.core.repository.person.impl;


import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import com.paradigma0621.core.repository.person.PersonRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PersonRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<PersonDto> findPersonNameById(QueryParameterDto queryParameterDto) {
        return namedParameterJdbcTemplate.query(queryParameterDto.sql(), queryParameterDto.parameter(), result -> {
            if (result.next()) {
                var personDto = new PersonDto(
                        1L,
                        result.getString("name"));

                return Optional.of(personDto);
            }
            return Optional.empty();
        });
    }
}