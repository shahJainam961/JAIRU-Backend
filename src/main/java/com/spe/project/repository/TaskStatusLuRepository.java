package com.spe.project.repository;

import com.spe.project.bean.TaskStatusLu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusLuRepository extends CrudRepository<TaskStatusLu,Long> {
    TaskStatusLu findByTaskStatusLuId(Long id);
}
