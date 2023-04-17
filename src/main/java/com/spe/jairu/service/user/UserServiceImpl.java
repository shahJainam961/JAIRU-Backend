package com.spe.jairu.service.user;

import com.spe.jairu.bean.Role;
import com.spe.jairu.bean.User;
import com.spe.jairu.customModel.LoginUser;
import com.spe.jairu.customModel.UserModel;
import com.spe.jairu.repository.UserRepository;
import com.spe.jairu.service.role.RoleService;
import com.spe.jairu.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    @Override
    public User generateToken(Map<String, String> payload) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(payload.get("username"));
        loginUser.setPassword(payload.get("password"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(), loginUser.getPassword()
                )
        );

        return userRepository.findByUsername(loginUser.getUsername());
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public UserModel saveUser(Map<String, String> payload) {

        User user = new User();
        user.setUsername(payload.get("username"));
        user.setPassword(Constant.passwordEncode().encode(payload.get("password")));
        user.setName(payload.get("name"));
        user.setEmail(payload.get("email"));
        user.setBusinessTitle(payload.get("businessTitle"));
        user.setPhone(payload.get("phone"));
        Set<Role> roleSet = new HashSet<>();


        if(user.getEmail().split("@")[1].equals("admin.org")){
            Role role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }
        else if(user.getEmail().split("@")[1].equals("manager.org")){
            Role role = roleService.findByName("MANAGER");
            roleSet.add(role);
        }
        else if(user.getEmail().split("@")[1].equals("employee.org")){
            Role role = roleService.findByName("EMPLOYEE");
            roleSet.add(role);
        }

        user.setRoles(roleSet);
        user = userRepository.save(user);
        UserModel userModel = Constant.getModelMapper().map(user, UserModel.class);
        return userModel;
    }
}
