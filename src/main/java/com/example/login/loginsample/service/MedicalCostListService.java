package com.example.login.loginsample.service;

import com.example.login.loginsample.entity.MedicalCostList;
import com.example.login.loginsample.repository.MedicalCostListRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalCostListService {

    private final MedicalCostListRepository medicalCostListRepository;

    public MedicalCostListService(MedicalCostListRepository medicalCostListRepository) {
        this.medicalCostListRepository = medicalCostListRepository;
    }

    public List<MedicalCostList> searchAll() {
        return medicalCostListRepository.findAll();
    }
}
