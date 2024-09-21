package com.paradigma0621.core.service.person;

import com.paradigma0621.core.repository.person.PersonRepository;
import com.paradigma0621.core.service.commons.parameters.QueryParameterMountPersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonTotalService {

    private final PersonRepository personRepository;
    private final QueryParameterMountPersonService queryParameterMountPersonService;

    public PersonTotalService(PersonRepository personRepository, QueryParameterMountPersonService queryParameterMountPersonService) {
        this.personRepository = personRepository;
        this.queryParameterMountPersonService = queryParameterMountPersonService;
    }

    public Long findTotalPersons() {
        var queryParameter = queryParameterMountPersonService.mountFindTotalPersonDtos();
        return personRepository.findTotalPerson(queryParameter).orElse(0L);
    }
/*
    public void saveOne(PersonDto personDto) {
        var queryParameter = queryParameterMountPersonService.saveOne(personDto);
        personRepository.saveOne(queryParameter);

    }

 */
}