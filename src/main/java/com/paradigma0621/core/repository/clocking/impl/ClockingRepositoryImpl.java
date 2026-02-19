package com.paradigma0621.core.repository.clocking.impl;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import com.paradigma0621.core.repository.clocking.ClockingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.paradigma0621.core.repository.commons.SQLFields.*;
import static com.paradigma0621.core.util.Utils.returnOrderAndLimit;

@RequiredArgsConstructor
@Repository
public class ClockingRepositoryImpl implements ClockingRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Page<ClockingDto> findAll(QueryParameterDto queryParameterDto, Pageable pageable) {

        String countSql = "SELECT COUNT(*) FROM (" + queryParameterDto.sql() + ") q";
        String sql = queryParameterDto.sql() + returnOrderAndLimit(pageable);

        List<ClockingDto> clockingDtos = namedParameterJdbcTemplate.query(sql, queryParameterDto.parameter(),
                            (result, rowNumber) -> new ClockingDto(
                                    result.getLong(ID),
                                    result.getLong(SECONDS_DURATION),
                                    result.getObject(GRADE, Double.class),
                                    result.getString(DESCRIPTION),
                                    result.getString(SUBJECT),
                                    toLocalDateTime(result.getTimestamp(START_DATE)),
                                    toLocalDateTime(result.getTimestamp(FINISH_DATE)),
                                    result.getString(LOCALIZATION),
                                    result.getLong(PERSON_ID),
                                    result.getBoolean(REMOVED)
                            ));


        var total = namedParameterJdbcTemplate.queryForObject(countSql, queryParameterDto.parameter(), Long.class);
        if (total == null) total = 0L;
        return new PageImpl<>(clockingDtos, pageable, total);
    }

    private static LocalDateTime toLocalDateTime(Timestamp ts) {
        return ts == null ? null : ts.toLocalDateTime();
    }

    @Override
    public void saveOne(QueryParameterDto queryParameterDto) {
        namedParameterJdbcTemplate.update(queryParameterDto.sql(), queryParameterDto.parameter());
    }
}