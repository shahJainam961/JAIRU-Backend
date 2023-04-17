package com.spe.jairu.controller;

import com.spe.jairu.customModel.UserModel;
import com.spe.jairu.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getManagerData")
    public ResponseEntity<?> getAllManager()
    {
        try {
            List<UserModel> managers = adminService.getAllManager();
            return ResponseEntity.ok(managers);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getEmployeeData")
    public ResponseEntity<?> getAllEmployee()
    {
        try {
            List<UserModel> emps = adminService.getAllEmployee();
            return ResponseEntity.ok(emps);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/deleteUser")
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
