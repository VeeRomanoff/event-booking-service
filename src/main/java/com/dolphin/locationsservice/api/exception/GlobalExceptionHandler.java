package com.dolphin.locationsservice.api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDto> handleNotFoundException(EntityNotFoundException exception) {
        String message = exception.getMessage();
        String detailedMessage = exception.toString();
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(message, detailedMessage, LocalDateTime.now());

        return new ResponseEntity<>(errorMessageDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDto> handleGenericExceptions(Exception exception) {
        String message = exception.getMessage();
        String detailedMessage = exception.toString();
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(message, detailedMessage, LocalDateTime.now());

        return new ResponseEntity<>(errorMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDto> handleArgumentNotValidException(MethodArgumentNotValidException exception) {
        String message = exception.getMessage();
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(message, exception.getDetailMessageCode(), LocalDateTime.now());

        return new ResponseEntity<>(errorMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
