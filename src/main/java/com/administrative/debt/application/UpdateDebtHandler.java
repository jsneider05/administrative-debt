package com.administrative.debt.application;

import com.administrative.debt.domain.service.UpdateDebtService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class UpdateDebtHandler {

  private final UpdateDebtService service;

  @Transactional
  public void execute(String idClient, LocalDate dueDate, Long amount) {
    log.info("[Start][idClient:{}]", idClient);
    this.service.execute(idClient, dueDate, amount);
    log.info("[End][idClient:{}]", idClient);
  }

}
