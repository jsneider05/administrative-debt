package com.administrative.debt.infrastructure.adapter.dao;

import com.administrative.debt.domain.exception.NoDataException;
import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.port.DebtDao;
import com.administrative.debt.infrastructure.adapter.DebtJpaRepository;
import com.administrative.debt.infrastructure.adapter.mapper.DebtMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class DebtDaoH2 implements DebtDao {

  private static final String DEBT_NOT_FOUND = "Debt by client id %s not found";

  private final DebtJpaRepository jpaRepository;
  private final DebtMapper mapper;

  @Override
  public Debt getByIdClient(String idClient) {
    log.info("[Start][idClient:{}]", idClient);
    Debt debt = this.mapper.toDebt.apply(
        this.jpaRepository.findById(idClient)
            .orElseThrow(() -> {
              log.error("[Error][idClient:{}]", idClient);
              throw new NoDataException(String.format(DEBT_NOT_FOUND, idClient)
              );
            })
    );
    log.info("[End][idClient:{}]", idClient);
    return debt;
  }
}
