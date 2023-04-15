package com.spe.jairu.repository;

import com.spe.jairu.bean.FunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionalRequirementRepository extends JpaRepository<FunctionalRequirement,Long> {
}
