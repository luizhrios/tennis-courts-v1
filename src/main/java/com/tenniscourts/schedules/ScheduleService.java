package com.tenniscourts.schedules;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.tenniscourts.TennisCourtRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper;

    private final TennisCourtRepository tennisCourtRepository;

    public ScheduleDTO addSchedule(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) throws Throwable {
        Schedule schedule = Schedule.builder()
                .tennisCourt(tennisCourtRepository.findById(tennisCourtId).orElseThrow(() -> {
                    throw new EntityNotFoundException("Tennis Court not found.");
                }))
                .startDateTime(createScheduleRequestDTO.getStartDateTime())
                .endDateTime(createScheduleRequestDTO.getStartDateTime().plusHours(1))
                .build();

        scheduleRepository.save(schedule);
        return scheduleMapper.map(schedule);
    }

    public List<ScheduleDTO> findSchedulesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        List<Schedule> scheduleList = scheduleRepository.findByStartDateTimeAfterAndEndDateTimeBefore(startDate, endDate);
        return scheduleMapper.map(scheduleList);
    }

    public ScheduleDTO findSchedule(Long scheduleId) throws Throwable {
        return scheduleMapper.map(scheduleRepository.findById(scheduleId).orElseThrow(() -> {
            throw new EntityNotFoundException("Schedule not found.");
        }));
    }

    public List<ScheduleDTO> findSchedulesByTennisCourtId(Long tennisCourtId) {
        return scheduleMapper.map(scheduleRepository.findByTennisCourt_IdOrderByStartDateTime(tennisCourtId));
    }
}
