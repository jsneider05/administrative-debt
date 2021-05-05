package com.administrative.debt.infrastructure.controller;

import com.administrative.debt.application.ConsultDebtHandler;
import com.administrative.debt.domain.model.Debt;
import javax.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
@RestController
@RequestMapping(path = "/v1/private/debt")
@Validated
public class DebtController {

  private final ConsultDebtHandler consultDebtHandler;

  @GetMapping(path = "/{id-client}")
  public Debt getDebt(@PathVariable(value = "id-client") @Size(max = 15) String idClient) {
    log.info("[Start][idClient:{}]", idClient);
    Debt debt = this.consultDebtHandler.execute(idClient);
    log.info("[End][idClient:{}]", idClient);
    return debt;
  }

}
