package com.spe.jairu.controller;

import com.spe.jairu.bean.Project;
import com.spe.jairu.bean.Task;
import com.spe.jairu.service.Employee.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/getAllProjects",method = RequestMethod.GET)
    public ResponseEntity<?> getAllProjects()
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Project> projects = employeeService.getAllProjects(username);

            return ResponseEntity.ok(projects);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getTaskByProject",method = RequestMethod.GET)
    public ResponseEntity<?> getAllTaskByProjectByUser(@RequestParam Map<String,String> param)
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Task> res = employeeService.getAllTaskByProjectByUser(param, username);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/updateTaskStatus",method = RequestMethod.POST)
    public ResponseEntity<?> updateTaskStatus(@RequestBody Map<String,String> payload)
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Task> res = employeeService.updateTaskStatus(payload, username);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
