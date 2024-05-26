package com.paradigma0621.core.controller;

import com.paradigma0621.core.service.PersonService;
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
        return "For frontend REACT PROJECT!!!";
    }

    @PostMapping(value = "/greeting")
    public String saudation(@RequestBody String personName) {

        return "hello, " + personName + "!!";
    }

    @GetMapping(value = "/jdbc/{personId}")
    public String getJdbcPersonName(@PathVariable(name="personId") Long personId) {
        var personDto = personService.findById(personId);
        return personDto.name();
    }

}
