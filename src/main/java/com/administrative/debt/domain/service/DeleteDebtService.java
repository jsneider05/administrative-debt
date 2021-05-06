package com.administrative.debt.domain.service;

import com.administrative.debt.domain.exception.NoDataException;
import com.administrative.debt.domain.port.dao.DebtDao;
import com.administrative.debt.domain.port.repository.DebtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeleteDebtService {

  private static final String NO_EXISTS_A_DEBT_BY_ID_CLIENT = "Doesn't exists a debt by idClient %s";

  private final DebtDao dao;
  private final DebtRepository repository;

  public void execute(String idClient) {
    log.info("[Start][idClient:{}]", idClient);

    validateExistsDebtByIdClient(idClient);

    this.repository.delete(idClient);

    log.info("[End][idClient:{}]", idClient);
  }

  private void validateExistsDebtByIdClient(String idClient) {
    if (Boolean.FALSE.equals(this.dao.existsByIdClient(idClient))) {
      throw new NoDataException(String.format(NO_EXISTS_A_DEBT_BY_ID_CLIENT, idClient));
    }
  }

}
