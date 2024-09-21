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
        var queryParameter = queryParameterMountPersonService.mountFindPersonDto(personId);
        return personRepository.findPersonNameById(queryParameter)
                .orElse(new PersonDto(0L, "No one with this id", null, "0",0L,0L,false));
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