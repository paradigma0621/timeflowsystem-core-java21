package com.paradigma0621.core.controller;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.service.clocking.ClockingService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clockings")
public class ClockingController {

    private final ClockingService clockingService;

    private static final Logger logger = LoggerFactory.getLogger(ClockingController.class);

    @GetMapping(value = "/all")
    public Page<ClockingDto> findAll(
            @RequestParam(required = false) Long personId,
            @RequestParam(required = false) Boolean removed,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTo,
            @RequestParam(required = false) String subjectLike,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return clockingService.findAll(personId, removed, startFrom, startTo, subjectLike, pageable);
    }

    @PostMapping(value = "/saveOne")
    public void saveOne(@RequestBody ClockingDto clockingDto) {
        clockingService.saveOne(clockingDto);
    }

}
