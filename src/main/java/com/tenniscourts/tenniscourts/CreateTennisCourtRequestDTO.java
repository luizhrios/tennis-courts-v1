package com.tenniscourts.tenniscourts;

import com.tenniscourts.schedules.ScheduleDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTennisCourtRequestDTO {

    @NotNull
    private String name;

    private List<ScheduleDTO> tennisCourtSchedules;

}
