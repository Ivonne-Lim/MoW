package org.mm.mow.controller;


import org.mm.mow.entity.Actor;

import org.mm.mow.service.RegisterService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

import java.security.Principal;


@Controller
public class RegisterController {


	@Autowired
    private RegisterService registerService;


    @GetMapping("/register")
	public String showRegister(
    // HttpSession session,
       Principal principal,
       Model model) {

        Actor actor = new Actor();
        String username = null;

        if (principal != null) {
            username = principal.getName();
        }        
          // Used with Spring Security

        // username = (String)session.getAttribute("username");
          // Used without Spring Security

        if (username != null && !username.equals("")) {
            actor = registerService.findActor(username);
        }

        if (actor.getRole() != null && actor.getRole().equals("Member")) {
            model.addAttribute("diets", registerService.findDiets());
            model.addAttribute("caregivers", registerService.findCaregivers());
        }
        model.addAttribute("actor", actor);
        return "register";

    }

    @PostMapping("/register")
    public String saveRegister(
    // HttpSession session,
       Principal principal,
       Model model,
       @ModelAttribute("actor") Actor actor,
       @RequestParam(name = "diet_id", required = false) String diet_Id,
       @RequestParam(name = "caregiver_id", required = false) String caregiver_Id) {

        actor = registerService.saveActor(actor, diet_Id, caregiver_Id);

        if (actor.getRole().equals("Member")) {
            model.addAttribute("diets", registerService.findDiets());
            model.addAttribute("caregivers", registerService.findCaregivers());
        }
        model.addAttribute("actor", actor);
        return "register";

    }


}
