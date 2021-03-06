package awyss.controller;


import awyss.exception.BindingResultException;
import awyss.exception.ValidationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ControllerHandlerException {

  @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public String notFoundExceptionHandler(ChangeSetPersister.NotFoundException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(ValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public String validationExceptionHandler(ValidationException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(BindingResultException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public Map<String, String> bindingResultExceptionHandler(BindingResultException ex) {
    return parse(ex.getBindingResult().getFieldErrors());
  }

  private Map<String, String> parse(List<FieldError> fieldErrors) {
    Map<String, String> errors = new HashMap<>();
    for (FieldError error: fieldErrors) {
      errors.put(error.getField(), error.getDefaultMessage());
    }
    return errors;
  }
}
