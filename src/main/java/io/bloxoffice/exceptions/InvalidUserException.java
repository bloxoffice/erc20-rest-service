package io.bloxoffice.exceptions;

/**
 * Created by mamu on 3/26/18.
 */
public class InvalidUserException extends RuntimeException {
  public InvalidUserException(String message){
    super(message);
  }
}
