package org.mm.mow.controller;


import org.mm.mow.entity.Actor;

import org.mm.mow.service.AccessService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

import java.security.Principal;


@Controller
public class AccessController {


    @Autowired
    private AccessService accessService;


    @GetMapping("/access")
    public String showAccess() {

        return "access";

    }

    @PostMapping("/access")
	public String processAccess(
    // HttpSession session,
       Principal principal,
       Model model) {

       /*******************************************************
        Convert this method to only for logout
        *******************************************************
    	String username = null;

        if (principal != null) {
        	username = principal.getName();
        }
          // Used with Spring Security

        // username = (String)session.getAttribute("username"); 
          // Used without Spring Security

        if (username != null && !username.equals("")) {
            return "redirect:/logout";
        } else {
           return "access";
        }
        *******************************************************/

        return "redirect:/logout";

    }

    @PostMapping("/login")
    public String loginAccess(
    // HttpSession session,
       Principal principal,
       Model model,
       @RequestParam(name = "address_email", required = false) String addressEmail,
       @RequestParam(name = "password", required = false) String password) {

        Actor actor = accessService.findLoginUser(addressEmail);
          // Used with Spring Security

        // Actor actor = accessService.findLoginUser(addressEmail, password);
          // Used without Spring Security

        if (actor == null) {

            return "redirect:/login_error";

        } else {

            // Setting of principal is automatic
              // Used with Spring Security

            // session.setAttribute("username", actor.getAddressEmail());
              // Used without Spring Security

            return "redirect:/login_success";

        }

    }

    @GetMapping("/login_error")
	public String showLoginError(
    // HttpSession session,
       Principal principal,
       Model model) {

        model.addAttribute("login_error", "Email Address or Password incorrect.");
        return "access";

    }

    @PreAuthorize("hasAnyRole('CAREGIVER', 'MEMBER', 'FSP', 'RIDER', 'MANAGEMENT')")
    @GetMapping("/login_success")
	public String showLoginSuccess(
    // HttpSession session,
       Principal principal,
       Model model) {

        model.addAttribute("login_success", "Login successful.");
        return "access";

    }

    @PreAuthorize("hasAnyRole('CAREGIVER', 'MEMBER', 'FSP', 'RIDER', 'MANAGEMENT')")
    @GetMapping("/logout")
	public String logoutAccess(
    // HttpSession session,
       Principal principal,
       Model model) {

        // Clearing of principal is automatic
          // Used with Spring Security

        // session.setAttribute("username", null);
          // Used without Spring Security
 
        return "redirect:/logout_success";

    }

    @GetMapping("/logout_success")
    public String showLogoutSuccess(
    // HttpSession session,
       Principal principal,
       Model model) {

       	model.addAttribute("logout_success", "Logout successful.");
        return "access";

    }


}
