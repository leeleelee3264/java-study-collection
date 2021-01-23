package com.example.demo;

import com.example.demo.tempInf.BeanValid.MessageDTO;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import java.util.Set;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description: web 재시동 안 하고 단위테스트 하는 방법이라고 함
 */
public class ApiTest {

    private Validator validator;

    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void beanValidTest() {
        MessageDTO user = MessageDTO.builder()
                .adminId(1)
                .startTime("4r")
                .endTime("rr4")
                .message("message")
                .build();

        Set<ConstraintViolation<MessageDTO>> violations = validator.validate(user);

        assert violations.size() == 2;
    }
}
