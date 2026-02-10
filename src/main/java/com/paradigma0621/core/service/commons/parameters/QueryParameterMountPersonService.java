package com.paradigma0621.core.service.commons.parameters;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.QueryParameterDto;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.paradigma0621.core.repository.person.sql.PersonSQLParts.*;

@Service
public class QueryParameterMountPersonService extends QueryParameterMountAbstract {

    public QueryParameterDto mountFindPersonDtoById(Long personId) {
        return applyFilterPersonId(personId, QUERY_ONE_PERSON_BY_ID);
    }

    public QueryParameterDto mountFindPersonDto(Long personId, Long customerId) {
        return applyFiltersPerson(personId, customerId, QUERY_ONE_PERSON_BY_ID_AND_CUSTOMER_ID);
    }

    public QueryParameterDto mountFindPersonDtos(PageRequest pageRequest) {
        return applyQuery(QUERY_ALL_PERSONS, pageRequest);
    }

    public QueryParameterDto mountFindTotalPersonDtos() {
        return applyQuery(QUERY_COUNT_ALL_PERSONS);
    }

    public QueryParameterDto saveOne(PersonDto personDto) {
        return applyFilterPersoDto(personDto, QUERY_SAVE_ONE_PERSON);
    }
}