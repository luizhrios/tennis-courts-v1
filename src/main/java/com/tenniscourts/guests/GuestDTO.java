package com.tenniscourts.guests;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GuestDTO {

  @NotNull
  private Long Id;

  @NotNull
  private String name;

}
