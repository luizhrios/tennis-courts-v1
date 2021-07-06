package com.tenniscourts.schedules;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScheduleMapper {

    Schedule map(ScheduleDTO source);

    @Mapping(target = "tennisCourtId", source = "tennisCourt.id")
    ScheduleDTO map(Schedule source);

    List<ScheduleDTO> map(List<Schedule> source);
}
