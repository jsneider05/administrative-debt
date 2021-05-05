package com.administrative.debt.infrastructure.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_debt")
public class DebtEntity {

  @Id
  @Column(name = "id_client", unique = true, nullable = false, length = 15)
  private String idClient;

  @Column(name = "client_name", nullable = false, length = 60)
  private String clientName;

  @Column(unique = true, nullable = false, length = 60)
  private String email;

  @Column(nullable = false, length = 20)
  private Long amount;

  @Column(name = "id_debt", unique = true, nullable = false, length = 60)
  private String idDebt;

  @Column(name = "due_date", columnDefinition = "DATE", nullable = false)
  private LocalDate dueDate;

}
