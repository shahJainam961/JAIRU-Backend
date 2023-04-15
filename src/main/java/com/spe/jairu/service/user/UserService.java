package com.spe.jairu.service.user;

import com.spe.jairu.bean.User;
import com.spe.jairu.customModel.LoginUser;

import java.util.Map;

public interface UserService {
    LoginUser generateToken(Map<String, String> payload);

    User saveUser(Map<String, String> payload);
}
