package io.bloxoffice.exceptions;

/**
 * Created by mamu on 3/26/18.
 */
public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(String message){
    super(message);
  }
}
