package com.paradigma0621.core.service.person;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.repository.person.PersonRepository;
import com.paradigma0621.core.service.commons.parameters.QueryParameterMountPersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static com.paradigma0621.core.util.Utils.returnPageable;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final QueryParameterMountPersonService queryParameterMountPersonService;
    private final PersonTotalService personTotalService;

    public PersonService(PersonRepository personRepository, QueryParameterMountPersonService queryParameterMountPersonService) {
        this.personRepository = personRepository;
        this.queryParameterMountPersonService = queryParameterMountPersonService;
        this.personTotalService = new PersonTotalService(personRepository, queryParameterMountPersonService);
    }

    public PersonDto findById(Long personId) {
        var queryParameter = queryParameterMountPersonService.mountFindPersonDtoById(personId);
        return personRepository.findById(queryParameter)
                .orElse(new PersonDto(0L, "No person found for the given personId", null, "0", 0L, 0L, false, null, null));
    }

    public PersonDto findBy(Long personId, Long customerId) {
        var queryParameter = queryParameterMountPersonService.mountFindPersonDto(personId, customerId);
        return personRepository.findById(queryParameter)
                .orElse(new PersonDto(0L, "No person found for the given personId and customerId", null, "0", 0L, 0L, false, null, null));
    }

    public Page<PersonDto> findAll(Pageable pageable) {
        PageRequest pageRequest = returnPageable(pageable);
        var queryParameter = queryParameterMountPersonService.mountFindPersonDtos(pageRequest);
        var personDtos = personRepository.findAll(queryParameter).orElse(Collections.emptyList());
        var count = personTotalService.findTotalPersons();
        return new PageImpl<>(personDtos, pageRequest, count);
    }

    public void saveOne(PersonDto personDto) {
        var queryParameter = queryParameterMountPersonService.saveOne(personDto);
        personRepository.saveOne(queryParameter);

    }
}