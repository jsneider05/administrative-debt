package com.administrative.debt.infrastructure.controller;

import com.administrative.debt.application.ConsultDebtHandler;
import com.administrative.debt.application.CreateDebtHandler;
import com.administrative.debt.application.DeleteDebtHandler;
import com.administrative.debt.application.UpdateDebtHandler;
import com.administrative.debt.domain.model.Debt;
import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  private final CreateDebtHandler createDebtHandler;
  private final UpdateDebtHandler updateDebtHandler;
  private final DeleteDebtHandler deleteDebtHandler;

  @GetMapping(path = "/{id-client}")
  @PreAuthorize("hasAuthority('debt:read')")
  public Debt getDebt(@PathVariable(value = "id-client") @Size(max = 15) String idClient) {
    log.info("[Start][idClient:{}]", idClient);
    Debt debt = this.consultDebtHandler.execute(idClient);
    log.info("[End][idClient:{}]", idClient);
    return debt;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('debt:create')")
  public void createDebt(@Valid @RequestBody Debt debt) {
    log.info("[Start][idClient:{}]", debt.getIdClient());
    this.createDebtHandler.execute(debt);
    log.info("[End][idClient:{}]", debt.getIdClient());
  }

  @PutMapping(path = "/{id-client}")
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('debt:update')")
  public void updateDebt(
      @PathVariable(value = "id-client") @Size(max = 15) String idClient,
      @RequestParam(value = "due-debt") @Future @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dueDate,
      @RequestParam(value = "amount") @Positive Long amount
  ) {
    log.info("[Start][idClient:{}]", idClient);
    this.updateDebtHandler.execute(idClient, dueDate, amount);
    log.info("[End][idClient:{}]", idClient);
  }

  @DeleteMapping(path = "/{id-client}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @PreAuthorize("hasAuthority('debt:delete')")
  public void deleteDebt(@PathVariable(value = "id-client") @Size(max = 15) String idClient) {
    log.info("[Start][idClient:{}]", idClient);
    this.deleteDebtHandler.execute(idClient);
    log.info("[End][idClient:{}]", idClient);
  }

}
