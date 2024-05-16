package org.mm.mow.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class AccessDenialController {


    @GetMapping("/access_denial")
    public ModelAndView error403() {

        ModelAndView model = new ModelAndView();
        model.setViewName("access_denial");
        return model;

	}


}
