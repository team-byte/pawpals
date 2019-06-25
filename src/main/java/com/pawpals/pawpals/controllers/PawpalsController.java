package com.pawpals.pawpals.controllers;


import com.pawpals.pawpals.models.AppUser;
import com.pawpals.pawpals.models.AppUserRepository;
import com.pawpals.pawpals.models.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class PawpalsController {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PetRepository petRepository;

    @GetMapping(value = {"/", "login"})
    public String getHome(Principal p, Model m) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("p", p);
        m.addAttribute("user", user);
        return "login";
    }

}