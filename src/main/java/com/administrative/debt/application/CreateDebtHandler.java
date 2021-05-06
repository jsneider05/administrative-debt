package com.administrative.debt.application;

import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.service.CreateDebtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class CreateDebtHandler {

  private final CreateDebtService service;

  @Transactional
  public void execute(Debt debt) {
    log.info("[Start][idClient:{}]", debt.getIdClient());
    this.service.execute(debt);
    log.info("[End][idClient:{}]", debt.getIdClient());
  }

}
