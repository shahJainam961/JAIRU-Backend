package com.spe.jairu.controller;

import com.spe.jairu.bean.Project;
import com.spe.jairu.bean.User;
import com.spe.jairu.service.manager.ManagerService;
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
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ResponseEntity<?> addProject(@RequestBody Map<String,String> payload)
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            Project res = managerService.addProject(payload, username);
            res = managerService.initializeEffortTable(res);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    public ResponseEntity<?> updateProject(@RequestBody Map<String,String> payload)
    {
        try {

        Project res = managerService.updateProject(payload);
        return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeProject(@RequestParam Map<String,String> param)
    {
        try {
            Map<String ,String> res = managerService.removeProject(param);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getAllProject", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProject()
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Project> projects = managerService.getAllProject(username);
            return ResponseEntity.ok(projects);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getFreeEmployee",method = RequestMethod.GET)
    public ResponseEntity<?> getFreeEmployee(@RequestParam Map<String,String> param)
    {
        try {
            List<User> freeEmployee = managerService.getFreeEmployee(param);
            return ResponseEntity.ok(freeEmployee);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/addUserToProject",method = RequestMethod.POST)
    public ResponseEntity<?> addUserToProject(@RequestBody Map<String,Object> payload)
    {
        try {
            Project res = managerService.addUserToProject(payload);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeUserFromProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeUserFromProject(@RequestParam Map<String,String> param)
    {
        try {
            Project res = managerService.removeUserFromProject(param);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value = "/addTaskToProject",method = RequestMethod.POST)
    public ResponseEntity<?> addTaskToProject(@RequestBody Map<String,String> payload)
    {
        try {
            Project res = managerService.addTaskToProject(payload);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeTaskFromProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeTaskFromProject(@RequestParam Map<String,String> param)
    {
        try {
            Project res = managerService.removeTaskFromProject(param);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/updateEffortTable",method = RequestMethod.POST)
    public ResponseEntity<?> updateEffortTable(@RequestBody Map<String,String> payload)
    {
        try {
            Project res = managerService.updateEffortTable(payload);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
