package com.example.demo.Controller;

import com.example.demo.tempInf.BeanValid.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-23
 * description
 */
@Slf4j
@Controller
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/bean/valid")
    @ResponseBody
    public ResponseEntity beanValid(@Valid @RequestBody MessageDTO messageDTO) {
        String value = messageDTO.getMessage();
        return new ResponseEntity<>("Your request is accepted!", HttpStatus.OK);
    }
}
