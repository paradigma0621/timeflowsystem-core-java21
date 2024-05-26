package com.paradigma0621.core.dto;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public record QueryParameterDto(
        String sql,
        MapSqlParameterSource parameter) {
}