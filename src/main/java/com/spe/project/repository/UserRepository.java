package com.spe.project.repository;

import com.spe.project.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUserId(Long userId);

    @Query(value = "SELECT * FROM user U INNER JOIN user_roles UR ON U.user_id = UR.user_id WHERE UR.role_id=2",nativeQuery= true)
    List<User> getAllManager();

    @Query(value = "SELECT * FROM user U INNER JOIN user_roles UR ON U.user_id = UR.user_id WHERE UR.role_id=3",nativeQuery= true)
    List<User> getAllEmployee();

    @Query(value = "DELETE  FROM user U WHERE U.user_id=?1",nativeQuery= true)
    void deleteUser(Long userId);

    @Query(value = "SELECT * FROM (SELECT * FROM user UU INNER JOIN user_roles UR ON UU.user_id = UR.user_id WHERE UR.role_id=3) U WHERE U.user_id not in (SELECT UP.user_id FROM project_user UP WHERE UP.project_id=?1) " ,nativeQuery = true)
    List<User> getFreeEmployee(Long projectId);
}