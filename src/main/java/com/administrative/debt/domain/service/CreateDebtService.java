package com.administrative.debt.domain.service;

import com.administrative.debt.domain.exception.InvalidValueException;
import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.port.dao.DebtDao;
import com.administrative.debt.domain.port.repository.DebtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateDebtService {

  public static final String EXISTS_A_DEBT_BY_ID_CLIENT = "Exists a debt by idClient %s";
  public static final String EXISTS_A_CLIENT_BY_EMAIL = "Exists a client by email %s";
  public static final String EXISTS_A_DEBT_BY_ID_DEBT = "Exists a debt by idDebt %s";

  private final DebtDao dao;
  private final DebtRepository repository;

  public void execute(Debt debt) {
    log.info("[Start][idClient:{}]", debt.getIdClient());

    validateDebtByIdClient(debt.getIdClient());
    validateDebtByEmail(debt.getEmail());
    validateDebtByIdDebt(debt.getIdDebt());

    this.repository.create(debt);

    log.info("[End][idClient:{}]", debt.getIdClient());
  }

  private void validateDebtByIdClient(String idClient) {
    if (Boolean.TRUE.equals(this.dao.existsByIdClient(idClient))) {
      throw new InvalidValueException(String.format(EXISTS_A_DEBT_BY_ID_CLIENT, idClient));
    }
  }

  private void validateDebtByEmail(String email) {
    if (Boolean.TRUE.equals(this.dao.existsByEmail(email))) {
      throw new InvalidValueException(String.format(EXISTS_A_CLIENT_BY_EMAIL, email));
    }
  }

  private void validateDebtByIdDebt(String idDebt) {
    if (Boolean.TRUE.equals(this.dao.existsByIdDebt(idDebt))) {
      throw new InvalidValueException(String.format(EXISTS_A_DEBT_BY_ID_DEBT, idDebt));
    }
  }

}
