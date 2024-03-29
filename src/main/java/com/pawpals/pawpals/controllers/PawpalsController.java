package com.pawpals.pawpals.controllers;

import com.pawpals.pawpals.models.AppUser;
import com.pawpals.pawpals.models.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class PawpalsController {
    @Autowired
    AppUserRepository appUserRepository;

    // Home and Default Page
    @GetMapping(value = {"/", "login"})
    public String getHome(Principal p, Model m) {
        if (p != null) {
            AppUser user = appUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        m.addAttribute("p", p);
        return "login";
    }

    // About Us Page
    @GetMapping("/aboutpawpals")
    public String getAboutUs(Principal p, Model m) {
        m.addAttribute("p", p);
        return "aboutpawpals"; }
}
