package com.pawpals.pawpals.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
