package com.paradigma0621.core.service.clocking;

import com.paradigma0621.core.dto.ClockingDto;
import com.paradigma0621.core.repository.clocking.ClockingRepository;
import com.paradigma0621.core.service.commons.parameters.QueryParameterMountClockingService;
import org.springframework.stereotype.Service;


@Service
public class ClockingService {

    private final ClockingRepository clockingRepository;
    private final QueryParameterMountClockingService queryParameterMountClockingService;
    ///private final ClockingTotalService personTotalService;

    public ClockingService(ClockingRepository clockingRepository, QueryParameterMountClockingService queryParameterMountClockingService) {
        this.clockingRepository = clockingRepository;
        this.queryParameterMountClockingService = queryParameterMountClockingService;
       // this.personTotalService = new ClockingTotalService(personRepository, queryParameterMountPersonService);
    }
/*
    public PersonDto findById(Long personId) {
        var queryParameter = queryParameterMountPersonService.mountFindPersonDto(personId);
        return personRepository.findPersonNameById(queryParameter)
                .orElse(new PersonDto(0L, "No one with this id", null, "0",0L,0L,false));
    }

    public Page<PersonDto> findAll(Pageable pageable) {
        PageRequest pageRequest = returnPageable(pageable);
        var queryParameter = queryParameterMountPersonService.mountFindPersonDtos(pageRequest);
        var personDtos = personRepository.findAll(queryParameter).orElse(Collections.emptyList());
        var count = personTotalService.findTotalPersons();
        return new PageImpl<>(personDtos, pageRequest, count);
    }
*/
    public void saveOne(ClockingDto clockingDto) {
        var queryParameter = queryParameterMountClockingService.saveOne(clockingDto);
        clockingRepository.saveOne(queryParameter);
    }
}