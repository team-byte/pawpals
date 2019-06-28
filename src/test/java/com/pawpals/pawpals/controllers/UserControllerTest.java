package com.pawpals.pawpals.controllers;

import com.pawpals.pawpals.models.AppUser;
import com.pawpals.pawpals.models.AppUserRepository;
import com.pawpals.pawpals.models.Pet;
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
    PetController PetController;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private AppUserRepository repository;

    @Test
    public void test_ControllerIsAutowired() {
        assertNotNull(UserController);
    }

    @Test
    public void test_Pet_ControllerIsAutowired() {
        assertNotNull(PetController);
    }

    @Test
    public void test_AppUser_constructor_username() {
        AppUser classUnderTest = new AppUser("chai", "Chai", "Naru", "password", "2899002231", 3, "this is a bio", "image.jpg");
        assertEquals("should return name chai","chai",classUnderTest.getUsername());
    }

    @Test
    public void test_AppUser_constructor_lname() {
        AppUser classUnderTest = new AppUser("chai", "Chai", "Naru", "password", "2899002231", 3, "this is a bio", "image.jpg");

        assertEquals("should return name Naru","Naru",classUnderTest.getLastName());
    }

    @Test
    public void test_AppUser_constructor_fname() {
        AppUser classUnderTest = new AppUser("chai", "Chai", "Naru", "password", "2899002231", 3, "this is a bio", "image.jpg");

        assertEquals("should return name Chai","Chai",classUnderTest.getFirstName());
    }

    @Test
    public void test_AppUser_constructor_Phonenumber() {
        AppUser classUnderTest = new AppUser("chai", "Chai", "Naru", "password", "2899002231", 3, "this is a bio", "image.jpg");

        assertEquals("should return phone number 2899002231","2899002231",classUnderTest.getPhoneNumber());
    }

    @Test
    public void test_Pet_constructor_name(){
        Pet classUnderTest = new Pet("Demi", "dog", "border collie", "I am a good dog", 8, 4, "medium", "demi.jpg", new AppUser());
        assertEquals("should return name Demi","Demi",classUnderTest.getName());
    }

    @Test
    public void test_Pet_constructor_breed(){
        Pet classUnderTest = new Pet("Demi", "dog", "border collie", "I am a good dog", 8, 4, "medium", "demi.jpg", new AppUser());

        assertEquals("should return breed 'border collie'","border collie",classUnderTest.getBreed());
    }

    @Test
    public void test_Pet_constructor_bio(){
        Pet classUnderTest = new Pet("Demi", "dog", "border collie", "I am a good dog", 8, 4, "medium", "demi.jpg", new AppUser());

        assertEquals("should return Bio 'I am a good dog'","I am a good dog",classUnderTest.getBio());
    }

    @Test
    public void test_Pet_constructor_activity(){
        Pet classUnderTest = new Pet("Demi", "dog", "border collie", "I am a good dog", 8, 4, "medium", "demi.jpg", new AppUser());

        assertEquals("should return activity good dog",4,classUnderTest.getActivity());
    }

    @Test
    public void test_Pet_constructor_size(){
        Pet classUnderTest = new Pet("Demi", "dog", "border collie", "I am a good dog", 8, 4, "medium", "demi.jpg", new AppUser());

        assertEquals("should return size medium","medium",classUnderTest.getSize());
    }

    @Test
    public void test_Pet_constructor_ImgUrl(){
        Pet classUnderTest = new Pet("Demi", "dog", "border collie", "I am a good dog", 8, 4, "medium", "demi.jpg", new AppUser());

        assertEquals("should return img demi.jpg","demi.jpg",classUnderTest.getImgUrl());
    }

    @Test
    public void test_Pet_constructor_rating(){
        Pet classUnderTest = new Pet("Demi", "dog", "border collie", "I am a good dog", 8, 4, "medium", "demi.jpg", new AppUser());
        assertEquals("should return rating",5,classUnderTest.getRating());
    }

// These tests are currently on hold.
//    @Test
//    public void test_Request_login() throws Exception {
//        mockMvc.perform(get("/login")).andExpect(content().string(containsString("Log in")));
//    }
//    @Test
//    public void test_Request_redirects_home() throws Exception {
//        mockMvc.perform(get("/")).andExpect(content().string(containsString("Log in")));
//    }

    @Test
    public void test_Request_singup() throws Exception {
        mockMvc.perform(get("/signup")).andExpect(content().string(containsString("Username")));
    }


    @Test
    public void test_Request_Aboutus() throws Exception {
        mockMvc.perform(get("/aboutPawpals")).andExpect(content().string(containsString("")));
    }

    @Test
    public void test_Request_createnewuser() throws Exception {
        mockMvc.perform(get("/createnewuser")).andExpect(content().string(containsString("")));
    }
}
