package com.paradigma0621.core.service.commons.parameters;

import com.paradigma0621.core.dto.QueryParameterDto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;

public abstract class QueryParameterMountAbstract {

    static final String PERSON_ID = "id";

    protected QueryParameterDto applyFilterPersonId(Long personId, String sql) {
        var parameter = new MapSqlParameterSource()
                .addValue(PERSON_ID, personId, Types.INTEGER);
        return new QueryParameterDto(sql, parameter);
    }
}