package com.administrative.debt.infrastructure.adapter.repository;

import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.port.repository.DebtRepository;
import com.administrative.debt.infrastructure.adapter.DebtJpaRepository;
import com.administrative.debt.infrastructure.adapter.mapper.DebtMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class DebtRepositoryH2 implements DebtRepository {

  private final DebtJpaRepository jpaRepository;
  private final DebtMapper mapper;

  @Override
  public void create(Debt debt) {
    log.info("[Start][idClient:{}]", debt.getIdClient());
    this.jpaRepository.save(this.mapper.toEntity.apply(debt));
    log.info("[End][idClient:{}]", debt.getIdClient());
  }

  @Override
  public void update(Debt debt) {
    log.info("[Start][idClient:{}]", debt.getIdClient());
    this.jpaRepository.save(this.mapper.toEntity.apply(debt));
    log.info("[End][idClient:{}]", debt.getIdClient());
  }

  @Override
  public void delete(String idClient) {
    log.info("[Start][idClient:{}]", idClient);
    this.jpaRepository.deleteById(idClient);
    log.info("[End][idClient:{}]", idClient);
  }
}
