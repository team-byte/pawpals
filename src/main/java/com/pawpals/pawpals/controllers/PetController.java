package com.pawpals.pawpals.controllers;

import com.pawpals.pawpals.models.AppUser;
import com.pawpals.pawpals.models.AppUserRepository;
import com.pawpals.pawpals.models.Pet;
import com.pawpals.pawpals.models.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PetController {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PetRepository petRepository;

    @GetMapping("/petcreation")
    public String petCreation(Principal p, Model m) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("p", p);
        m.addAttribute("user", user);
        return "petCreation";
    }

    @PostMapping("/registernewpet")
    public RedirectView registerNewPet(Principal p, String name, String species, String breed, String age, String activity, String size, String imgUrl, String bio) {
        Pet newPet = new Pet(name, species, breed, bio, Integer.parseInt(age), Integer.parseInt(activity), size, imgUrl, appUserRepository.findByUsername(p.getName()));
        petRepository.save(newPet);

        return new RedirectView("/myprofile");
    }

    @GetMapping("delete/{id}")
    public RedirectView deletePet(Principal p, Model m, @PathVariable("id") long id) {
        petRepository.deleteById(id);
        return new RedirectView("/petprofile");
    }

    @GetMapping("/pets/{id}")
    public String singlePetProfile(@PathVariable Long id, Principal p, Model m) {
        Pet targetPet = petRepository.findById(id).get();
        m.addAttribute("target", targetPet);
        m.addAttribute("type", "pets");
        m.addAttribute("principal", p);
        return "petProfile";
    }

    @GetMapping("/pets")
    public String getPets(Principal p, Model m) {
        ArrayList<Pet> petList = (ArrayList) petRepository.findAll();
        m.addAttribute("pets", petList);
        m.addAttribute("p", p);
        return "petList";
    }
}
