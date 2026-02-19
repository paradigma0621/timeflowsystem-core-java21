package com.paradigma0621.core.service.clocking;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.repository.clocking.ClockingRepository;
import com.paradigma0621.core.service.commons.parameters.QueryParameterMountClockingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClockingService {

    private final ClockingRepository clockingRepository;
    private final QueryParameterMountClockingService queryParameterMountClockingService;

    public Page<ClockingDto> findAll(
            Long personId,
            Boolean removed,
            LocalDateTime startFrom,
            LocalDateTime startTo,
            String subjectLike,
            Pageable pageable
    ) {
        log.info("Executing the request from this console.");
        var queryParameter = queryParameterMountClockingService.findAll(
                personId, removed, startFrom, startTo, subjectLike
        );

        return clockingRepository.findAll(queryParameter, pageable);
    }

    public void saveOne(ClockingDto clockingDto) {
        var queryParameter = queryParameterMountClockingService.saveOne(clockingDto);
        clockingRepository.saveOne(queryParameter);
    }
}