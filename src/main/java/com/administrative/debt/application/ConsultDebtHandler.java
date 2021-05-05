package com.administrative.debt.application;

import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.port.DebtDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ConsultDebtHandler {

  private final DebtDao dao;

  public Debt execute(String idClient) {
    log.info("[Start][idClient:{}]", idClient);
    Debt debt = this.dao.getByIdClient(idClient);
    log.info("[End][idClient:{}]", idClient);
    return debt;
  }

}
