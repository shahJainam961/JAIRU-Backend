package com.spe.jairu.service.admin;

import com.spe.jairu.bean.User;

import java.util.List;
import java.util.Map;

public interface AdminService {

    List<User> getAllManager();
    List<User> getAllEmployee();
    Map<String,String> deleteUser(Map<String,String> param);
}
