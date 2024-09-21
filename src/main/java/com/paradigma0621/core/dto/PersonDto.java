package com.paradigma0621.core.dto;

import java.time.LocalDateTime;

public record PersonDto(Long id, String name, LocalDateTime registerDate, String enrollment, Long customerId,
                        Long profileId, boolean removed) {
}
