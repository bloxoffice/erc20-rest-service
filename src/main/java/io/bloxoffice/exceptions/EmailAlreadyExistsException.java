package io.bloxoffice.exceptions;

/**
 * Created by mamu on 3/26/18.
 */
public class EmailAlreadyExistsException extends RuntimeException{

  public EmailAlreadyExistsException(String message){
    super(message);
  }
}
