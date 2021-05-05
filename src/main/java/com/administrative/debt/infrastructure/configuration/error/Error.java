package com.administrative.debt.infrastructure.configuration.error;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Error {

  private LocalDateTime dateTime;
  private int statusCode;
  private String statusText;
  private List<String> message;

}
