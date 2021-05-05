package com.administrative.debt.domain.exception;

public class ExternalApiException extends RuntimeException {

  public ExternalApiException(String message) {
    super(message);
  }
}
