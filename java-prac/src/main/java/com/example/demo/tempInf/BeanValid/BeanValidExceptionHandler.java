package com.example.demo.tempInf.BeanValid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
@Slf4j
public class BeanValidExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleBeanValid(MethodArgumentNotValidException e) {

        String errorMsg = e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        log.error(errorMsg);

        return new ResponseEntity<>("Your request is caught by bean valid exception handler!", HttpStatus.BAD_REQUEST);
    }
}
