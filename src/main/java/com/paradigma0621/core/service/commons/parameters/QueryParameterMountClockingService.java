package com.paradigma0621.core.service.commons.parameters;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import org.springframework.stereotype.Service;

import static com.paradigma0621.core.repository.clocking.sql.ClockingSQLParts.*;

@Service
public class QueryParameterMountClockingService extends QueryParameterMountAbstract {
/*
    public QueryParameterDto mountFindPersonDto(Long personId) {
        return applyFilterPersonId(personId, QUERY_ONE_PERSON);
    }

    public QueryParameterDto mountFindPersonDtos(PageRequest pageRequest) {
        return applyQuery(QUERY_ALL_PERSONS, pageRequest);
    }

    public QueryParameterDto mountFindTotalPersonDtos() {
        return applyQuery(QUERY_COUNT_ALL_PERSONS);
    }
*/


    public QueryParameterDto saveOne(ClockingDto clockingDto) {
        return applyFilterClockingDto(clockingDto, QUERY_SAVE_ONE_CLOCKING);
    }
}