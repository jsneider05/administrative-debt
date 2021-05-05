package com.administrative.debt.domain.exception;

public class RequiredValueException extends RuntimeException {

  public RequiredValueException(String message) {
    super(message);
  }
}
