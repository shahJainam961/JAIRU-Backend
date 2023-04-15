package com.spe.jairu.repository;

import com.spe.jairu.bean.NonFunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonFunctionalRequirementRepository extends JpaRepository<NonFunctionalRequirement,Long> {
}
