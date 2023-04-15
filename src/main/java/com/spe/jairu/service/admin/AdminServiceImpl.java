package com.spe.jairu.service.admin;

import com.spe.jairu.bean.User;
import com.spe.jairu.repository.UserRepository;
import com.spe.jairu.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public List<User> getAllManager()
    {
        List<User> managers = new ArrayList<User>();
        userRepository.getAllManager().forEach(manager->managers.add(manager));
        return managers;
    }

    public List<User> getAllEmployee()
    {
        List<User> emps = new ArrayList<User>();
        userRepository.getAllEmployee().forEach(emp->emps.add(emp));
        return emps;
    }

    public Map<String,String> deleteUser(Map<String,String> param)
    {
        long id = Long.parseLong(param.get("userId"));
        System.out.println(id);
        userRepository.deleteById(id);
        Map<String,String> res = new HashMap<>();
        res.put("msg","User Deleted");
        return res;
    }
}
