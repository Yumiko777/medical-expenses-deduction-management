package com.example.login.loginsample.controller;

import com.example.login.loginsample.entity.MedicalCostList;
import com.example.login.loginsample.service.MedicalCostListService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class MedicalCostListController {

    private final MedicalCostListService medicalCostListService;

    public MedicalCostListController(MedicalCostListService medicalCostListService) {
        this.medicalCostListService = medicalCostListService;
    }

    @GetMapping("/")
    public String medicalCostList(Model model, @AuthenticationPrincipal UserDetails user) {
        List<MedicalCostList> medicalCostList = medicalCostListService.searchAll();
        model.addAttribute("medicalCostList", medicalCostList);
        model.addAttribute("username", user.getUsername());
        return "medical-cost-list";
    }
}
