package org.mm.mow.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

import java.security.Principal;


@Controller
public class AppController {


    @GetMapping("/")
    public String showDefault() {

        return "redirect:/home";

    }

    @GetMapping("/home")
    public String showHome(
    // HttpSession session,
       Principal principal,
       Model model) {

        return "index";

    }


}
