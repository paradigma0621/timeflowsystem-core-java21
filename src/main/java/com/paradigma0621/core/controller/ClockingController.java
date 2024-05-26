package com.paradigma0621.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clockings")
public class ClockingController {

    private static final Logger logger = LoggerFactory.getLogger(ClockingController.class);

    @GetMapping(value = "/teste")
    public String creating() {
        logger.info("PROJECT!!!");
        return "PROJECT!!!";
    }

    @PostMapping(value = "/greeting")
    public String saudation(@RequestBody String personName) {
        return "hello, " + personName + "!!";
    }

}
