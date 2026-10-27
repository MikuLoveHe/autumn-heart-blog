package com.mikulovehe.Dao;

import com.mikulovehe.DTO.UserDTO;
import com.mikulovehe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;

@Mapper
public interface UserDao {
    @ResultMap("UserResultMap")
    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUserById(int id);

    String login(User user);

    String hasAdminRole(String username);
}
