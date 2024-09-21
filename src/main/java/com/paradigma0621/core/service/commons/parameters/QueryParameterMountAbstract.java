package com.paradigma0621.core.service.commons.parameters;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;

import static com.paradigma0621.core.repository.commons.SQLFields.*;
import static com.paradigma0621.core.util.Utils.returnOrderAndLimit;

public abstract class QueryParameterMountAbstract {

    protected QueryParameterDto applyFilterPersonId(Long personId, String sql) {
        var parameter = new MapSqlParameterSource()
                .addValue(ID, personId, Types.INTEGER);
        return new QueryParameterDto(sql, parameter);
    }

    protected QueryParameterDto applyQuery(String sql, PageRequest pageRequest) {
        sql += returnOrderAndLimit(pageRequest);
        return new QueryParameterDto(sql, null);
    }

    protected QueryParameterDto applyQuery(String sql) {
        return new QueryParameterDto(sql, null);
    }

    protected QueryParameterDto applyFilterPersoDto(PersonDto personDto, String sql) {
        var parameter = new MapSqlParameterSource()
                .addValue(ID, personDto.id(), Types.INTEGER)
                .addValue(NAME, personDto.name(), Types.VARCHAR)
                .addValue(REGISTER_DATE, personDto.registerDate(), Types.TIMESTAMP)
                .addValue(ENROLLMENT, personDto.enrollment(), Types.VARCHAR)
                .addValue(PROFILE_ID, personDto.profileId(), Types.INTEGER)
                .addValue(CUSTOMER_ID, personDto.customerId(), Types.INTEGER)
                .addValue(REMOVED, personDto.removed(), Types.BOOLEAN);

        return new QueryParameterDto(sql, parameter);
    }

    protected QueryParameterDto applyFilterClockingDto(ClockingDto clockingDto, String sql) {
        var parameter = new MapSqlParameterSource()
                .addValue(ID, clockingDto.id(), Types.INTEGER)
                .addValue(SECONDS_DURATION, clockingDto.secondsDuration(), Types.INTEGER)
                .addValue(GRADE, clockingDto.grade(), Types.DOUBLE)
                .addValue(DESCRIPTION, clockingDto.description(), Types.VARCHAR)
                .addValue(SUBJECT, clockingDto.subject(), Types.VARCHAR)
                .addValue(START_DATE, clockingDto.startDate(), Types.TIMESTAMP)
                .addValue(FINISH_DATE, clockingDto.finishDate(), Types.TIMESTAMP)
                .addValue(LOCALIZATION, clockingDto.localization(), Types.VARCHAR)
                .addValue(PERSON_ID, clockingDto.personId(), Types.INTEGER)
                .addValue(REMOVED, clockingDto.removed(), Types.BOOLEAN);

        return new QueryParameterDto(sql, parameter);
    }
}