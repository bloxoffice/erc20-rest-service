package io.bloxoffice.exceptions;

import io.bloxoffice.models.ApiErrorResponse;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by mamu on 3/26/18.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(value = EmailAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiErrorResponse constraintViolationException(EmailAlreadyExistsException ex) {
    LOG.error(ex.getMessage());
    return new ApiErrorResponse(400, ex.getMessage());
  }

  @ExceptionHandler(value = { InvalidUserException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiErrorResponse invalidUserException(InvalidUserException ex) {
    LOG.error(ex.getMessage());
    return new ApiErrorResponse(400, ex.getMessage());
  }

  @ExceptionHandler(value = { UserNotFoundException.class })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiErrorResponse userNotFoundException(UserNotFoundException ex) {
    LOG.error(ex.getMessage());
    return new ApiErrorResponse(404, ex.getMessage());
  }

  @ExceptionHandler(value = { DatabaseException.class })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiErrorResponse databaseException(DatabaseException ex) {
    LOG.error(ex.getMessage());
    return new ApiErrorResponse(404, ex.getMessage());
  }

}
