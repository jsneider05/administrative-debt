package com.administrative.debt.domain.port.repository;

import com.administrative.debt.domain.model.Debt;

public interface DebtRepository {

  void create(Debt debt);

  void update(Debt debt);

  void delete(String idClient);

}
