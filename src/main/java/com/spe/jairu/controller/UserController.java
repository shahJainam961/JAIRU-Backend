package com.spe.jairu.controller;

import com.spe.jairu.bean.User;
import com.spe.jairu.config.JwtService;
import com.spe.jairu.customModel.AuthToken;
import com.spe.jairu.customModel.LoginUser;
import com.spe.jairu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
            LoginUser loginUser = userService.generateToken(payload);
            User userDetails = new User();
            userDetails.setUsername(loginUser.getUsername());
            final String token = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(new AuthToken(token));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody Map<String,String> payload){
        try {
            User user = userService.saveUser(payload);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @PreAuthorize("hasRole('MANAGER')")
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

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('EMPLOYEE')")
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

