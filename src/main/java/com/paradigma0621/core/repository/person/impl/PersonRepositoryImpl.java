package com.paradigma0621.core.repository.person.impl;


import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import com.paradigma0621.core.repository.person.PersonRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.paradigma0621.core.repository.commons.SQLFields.*;
import static java.util.Objects.nonNull;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PersonRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<PersonDto> findById(QueryParameterDto queryParameterDto) {
        return namedParameterJdbcTemplate.query(queryParameterDto.sql(), queryParameterDto.parameter(), result -> {
            if (result.next()) {
                var personDto = new PersonDto(
                        result.getLong(ID),
                        result.getString(NAME),
                        result.getTimestamp(REGISTER_DATE).toLocalDateTime(),
                        result.getString(ENROLLMENT),
                        result.getLong(CUSTOMER_ID),
                        result.getLong(PROFILE_ID),
                        result.getBoolean(REMOVED),
                        nonNull(result.getDate(BIRTH_DATE)) ? result.getDate(BIRTH_DATE).toLocalDate() : null,
                        nonNull(result.getTimestamp(DELETION_DATE)) ?
                                    result.getTimestamp(DELETION_DATE).toLocalDateTime() : null
                );

                return Optional.of(personDto);
            }
            return Optional.empty();
        });
    }

    @Override
    public Optional<List<PersonDto>> findAll(QueryParameterDto queryParameterDto) {
        return Optional.of(namedParameterJdbcTemplate.query(queryParameterDto.sql(), queryParameterDto.parameter(), (result, rowNumber) ->
            new PersonDto(
                        result.getLong(ID),
                        result.getString(NAME),
                        result.getTimestamp(REGISTER_DATE).toLocalDateTime(),
                        result.getString(ENROLLMENT),
                        result.getLong(PROFILE_ID),
                        result.getLong(CUSTOMER_ID),
                        result.getBoolean(REMOVED),
                        nonNull(result.getDate(BIRTH_DATE)) ? result.getDate(BIRTH_DATE).toLocalDate() : null,
                        nonNull(result.getTimestamp(DELETION_DATE)) ?
                                result.getTimestamp(DELETION_DATE).toLocalDateTime() : null
                   )
            )
        );
    }

    @Override
    public Optional<Long> findTotalPerson(QueryParameterDto queryParameterDto) {
        return Optional.of(namedParameterJdbcTemplate.queryForObject(queryParameterDto.sql(), queryParameterDto.parameter(), Long.class));
    }

    @Override
    public void saveOne(QueryParameterDto queryParameterDto) {
        namedParameterJdbcTemplate.update(queryParameterDto.sql(), queryParameterDto.parameter());
    }
}