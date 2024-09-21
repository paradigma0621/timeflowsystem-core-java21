package com.paradigma0621.core.controller;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.service.person.PersonService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/test")
    public String creating() {

        System.out.println("logggg");
        return "For frontend REACT PROJECT!!!";

    }

    @PostMapping(value = "/greeting")
    public String saudation(@RequestBody String personName) {
        return "hello, " + personName + "!!";
    }

    @GetMapping(value = "/jdbc/{personId}")
    public PersonDto getJdbcPersonName(@PathVariable(name="personId") Long personId) {
        return personService.findById(personId);
    }

    @GetMapping(value = "/all")
    public Page<PersonDto> getPersons(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return personService.findAll(pageable);
    }

    @PostMapping(value = "/saveOne")
    public void saveOne(@RequestBody PersonDto personDto) {
        personService.saveOne(personDto);
    }

    @GetMapping(value = "/count/{countMax}")
    public String count(@PathVariable(name="countMax") Long countMax) {
        for (var count=0; count <= countMax; count++) {
            for (var count2=0; count2 <= countMax; count2++) {

            }
        }
        return "Counted unitl: "+ countMax*countMax;
    }

}
