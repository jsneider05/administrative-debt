package com.administrative.debt.domain.service;

import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.port.dao.DebtDao;
import com.administrative.debt.domain.port.repository.DebtRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UpdateDebtService {

  private final DebtDao dao;
  private final DebtRepository repository;

  public void execute(String idClient, LocalDate dueDate, Long amount) {
    log.info("[Start][idClient:{}]", idClient);

    Debt debt = this.dao.getByIdClient(idClient);
    debt.setDueDate(dueDate);
    debt.setAmount(amount);

    this.repository.update(debt);

    log.info("[End][idClient:{}]", idClient);
  }

}
