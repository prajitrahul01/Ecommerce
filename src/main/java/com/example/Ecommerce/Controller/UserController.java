package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Model.UserForms;
import com.example.Ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    // Endpoint to register a new user
    @PostMapping("/registration")
    public User save(@RequestBody UserForms usrForms){
        return userService.save(usrForms);
    }

    // Endpoint for user login
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody User usr){
        return userService.userLogin(usr);
    }

}
