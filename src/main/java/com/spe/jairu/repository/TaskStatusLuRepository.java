package com.spe.jairu.repository;

import com.spe.jairu.bean.TaskStatusLu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusLuRepository extends CrudRepository<TaskStatusLu,Long> {
    TaskStatusLu findByTaskStatusLuId(Long id);
}
