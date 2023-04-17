package com.spe.jairu.controller;

import com.spe.jairu.bean.Project;
import com.spe.jairu.bean.User;
import com.spe.jairu.customModel.ProjectModel;
import com.spe.jairu.customModel.UserModel;
import com.spe.jairu.service.manager.ManagerService;
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
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/addProject")
    public ResponseEntity<?> addProject(@RequestBody Map<String,String> payload)
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            Project res = managerService.addProject(payload, username);
            res = managerService.initializeEffortTable(res);
            return ResponseEntity.ok(Constant.getModelMapper().map(res, ProjectModel.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/updateProject")
    public ResponseEntity<?> updateProject(@RequestBody Map<String,String> payload)
    {
        try {
            Project res = managerService.updateProject(payload);
            return ResponseEntity.ok(Constant.getModelMapper().map(res, ProjectModel.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/removeProject")
    public ResponseEntity<?> removeProject(@RequestParam Map<String,String> param)
    {
        try {
            Map<String ,String> res = managerService.removeProject(param);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAllProject")
    public ResponseEntity<?> getAllProject()
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Project> projects = managerService.getAllProject(username);
            List<ProjectModel> projectModels = new ArrayList<>();
            projects.forEach(project -> {
                projectModels.add(Constant.getModelMapper().map(project, ProjectModel.class));
            });
            return ResponseEntity.ok(projectModels);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getFreeEmployee")
    public ResponseEntity<?> getFreeEmployee(@RequestParam Map<String,String> param)
    {
        try {
            List<UserModel> freeEmployee = managerService.getFreeEmployee(param);
            return ResponseEntity.ok(freeEmployee);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addUserToProject")
    public ResponseEntity<?> addUserToProject(@RequestBody Map<String,Object> payload)
    {
        try {
            Project res = managerService.addUserToProject(payload);
            return ResponseEntity.ok(Constant.getModelMapper().map(res, ProjectModel.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/removeUserFromProject")
    public ResponseEntity<?> removeUserFromProject(@RequestParam Map<String,String> param)
    {
        try {
            Project res = managerService.removeUserFromProject(param);
            return ResponseEntity.ok(Constant.getModelMapper().map(res, ProjectModel.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/addTaskToProject")
    public ResponseEntity<?> addTaskToProject(@RequestBody Map<String,String> payload)
    {
        try {
            Project res = managerService.addTaskToProject(payload);
            return ResponseEntity.ok(Constant.getModelMapper().map(res, ProjectModel.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/removeTaskFromProject")
    public ResponseEntity<?> removeTaskFromProject(@RequestParam Map<String,String> param)
    {
        try {
            Project res = managerService.removeTaskFromProject(param);
            return ResponseEntity.ok(Constant.getModelMapper().map(res, ProjectModel.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/updateEffortTable")
    public ResponseEntity<?> updateEffortTable(@RequestBody Map<String,String> payload)
    {
        try {
            Project res = managerService.updateEffortTable(payload);
            return ResponseEntity.ok(Constant.getModelMapper().map(res, ProjectModel.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
