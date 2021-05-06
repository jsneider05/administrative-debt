package com.administrative.debt.application;

import com.administrative.debt.domain.service.DeleteDebtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class DeleteDebtHandler {

  private final DeleteDebtService service;

  @Transactional
  public void execute(String idClient) {
    log.info("[Start][idClient:{}]", idClient);
    this.service.execute(idClient);
    log.info("[End][idClient:{}]", idClient);
  }

}
