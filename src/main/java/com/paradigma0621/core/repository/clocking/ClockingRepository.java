package com.paradigma0621.core.repository.clocking;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.dto.QueryParameterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClockingRepository {
    Page<ClockingDto> findAll(QueryParameterDto queryParameterDto, Pageable pageable);
    void saveOne(QueryParameterDto queryParameterDto);
}