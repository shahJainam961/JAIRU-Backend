package com.spe.jairu.controller;

import com.spe.jairu.bean.Project;
import com.spe.jairu.bean.Task;
import com.spe.jairu.customModel.ProjectModel;
import com.spe.jairu.customModel.TaskModel;
import com.spe.jairu.service.Employee.EmployeeService;
import com.spe.jairu.utils.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllProjects")
    public ResponseEntity<?> getAllProjects()
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Project> projects = employeeService.getAllProjects(username);
            List<ProjectModel> projectModels = new ArrayList<>();
            projects.forEach(project -> {
                projectModels.add(Constant.getModelMapper().map(project, ProjectModel.class));
            });
            return ResponseEntity.ok(projectModels);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getTaskByProject")
    public ResponseEntity<?> getAllTaskByProjectByUser(@RequestParam Map<String,String> param)
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Task> res = employeeService.getAllTaskByProjectByUser(param, username);
            List<TaskModel> taskModels = new ArrayList<>();
            res.forEach(task -> {
                taskModels.add(Constant.getModelMapper().map(task, TaskModel.class));
            });
            return ResponseEntity.ok(taskModels);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/updateTaskStatus")
    public ResponseEntity<?> updateTaskStatus(@RequestBody Map<String,String> payload)
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Task> res = employeeService.updateTaskStatus(payload, username);
            List<TaskModel> taskModels = new ArrayList<>();
            res.forEach(task -> {
                taskModels.add(Constant.getModelMapper().map(task, TaskModel.class));
            });
            return ResponseEntity.ok(taskModels);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
