package com.spe.jairu.controller;

import com.spe.jairu.bean.User;
import com.spe.jairu.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/getManagerData", method = RequestMethod.GET)
    public ResponseEntity<?> getAllManager()
    {
        try {
            List<User> managers = adminService.getAllManager();
            return ResponseEntity.ok(managers);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getEmployeeData", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployee()
    {
        try {
            List<User> emps = adminService.getAllEmployee();
            return ResponseEntity.ok(emps);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public ResponseEntity<?> deleteUser(@RequestParam Map<String,String> param)
    {
        try {
            Map<String,String> res = adminService.deleteUser(param);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
}
