package org.mm.mow.controller;


import org.mm.mow.entity.MealPlan;

import org.mm.mow.service.MealPlanService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

import java.security.Principal;

import java.util.List;


@Controller
public class MealPlanController {


	@Autowired
    private MealPlanService mealPlanService;


	@PreAuthorize("hasRole('MANAGEMENT')")
    @GetMapping("/management/plans")
	public String showMealPlans(
    // HttpSession session,
       Principal principal,
       Model model) {

        List<MealPlan> mealPlans = mealPlanService.findMealPlans();

        model.addAttribute("mealPlans", mealPlans);
        return "mealplans";

    }


    @PreAuthorize("hasRole('MANAGEMENT')")
    @GetMapping("/management/plan")
    public String showMealPlan(
    // HttpSession session,
       Principal principal,
       Model model,
       @RequestParam(name = "id", required = false) String id) {

        MealPlan mealPlan = new MealPlan();
        if (id != null && !id.equals("")) {
            mealPlan = mealPlanService.findMealPlan(Integer.parseInt(id));
        }

        model.addAttribute("diets", mealPlanService.findDiets());
        model.addAttribute("fsps", mealPlanService.findFsps());
        model.addAttribute("mealPlan", mealPlan);
        return "mealplan";

    }

    @PreAuthorize("hasRole('MANAGEMENT')")
    @PostMapping("/management/plan")
    public String saveMealPlan(
    // HttpSession session,
       Principal principal,
       Model model,
       @ModelAttribute("mealplan") MealPlan mealPlan,
       @RequestParam(name = "diet_id", required = true) String diet_Id,
       @RequestParam(name = "fsp_id", required = true) String fsp_Id) {

        mealPlan = mealPlanService.saveMealPlan(mealPlan, diet_Id, fsp_Id);

        List<MealPlan> mealPlans = mealPlanService.findMealPlans();

        model.addAttribute("mealPlans", mealPlans);
        return "mealplans";

    }

    @PreAuthorize("hasRole('MANAGEMENT')")
    @GetMapping("/management/plan_deletion")
    public String deleteMealPlan(
    // HttpSession session,
       Principal principal,
       Model model,
       @RequestParam(name = "id", required = true) String id) {

        mealPlanService.deleteMealPlan(Integer.parseInt(id));

        List<MealPlan> mealPlans = mealPlanService.findMealPlans();

        model.addAttribute("mealPlans", mealPlans);
        return "mealplans";

    }


}
