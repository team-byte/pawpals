package com.pawpals.pawpals.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class PawpalsController {

    @GetMapping(value = {"/", "login"})
    public String getHome(Principal p, Model m) {
        m.addAttribute("p", p);
        return "login";
    }

}
