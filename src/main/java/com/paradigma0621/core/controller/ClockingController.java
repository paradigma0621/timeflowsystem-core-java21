package com.paradigma0621.core.controller;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.service.clocking.ClockingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clockings")
public class ClockingController {

    private final ClockingService clockingService;

    private static final Logger logger = LoggerFactory.getLogger(ClockingController.class);

    public ClockingController(ClockingService clockingService) {
        this.clockingService = clockingService;
    }

    @GetMapping(value = "/teste")
    public String creating() {
        logger.info("PROJECT!!!");
        return "PROJECT!!!";
    }

    @PostMapping(value = "/greeting")
    public String saudation(@RequestBody String personName) {
        return "hello, " + personName + "!!";
    }

    @PostMapping(value = "/saveOne")
    public void saveOne(@RequestBody ClockingDto clockingDto) {
        clockingService.saveOne(clockingDto);
    }

}
