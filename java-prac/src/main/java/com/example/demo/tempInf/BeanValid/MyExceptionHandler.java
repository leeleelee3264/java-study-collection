package com.example.demo.tempInf.BeanValid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBeanValid(MethodArgumentNotValidException e) {
        log.error("잡힘");
        String errorMsg = e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        log.error(errorMsg);

        return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
    }
}
