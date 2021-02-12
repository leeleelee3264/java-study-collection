package com.example.demo.Controller;

import com.example.demo.DB.DAO.UsersVO;
import com.example.demo.Service.UsersServiceImp;
import com.example.demo.tempInf.BeanValid.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    private final UsersServiceImp usersServiceImp;

    public ApiController(UsersServiceImp usersServiceImp) {
        this.usersServiceImp = usersServiceImp;
    }

    @PostMapping("/bean/valid")
    @ResponseBody
    public ResponseEntity beanValid(@Valid @RequestBody MessageDTO messageDTO) {
        String value = messageDTO.getMessage();
        return new ResponseEntity<>("Your request is accepted!", HttpStatus.OK);
    }

    @GetMapping("/jpa/get")
    public String getByJpa(
            @RequestParam @Nullable String name,
            Model model
    ) {
        List<UsersVO> users =  usersServiceImp.findByName(name);

        model.addAttribute("userList", users);
        return "mockTest";
    }

    @PostMapping("/jpa/save")
    @ResponseBody
    public ResponseEntity saveByJpa(
        @Valid @RequestBody UsersVO usersVO
    ) {
        UsersVO result = usersServiceImp.save(usersVO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
