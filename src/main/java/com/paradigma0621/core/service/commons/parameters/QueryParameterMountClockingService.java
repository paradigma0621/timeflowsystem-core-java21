package com.paradigma0621.core.service.commons.parameters;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;

import static com.paradigma0621.core.repository.clocking.sql.ClockingSQLParts.*;

@Service
public class QueryParameterMountClockingService extends QueryParameterMountAbstract {

    public QueryParameterDto findAll(
            Long personId,
            Boolean removed,
            LocalDateTime startFrom,
            LocalDateTime startTo,
            String subjectLike
    ) {

        StringBuilder sql = new StringBuilder()
                                    .append(QUERY_MAIN_FIND_ALL_CLOCKING);

        MapSqlParameterSource params = new MapSqlParameterSource();

        if (personId != null) {
            sql.append(" AND person_id = :personId");
            params.addValue("personId", personId, Types.INTEGER);
        }

        if (removed != null) {
            sql.append(" AND removed = :removed");
            params.addValue("removed", removed, Types.BOOLEAN);
        }

        if (startFrom != null) {
            sql.append(" AND start_date >= :startFrom");
            params.addValue("startFrom", toTimestamp(startFrom), Types.TIMESTAMP);
        }

        if (startTo != null) {
            sql.append(" AND start_date <= :startTo");
            params.addValue("startTo", toTimestamp(startTo));
        }

        if (subjectLike != null && !subjectLike.trim().isEmpty()) {
            sql.append(" AND subject ILIKE :subjectLike"); // Postgres
            params.addValue("subjectLike", "%" + subjectLike.trim() + "%");
        }

        return new QueryParameterDto(sql.toString(), params);
    }

    private static Timestamp toTimestamp(LocalDateTime dt) {
        return dt == null ? null : Timestamp.valueOf(dt);
    }

    public QueryParameterDto saveOne(ClockingDto clockingDto) {
        return applyFilterClockingDto(clockingDto, QUERY_SAVE_ONE_CLOCKING);
    }
}