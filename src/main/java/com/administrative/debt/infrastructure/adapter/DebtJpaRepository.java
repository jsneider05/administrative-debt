package com.administrative.debt.infrastructure.adapter;

import com.administrative.debt.infrastructure.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtJpaRepository extends JpaRepository<DebtEntity, String> {

  Boolean existsByIdClient(String idClient);

  Boolean existsByEmail(String email);

  Boolean existsByIdDebt(String idDebt);

}
