package com.administrative.debt.infrastructure.adapter.mapper;

import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.infrastructure.entity.DebtEntity;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class DebtMapper {

  public final Function<DebtEntity, Debt> toDebt = entity ->
      new Debt(
          entity.getIdClient(),
          entity.getClientName(),
          entity.getEmail(),
          entity.getAmount(),
          entity.getIdDebt(),
          entity.getDueDate());

}
