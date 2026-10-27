package com.mikulovehe.Controller;

import com.mikulovehe.DTO.UserDTO;
import com.mikulovehe.Service.UserService;
import com.mikulovehe.Util.JwtTokenUtil;
import com.mikulovehe.pojo.Result;
import com.mikulovehe.pojo.User;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public String insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserDTO user) throws AuthException {
        System.out.println(user.getUsername() + " , " + user.getPassword());

        userService.login(new User(user.getUsername(), user.getPassword()));

        String token = jwtTokenUtil.generateToken(user.getUsername());

        return Result.success(token);

    }

}
