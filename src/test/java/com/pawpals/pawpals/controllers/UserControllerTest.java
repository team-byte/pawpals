package com.pawpals.pawpals.controllers;

import com.pawpals.pawpals.models.AppUser;
import com.pawpals.pawpals.models.AppUserRepository;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {



    @Autowired
    UserController UserController;

    @Autowired
    MockMvc mockMvc;

//    @Autowired
//    private TestEntityManager entityManager;


    @Autowired
    private AppUserRepository repository;

    @Test
    public void test_ControllerIsAutowired() {
        assertNotNull(UserController);
    }

    @Test
    public void test_Request_login() throws Exception {
        mockMvc.perform(get("/login")).andExpect(content().string(containsString("Log in")));
    }
    @Test
    public void test_Request_redirects_home() throws Exception {
        mockMvc.perform(get("/")).andExpect(content().string(containsString("Log in")));
    }

    @Test
    public void test_Request_singup() throws Exception {
        mockMvc.perform(get("/signup")).andExpect(content().string(containsString("Username")));
    }

    @Test
    public void test_Request_createnewuser() throws Exception {
        mockMvc.perform(get("/createnewuser")).andExpect(content().string(containsString("")));
    }


//    @Test
//    public void testExample() throws Exception {
//        this.entityManager.persist(new AppUser("ChaiT", "Chai", "Naru", "password","2066788779"));
//        AppUser user = this.repository.findByUsername("ChaiT");
//        assertTrue(user.getFirstName().equals("Chai"));
//    }

}