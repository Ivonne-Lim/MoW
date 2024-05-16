package org.mm.mow.controller;


import org.mm.mow.service.ReportService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

import java.security.Principal;


@Controller
public class ReportController {


	@Autowired
    private ReportService reportService;


	@PreAuthorize("hasRole('MANAGEMENT')")
    @GetMapping("/management/reports")
	public String showReports(
    // HttpSession session,
       Principal principal,
       Model model) {

        long caregivers = reportService.countActorsByRole("Caregiver");
        long members = reportService.countActorsByRole("Member");
        long fsps = reportService.countActorsByRole("FSP");
        long riders = reportService.countActorsByRole("Rider");
        long managers = reportService.countActorsByRole("Management");

        model.addAttribute("caregivers", caregivers);
        model.addAttribute("members", members);
        model.addAttribute("fsps", fsps);
        model.addAttribute("riders", riders);
        model.addAttribute("managers", managers);
        return "reports";

    }


}
