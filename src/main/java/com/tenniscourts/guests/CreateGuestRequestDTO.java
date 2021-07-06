package com.tenniscourts.guests;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateGuestRequestDTO {

  @NotNull
  private String name;

}
