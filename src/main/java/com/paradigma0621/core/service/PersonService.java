package com.paradigma0621.core.service;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.repository.person.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final QueryParameterMountPersonService queryParameterMountPersonService;

    public PersonService(PersonRepository personRepository, QueryParameterMountPersonService queryParameterMountPersonService) {
        this.personRepository = personRepository;
        this.queryParameterMountPersonService = queryParameterMountPersonService;
    }

    public PersonDto findById(Long personId) {
        var queryParameter = queryParameterMountPersonService.mountFindPersonDto(personId);
        return personRepository.findPersonNameById(queryParameter).orElse(new PersonDto(0L, "No one with this id"));

    }

}