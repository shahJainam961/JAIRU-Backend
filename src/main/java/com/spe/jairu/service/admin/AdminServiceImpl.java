package com.spe.jairu.service.admin;

import com.spe.jairu.customModel.UserModel;
import com.spe.jairu.repository.UserRepository;
import com.spe.jairu.service.role.RoleService;
import com.spe.jairu.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public List<UserModel> getAllManager()
    {
        List<UserModel> managers = new ArrayList<>();
        userRepository.findAllByRolesIn(List.of(2L)).forEach(manager->managers.add(Constant.getModelMapper().map(manager, UserModel.class)));
        return managers;
    }

    public List<UserModel> getAllEmployee()
    {
        List<UserModel> emps = new ArrayList<>();
        userRepository.findAllByRolesIn(List.of(3L)).forEach(emp->emps.add(Constant.getModelMapper().map(emp, UserModel.class)));
        return emps;
    }

    public Map<String,String> deleteUser(Map<String,String> param)
    {
        Long id = Long.parseLong(param.get("userId"));
        System.out.println(id);
        userRepository.deleteById(id);
        Map<String,String> res = new HashMap<>();
        res.put("msg","User Deleted");
        return res;
    }
}
