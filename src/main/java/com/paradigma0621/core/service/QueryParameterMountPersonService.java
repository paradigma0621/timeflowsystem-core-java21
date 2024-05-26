package com.paradigma0621.core.service;

import com.paradigma0621.core.dto.QueryParameterDto;
import com.paradigma0621.core.service.commons.parameters.QueryParameterMountAbstract;

import org.springframework.stereotype.Service;

import static com.paradigma0621.core.repository.person.sql.PersonSQLParts.QUERY_ONE_PERSON;

@Service
public class QueryParameterMountPersonService extends QueryParameterMountAbstract {

    public QueryParameterDto mountFindPersonDto(Long personId) {
        return applyFilterPersonId(personId, QUERY_ONE_PERSON);
    }

}