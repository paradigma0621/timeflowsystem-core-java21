package com.paradigma0621.core.repository.clocking.impl;


import com.paradigma0621.core.dto.QueryParameterDto;
import com.paradigma0621.core.repository.clocking.ClockingRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClockingRepositoryImpl implements ClockingRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ClockingRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
/*
    @Override
    public Optional<PersonDto> findPersonNameById(QueryParameterDto queryParameterDto) {
        return namedParameterJdbcTemplate.query(queryParameterDto.sql(), queryParameterDto.parameter(), result -> {
            if (result.next()) {
                var personDto = new PersonDto(
                        result.getLong(ID),
                        result.getString(NAME),
                        result.getTimestamp(REGISTER_DATE).toLocalDateTime(),
                        result.getString(ENROLLMENT),
                        result.getLong(PROFILE_ID),
                        result.getLong(CUSTOMER_ID),
                        result.getBoolean(REMOVED)
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
                        result.getBoolean(REMOVED)
                   )
            )
        );
    }

    @Override
    public Optional<Long> findTotalPerson(QueryParameterDto queryParameterDto) {
        return Optional.of(namedParameterJdbcTemplate.queryForObject(queryParameterDto.sql(), queryParameterDto.parameter(), Long.class));
    }
*/
    @Override
    public void saveOne(QueryParameterDto queryParameterDto) {
        namedParameterJdbcTemplate.update(queryParameterDto.sql(), queryParameterDto.parameter());
    }
}