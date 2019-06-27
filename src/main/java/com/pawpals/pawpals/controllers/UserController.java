package com.pawpals.pawpals.controllers;

import com.pawpals.pawpals.models.AppUser;
import com.pawpals.pawpals.models.AppUserRepository;
import com.pawpals.pawpals.models.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserController {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String getSignUp() {
        return "signup";
    }

    @PostMapping("/createnewuser")
    public RedirectView createNewUser(@RequestParam String username,
                                      @RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam String password,
                                      @RequestParam String phoneNumber,
                                      @RequestParam int activity,
                                      @RequestParam String bio,
                                      @RequestParam String imgUrl) {
        AppUser newUser = new AppUser(username, firstName, lastName, bCryptPasswordEncoder.encode(password), phoneNumber, activity, bio, imgUrl);
        appUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/myprofile");
    }

    @GetMapping("/myprofile")
    public String myProfile(Principal p, Model m) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("p", p);
        m.addAttribute("user", user);
        m.addAttribute("target", user);
        return "myProfile";
    }

    @GetMapping("/users")
    public String getUsers(Principal p, Model m) {
        Iterable<AppUser> usersIterable = appUserRepository.findAll();
        ArrayList<AppUser> users = new ArrayList<>();
        for (AppUser user: usersIterable) {
            if (!user.equals(appUserRepository.findByUsername(p.getName())))
                users.add(user);
        }
        m.addAttribute("users", users);
        m.addAttribute("p", p);
        return "usersList";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable long id, Principal p, Model m) {
        AppUser user = appUserRepository.findById(id).get();
        m.addAttribute("target", user);
        m.addAttribute("user", user);
        m.addAttribute("type", "users");
        m.addAttribute("p", p);
        return "userProfile";
    }

    @GetMapping("/updateprofile")
    public String getUpdateProfile(Principal p, Model m) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("p", p);
        m.addAttribute("user", user);
        m.addAttribute("target", user);
        return "updateprofile";
    }

    @PostMapping("/updateprofile")
    public RedirectView updateProfile(@RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam String phoneNumber,
                                      @RequestParam int activity,
                                      @RequestParam String bio,
                                      @RequestParam String imgUrl,
                                      Principal p,
                                      Model m) {
        AppUser user = appUserRepository.findByUsername(p.getName());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setActivity(activity);
        user.setBio(bio);
        user.setImgUrl(imgUrl);
        appUserRepository.save(user);
        m.addAttribute("p", p);
        return new RedirectView("/myprofile");
    }
}
