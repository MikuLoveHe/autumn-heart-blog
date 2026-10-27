package com.mikulovehe.Controller;

import com.mikulovehe.DTO.UserDTO;
import com.mikulovehe.Service.UserService;
import com.mikulovehe.pojo.Result;
import com.mikulovehe.pojo.User;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping
    public Result<String> login(@RequestBody UserDTO user) throws AuthException {
        System.out.println(user.getUsername() + " , " + user.getPassword());

        return userService.login(new User(user.getUsername(), user.getPassword()));

    }
}
