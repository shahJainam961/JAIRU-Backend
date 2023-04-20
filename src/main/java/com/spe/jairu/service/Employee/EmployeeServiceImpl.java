package com.spe.jairu.service.Employee;

import com.spe.jairu.bean.Project;
import com.spe.jairu.bean.Task;
import com.spe.jairu.bean.TaskStatusLu;
import com.spe.jairu.bean.User;
import com.spe.jairu.repository.ProjectRepository;
import com.spe.jairu.repository.TaskRepository;
import com.spe.jairu.repository.TaskStatusLuRepository;
import com.spe.jairu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusLuRepository taskStatusLuRepository;

    @Override
    public List<Project> getAllProjects(String username)
    {
        List<Project> projects = new ArrayList<>();
        User user = userService.findOne(username);
        projectRepository.getAllProjectByUserId(user.getUserId()).forEach(project -> projects.add(project));
        return projects;
    }

    @Override
    public List<Task> getAllTaskByProjectByUser(Map<String,String> param,String username)
    {
        Long projectId = Long.parseLong(param.get("projectId"));
        User user = userService.findOne(username);
        List<Task> taskList = taskRepository.findAllByProject_ProjectIdAndUser_UserId(projectId,user.getUserId());
        return taskList;
    }

    @Override
    public List<Task> updateTaskStatus(Map<String,String> payload,String username)
    {
        Long taskId = Long.parseLong(payload.get("taskId"));
        Long statusLuId  = Long.parseLong(payload.get("statusId"));
        Long projectId = Long.parseLong(payload.get("projectId"));
        Task task = taskRepository.findByTaskId(taskId);
        TaskStatusLu taskStatusLu = taskStatusLuRepository.findByTaskStatusLuId(statusLuId);
        task.setStatusLu(taskStatusLu);
        taskRepository.save(task);
        User user = userService.findOne(username);
        List<Task> taskList = taskRepository.findAllByProject_ProjectIdAndUser_UserId(projectId,user.getUserId());
        return taskList;
    }
}
