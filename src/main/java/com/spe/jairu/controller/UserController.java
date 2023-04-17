package com.spe.jairu.controller;

import com.spe.jairu.bean.User;
import com.spe.jairu.config.JwtService;
import com.spe.jairu.customModel.AuthToken;
import com.spe.jairu.customModel.LoginUser;
import com.spe.jairu.customModel.UserModel;
import com.spe.jairu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody Map<String,String> payload) throws AuthenticationException {
        try {
            User user = userService.generateToken(payload);
            User userDetails = new User();
            userDetails.setUsername(user.getUsername());
            List<String> rolesList= new ArrayList<>();
            user.getRoles().forEach(role->{
                rolesList.add(role.getName());
            });
            final String token = jwtService.generateToken(userDetails, rolesList);
            return ResponseEntity.ok(new AuthToken(token));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody Map<String,String> payload){
        try {
            UserModel userModel = userService.saveUser(payload);
            return ResponseEntity.ok(userModel);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @PreAuthorize("hasAuthority('MANAGER')")
    @RequestMapping(value="/managerping", method = RequestMethod.GET)
    public ResponseEntity<?> managerPing(){
        try {
            Map<String, String> res = new HashMap<>();
            res.put("msg", "Only Manager Can Read This");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public ResponseEntity<?> adminPing(){
        try {
            Map<String, String> res = new HashMap<>();
            res.put("msg", "Only admin Can Read This");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping(value="/employeeping", method = RequestMethod.GET)
    public ResponseEntity<?> employeePing(){
        try {
            Map<String, String> res = new HashMap<>();
            res.put("msg", "Only Employee Can Read This");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

