package com.spe.project.repository;

import com.spe.project.bean.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    Task findByTaskId(Long taskId);

    @Query(value = "SELECT * FROM task T WHERE T.project_id=?1 AND T.user_id=?2",nativeQuery = true)
    List<Task> getAllByProjectAndUser(Long projectId,Long userId);
}
