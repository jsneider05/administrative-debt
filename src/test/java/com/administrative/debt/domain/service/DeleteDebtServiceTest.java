package com.administrative.debt.domain.service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.administrative.debt.domain.exception.NoDataException;
import com.administrative.debt.domain.port.dao.DebtDao;
import com.administrative.debt.domain.port.repository.DebtRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class DeleteDebtServiceTest {

  private static final String NO_EXISTS_A_DEBT_BY_ID_CLIENT = "Doesn't exists a debt by idClient %s";
  private static final int ONCE = 1;

  private DebtDao daoUnderTest;
  private DebtRepository repositoryUnderTest;
  private DeleteDebtService serviceUnderTest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    this.daoUnderTest = spy(DebtDao.class);
    this.repositoryUnderTest = spy(DebtRepository.class);
    this.serviceUnderTest = new DeleteDebtService(this.daoUnderTest, this.repositoryUnderTest);
  }

  @Test
  void deleteDebtSuccess() {
    // Arrage
    String idClient = "123465";

    doReturn(TRUE).when(this.daoUnderTest).existsByIdClient(anyString());

    // Act
    this.serviceUnderTest.execute(idClient);

    // Assert
    verify(this.daoUnderTest, times(ONCE)).existsByIdClient(idClient);
    verify(this.repositoryUnderTest, times(ONCE)).delete(idClient);
  }

  @Test
  void deleteDebtExistByIdClientFail() {
    // Arrage
    String idClient = "123465";

    doReturn(FALSE).when(this.daoUnderTest).existsByIdClient(anyString());

    // Act - Assert
    assertThatThrownBy(() -> this.serviceUnderTest.execute(idClient))
        .isInstanceOf(NoDataException.class)
        .hasMessage(String.format(NO_EXISTS_A_DEBT_BY_ID_CLIENT, idClient));
  }
}