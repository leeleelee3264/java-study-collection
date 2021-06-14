package me.leelee3264.springbootgettingstarted.byfunc.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-14
 * description
 */
@RestController
public class UserController {


    @PostMapping("/users/create")
    public User createUser(
        @RequestBody User user
    ) {

        return user;
    }
}
