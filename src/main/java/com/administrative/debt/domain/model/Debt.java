package com.administrative.debt.domain.model;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Debt {

  @NotBlank
  @Size(max = 15)
  private String idClient;

  @NotBlank
  @Size(max = 60)
  private String clientName;

  @Email
  @Size(max = 60)
  private String email;

  private Long amount;

  @NotBlank
  @Size(max = 15)
  private String idDebt;

  @PastOrPresent
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  private LocalDate dueDate;

}
