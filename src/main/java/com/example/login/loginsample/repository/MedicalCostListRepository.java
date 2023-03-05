package com.example.login.loginsample.repository;

import com.example.login.loginsample.entity.MedicalCostList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCostListRepository extends JpaRepository<MedicalCostList, Long> {
}

