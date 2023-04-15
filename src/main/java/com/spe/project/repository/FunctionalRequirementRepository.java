package com.spe.project.repository;

import com.spe.project.bean.FunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionalRequirementRepository extends JpaRepository<FunctionalRequirement,Long> {
}
