package org.bluebits.mocki.exceptions;

/**
 * Created by satyajit on 9/30/15.
 */
public class MockiException extends Exception {
  public MockiException() {

  }

  public MockiException(String message) {
    super(message);
  }

  public MockiException(Throwable cause) {
    super(cause);
  }

  public MockiException(String message, Throwable cause) {
    super(message, cause);
  }
}
