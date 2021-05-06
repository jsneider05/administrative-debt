package com.administrative.debt.domain.port.dao;

import com.administrative.debt.domain.model.Debt;

public interface DebtDao {

  Debt getByIdClient(String idClient);

  Boolean existsByIdClient(String idClient);

  Boolean existsByEmail(String email);

  Boolean existsByIdDebt(String idDebt);

}
