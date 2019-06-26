package com.pawpals.pawpals.controllers;

import com.pawpals.pawpals.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ReviewController {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    ReviewRepository<PetReview> petReviewRepository;

    @Autowired
    ReviewRepository<UserReview> userReviewRepository;

    @PostMapping("/writenewreview")
    public RedirectView writeeNewReview(Principal p, String rating, String body, String target) {


        return new RedirectView("/");
    }

    @PostMapping("/users/{targetId}/review")
    public RedirectView addUserReview(@PathVariable long targetId, Principal p, String rating, String body) {
        AppUser targetUser = appUserRepository.findById(targetId).get();
        AppUser reviewAuthor = appUserRepository.findByUsername(p.getName());

        UserReview userReview = new UserReview(Integer.parseInt(rating), body, reviewAuthor, targetUser);
        userReviewRepository.save(userReview);

        return new RedirectView("/users/" + targetId);
    }

    @PostMapping("/pets/{targetId}/review")
    public RedirectView addPetReview(@PathVariable long targetId, Principal p, String rating, String body) {
        Pet targetPet = petRepository.findById(targetId).get();
        AppUser reviewAuthor = appUserRepository.findByUsername(p.getName());

        PetReview petReview = new PetReview(Integer.parseInt(rating), body, reviewAuthor, targetPet);
        petReviewRepository.save(petReview);

        return new RedirectView("/pets/" + targetId);
    }
}
