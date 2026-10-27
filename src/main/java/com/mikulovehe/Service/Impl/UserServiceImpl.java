package com.mikulovehe.Service.Impl;

import com.mikulovehe.Dao.UserDao;
import com.mikulovehe.Service.UserService;
import com.mikulovehe.pojo.Result;
import com.mikulovehe.pojo.User;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mikulovehe.Util.nowTime;

import static com.mikulovehe.Util.tofUser.tofUser;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String insertUser(User user) {
        tofUser(user);
        user.setRegisterTime(nowTime.getTime());
        return userDao.insertUser(user) ? "添加成功" : "添加失败";
    }

    @Override
    public String updateUser(User user) {
        tofUser(user);
        return userDao.updateUser(user) ? "修改成功" : "修改失败";
    }

    @Override
    public String deleteUser(Integer id) {
        return userDao.deleteUserById(id) ? "删除成功" : "删除失败";
    }

    @Override
    public Result<String> login(User user) throws AuthException {
        tofUser(user);
        System.out.println(userDao.login(user));
        if (userDao.login(user) != null) {
            return Result.success("登录成功");
        } else {
            throw new AuthException("登录失败");
        }


    }

    @Override
    public boolean hasAdminRole(String username) {
        return userDao.hasAdminRole(username) != null;

    }
}
