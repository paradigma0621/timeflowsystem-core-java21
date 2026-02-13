package com.paradigma0621.core.controller;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.service.person.PersonService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/{personId}")
    public PersonDto getPersonDtoById(@PathVariable Long personId) {
        return personService.findById(personId);
    }

    @GetMapping(value = "/{personId}/by-customer")
    public PersonDto getPersonDto(@PathVariable Long personId, @RequestParam Long customerId) {
        return personService.findBy(personId, customerId);
    }

    @GetMapping(value = "/all")
    public Page<PersonDto> getPersons(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return personService.findAll(pageable);
    }

    @PostMapping(value = "/saveOne")
    public void saveOne(@RequestBody PersonDto personDto) {
        personService.saveOne(personDto);
    }

}
