package org.bluebits.mocki.exceptions;

/**
 * Created by satyajit on 9/30/15.
 */
public class MockiConfigurationException extends Exception {
  public MockiConfigurationException() {

  }

  public MockiConfigurationException(String message) {
    super(message);
  }

  public MockiConfigurationException(Throwable cause) {
    super(cause);
  }

  public MockiConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }
}
