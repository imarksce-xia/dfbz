package com.controller;

import com.entity.User;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author admin iMarksce
 * @date 2020/10/7
 * @Description
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    public void add() {
        User user = new User();
        userService.add(user);
    }

    public void update() {
        User user = new User();
        userService.update(user);
    }
}
