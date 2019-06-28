package com.pawpals.pawpals.controllers;

import com.pawpals.pawpals.models.AppUser;
import com.pawpals.pawpals.models.AppUserRepository;
import com.pawpals.pawpals.models.Pet;
import com.pawpals.pawpals.models.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class PetController {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PetRepository petRepository;

    //  Create New Pet Page
    @GetMapping("/petcreation")
    public String petCreation(Principal p, Model m) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("p", p);
        m.addAttribute("user", user);
        return "petCreation";
    }

    // Adds New Pet to Database
    @PostMapping("/registernewpet")
    public RedirectView registerNewPet(Principal p,
                                       @RequestParam String name,
                                       @RequestParam String species,
                                       @RequestParam String breed,
                                       @RequestParam String age,
                                       @RequestParam String activity,
                                       @RequestParam String size,
                                       @RequestParam String imgUrl,
                                       @RequestParam String bio) {
        Pet newPet = new Pet(name,
                species,
                breed,
                bio,
                Integer.parseInt(age),
                Integer.parseInt(activity),
                size,
                imgUrl,
                appUserRepository.findByUsername(p.getName()));
        petRepository.save(newPet);
        return new RedirectView("/myprofile");
    }

    // Delete Pet Page
    @GetMapping("delete/{id}")
    public RedirectView deletePet(Principal p, Model m, @PathVariable("id") long id) {
        petRepository.deleteById(id);
        return new RedirectView("/myprofile");
    }

    // View Pet Profile
    @GetMapping("/pets/{id}")
    public String singlePetProfile(@PathVariable Long id, Principal p, Model m) {
        Pet targetPet = petRepository.findById(id).get();
        m.addAttribute("target", targetPet);
        m.addAttribute("type", "pets");
        m.addAttribute("principal", p);
        m.addAttribute("p", p);
        return "petProfile";
    }

    // Get List of Pets Page
    @GetMapping("/pets")
    public String getPets(Principal p, Model m) {
        ArrayList<Pet> petList = (ArrayList) petRepository.findAll();
        m.addAttribute("pets", petList);
        m.addAttribute("p", p);
        return "petList";
    }
}
