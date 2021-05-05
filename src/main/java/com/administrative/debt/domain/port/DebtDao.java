package com.administrative.debt.domain.port;

import com.administrative.debt.domain.model.Debt;

public interface DebtDao {

  Debt getByIdClient(String idClient);

}
