package com.spe.jairu.repository;

import com.spe.jairu.bean.EffortTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffortRepository extends JpaRepository<EffortTable,Long> {
    EffortTable findByEffortTableId(Long etId);
}
