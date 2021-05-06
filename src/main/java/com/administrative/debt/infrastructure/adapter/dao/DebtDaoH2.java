package com.administrative.debt.infrastructure.adapter.dao;

import com.administrative.debt.domain.exception.NoDataException;
import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.port.dao.DebtDao;
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

  @Override
  public Boolean existsByIdClient(String idClient) {
    log.info("[Start][idClient:{}]", idClient);
    Boolean exist = this.jpaRepository.existsByIdClient(idClient);
    log.info("[End][idClient:{}]", idClient);
    return exist;
  }

  @Override
  public Boolean existsByEmail(String email) {
    log.info("[Start][email:{}]", email);
    Boolean exist = this.jpaRepository.existsByEmail(email);
    log.info("[End][email:{}]", email);
    return exist;
  }

  @Override
  public Boolean existsByIdDebt(String idDebt) {
    log.info("[Start][idDebt:{}]", idDebt);
    Boolean exist = this.jpaRepository.existsByIdDebt(idDebt);
    log.info("[End][idDebt:{}]", idDebt);
    return exist;
  }

}
