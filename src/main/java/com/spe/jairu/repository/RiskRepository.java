package com.spe.jairu.repository;
import com.spe.jairu.bean.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRepository extends JpaRepository<Risk,Long> {
}
