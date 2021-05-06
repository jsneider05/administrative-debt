package com.administrative.debt.domain.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.port.dao.DebtDao;
import com.administrative.debt.domain.port.repository.DebtRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class UpdateDebtServiceTest {

  private static final int ONCE = 1;

  private DebtDao daoUnderTest;
  private DebtRepository repositoryUnderTest;
  private UpdateDebtService serviceUnderTest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    this.daoUnderTest = spy(DebtDao.class);
    this.repositoryUnderTest = spy(DebtRepository.class);
    this.serviceUnderTest = new UpdateDebtService(this.daoUnderTest, this.repositoryUnderTest);
  }

  @Test
  void updateDebtSuccess() {
    // Arrage
    String idClient =  "123456";
    LocalDate dueDate = LocalDate.now();
    Long amount = 15000L;

    Debt debt = new Debt("123456", "test", "test@gmail.com", 10000L, "acb123",
        LocalDate.now());

    doReturn(debt).when(this.daoUnderTest).getByIdClient(anyString());

    // Act
    this.serviceUnderTest.execute(idClient, dueDate, amount);

    // Assert
    verify(this.daoUnderTest, times(ONCE)).getByIdClient(idClient);
    verify(this.repositoryUnderTest, times(ONCE)).update(debt);
  }
}