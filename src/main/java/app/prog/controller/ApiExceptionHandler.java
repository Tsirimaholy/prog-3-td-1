package app.prog.controller;

import app.prog.model.exception.ApiException;
import app.prog.model.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ApiException> handleApiRequestException(NotFoundException e){
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
