package com.mikulovehe.Service;

import com.mikulovehe.pojo.Result;
import com.mikulovehe.pojo.User;
import jakarta.security.auth.message.AuthException;

public interface UserService {
    String insertUser(User user);

    String updateUser(User user);

    String deleteUser(Integer id);

    Result<String> login(User user) throws AuthException;

    boolean hasAdminRole(String username);

}
