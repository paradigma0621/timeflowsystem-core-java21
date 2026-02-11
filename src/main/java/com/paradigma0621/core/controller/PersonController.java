package com.paradigma0621.core.controller;

import com.paradigma0621.core.dto.PersonDto;
import com.paradigma0621.core.dto.ResponseDto;
import com.paradigma0621.core.exception.BusinessException;
import com.paradigma0621.core.service.person.PersonService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/test")
    public String creating() {
        System.out.println("log");
        return "For frontend REACT PROJECT!!!";

    }

    @PostMapping(value = "/greeting")
    public String saudation(@RequestBody String personName) {
        return "hello, " + personName + "!!";
    }

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

    @GetMapping(value = "/count/{countMax}")
    public String count(@PathVariable(name="countMax") Long countMax) {
        for (var count=0; count <= countMax; count++) {
            for (var count2=0; count2 <= countMax; count2++) {

            }
        }
        return "Counted unitl: "+ countMax*countMax;
    }

    @GetMapping(value = "/business")
    public void throwBusinessException() {
        throw new BusinessException("This is a business exception");
    }

    @GetMapping(value = "/allResponseDto")
    public ResponseEntity<ResponseDto<Page<PersonDto>>> getPersonsWithResponseDto(@PageableDefault(page = 0, size = 10)
                                                                                  Pageable pageable) {

        Page<PersonDto> result = personService.findAll(pageable);

        ResponseDto<Page<PersonDto>> response = new ResponseDto<>(
                200L,
                "Request completed successfully.",
                result
        );

        return ResponseEntity.ok(response);
    }
}
