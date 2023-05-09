package com.spe.jairu.service.manager;

import com.spe.jairu.bean.Project;
import com.spe.jairu.customModel.UserModel;

import java.util.List;
import java.util.Map;

public interface ManagerService {
    List<Project> getAllProject(String username);
    Project addProject(Map<String,String> payload,String username );
    Project updateProject(Map<String,String> payload);
    Map<String,String> removeProject(Map<String,String> param);
    List<UserModel> getFreeEmployee(Map<String,String> param);
    Project addUserToProject(Map<String,Object> payload);
    Project removeUserFromProject(Map<String,String> param);
    Project addTaskToProject(Map<String,String> payload);
    Project removeTaskFromProject(Map<String,String> param);
    Project updateEffortTable(Map<String,String> payload);
    Project initializeEffortTable(Project project);





}
