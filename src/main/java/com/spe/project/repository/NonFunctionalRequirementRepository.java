package com.spe.project.repository;

import com.spe.project.bean.NonFunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonFunctionalRequirementRepository extends JpaRepository<NonFunctionalRequirement,Long> {
}
