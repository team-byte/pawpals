package com.pawpals.pawpals.controllers;

import com.pawpals.pawpals.models.AppUserRepository;
import com.pawpals.pawpals.models.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ReviewController {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PetRepository petRepository;

    @PostMapping("/writenewreview")
    public RedirectView writeeNewReview(Principal p, String rating, String body, String target) {


        return new RedirectView("/");
    }
}
