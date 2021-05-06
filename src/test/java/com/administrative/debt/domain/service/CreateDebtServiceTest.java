package com.administrative.debt.domain.service;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.administrative.debt.domain.exception.InvalidValueException;
import com.administrative.debt.domain.model.Debt;
import com.administrative.debt.domain.port.dao.DebtDao;
import com.administrative.debt.domain.port.repository.DebtRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class CreateDebtServiceTest {

  private static final String EXISTS_A_DEBT_BY_ID_CLIENT = "Exists a debt by idClient %s";
  private static final String EXISTS_A_CLIENT_BY_EMAIL = "Exists a client by email %s";
  private static final String EXISTS_A_DEBT_BY_ID_DEBT = "Exists a debt by idDebt %s";
  private static final int ONCE = 1;

  private DebtDao daoUnderTest;
  private DebtRepository repositoryUnderTest;
  private CreateDebtService serviceUnderTest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    this.daoUnderTest = spy(DebtDao.class);
    this.repositoryUnderTest = spy(DebtRepository.class);
    this.serviceUnderTest = new CreateDebtService(this.daoUnderTest, this.repositoryUnderTest);
  }

  @Test
  void createDebtSuccess() {
    // Arrage
    Debt debtRequest = new Debt("123456", "test", "test@gmail.com", 10000L, "acb123",
        LocalDate.now());

    doReturn(FALSE).when(this.daoUnderTest).existsByIdClient(anyString());
    doReturn(FALSE).when(this.daoUnderTest).existsByEmail(anyString());
    doReturn(FALSE).when(this.daoUnderTest).existsByIdDebt(anyString());

    // Act
    this.serviceUnderTest.execute(debtRequest);

    // Assert
    verify(this.daoUnderTest, times(ONCE)).existsByIdClient(debtRequest.getIdClient());
    verify(this.daoUnderTest, times(ONCE)).existsByEmail(debtRequest.getEmail());
    verify(this.daoUnderTest, times(ONCE)).existsByIdDebt(debtRequest.getIdDebt());
    verify(this.repositoryUnderTest, times(ONCE)).create(debtRequest);
  }

  @Test
  void createDebtExistByIdClientFail() {
    // Arrage
    Debt debtRequest = new Debt("123456", "test", "test@gmail.com", 10000L, "acb123",
        LocalDate.now());

    doReturn(TRUE).when(this.daoUnderTest).existsByIdClient(anyString());
    doReturn(FALSE).when(this.daoUnderTest).existsByEmail(anyString());
    doReturn(FALSE).when(this.daoUnderTest).existsByIdDebt(anyString());

    // Act - Assert
    assertThatThrownBy(() -> this.serviceUnderTest.execute(debtRequest))
        .isInstanceOf(InvalidValueException.class)
        .hasMessage(String.format(EXISTS_A_DEBT_BY_ID_CLIENT, debtRequest.getIdClient()));
  }

  @Test
  void createDebtExistByEmailFail() {
    // Arrage
    Debt debtRequest = new Debt("123456", "test", "test@gmail.com", 10000L, "acb123",
        LocalDate.now());

    doReturn(FALSE).when(this.daoUnderTest).existsByIdClient(anyString());
    doReturn(TRUE).when(this.daoUnderTest).existsByEmail(anyString());
    doReturn(FALSE).when(this.daoUnderTest).existsByIdDebt(anyString());

    // Act - Assert
    assertThatThrownBy(() -> this.serviceUnderTest.execute(debtRequest))
        .isInstanceOf(InvalidValueException.class)
        .hasMessage(String.format(EXISTS_A_CLIENT_BY_EMAIL, debtRequest.getEmail()));
  }

  @Test
  void createDebtExistByIdDebtFail() {
    // Arrage
    Debt debtRequest = new Debt("123456", "test", "test@gmail.com", 10000L, "acb123",
        LocalDate.now());

    doReturn(FALSE).when(this.daoUnderTest).existsByIdClient(anyString());
    doReturn(FALSE).when(this.daoUnderTest).existsByEmail(anyString());
    doReturn(TRUE).when(this.daoUnderTest).existsByIdDebt(anyString());

    // Act - Assert
    assertThatThrownBy(() -> this.serviceUnderTest.execute(debtRequest))
        .isInstanceOf(InvalidValueException.class)
        .hasMessage(String.format(EXISTS_A_DEBT_BY_ID_DEBT, debtRequest.getIdDebt()));
  }

}