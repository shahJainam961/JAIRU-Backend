package com.spe.jairu.customModel;

import com.spe.jairu.bean.Project;
import com.spe.jairu.bean.TaskStatusLu;
import com.spe.jairu.bean.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {

    private Long taskId;

    private String taskName;

    private String description;

    private TaskStatusLu statusLu;
    private UserModel user;

}
