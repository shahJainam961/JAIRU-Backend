package com.spe.jairu.customModel;

import com.spe.jairu.bean.EffortTable;
import com.spe.jairu.bean.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {
    private Long projectId;
    private String projectName;
    private String description;
    private Set<UserModel> users;
    private Set<TaskModel> tasks;
    private EffortTable effortTable;
}

