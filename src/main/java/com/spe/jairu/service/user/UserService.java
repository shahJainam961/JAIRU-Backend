package com.spe.jairu.service.user;

import com.spe.jairu.bean.User;
import com.spe.jairu.customModel.LoginUser;
import com.spe.jairu.customModel.UserModel;

import java.util.List;
import java.util.Map;

public interface UserService {
    LoginUser generateToken(Map<String, String> payload);

    UserModel saveUser(Map<String, String> payload);

    User findOne(String username);

    List<User> findAll();
}
