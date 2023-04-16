package by.it.academy.truck.controllers;

import by.it.academy.truck.dto.ErrorResponse;
import by.it.academy.truck.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException exception) {
        log.warn("EXCEPTION. {}", exception.getMessage());
        return new ErrorResponse(exception.getMessage(), LocalDateTime.now());
    }
}
