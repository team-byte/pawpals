package com.pawpals.pawpals.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements Reviewables, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    String username;
    String firstName;
    String lastName;
    int activity;
    String bio;
    String image;
    String password;
    String phoneNumber;
    @OneToMany
    List<Pet> petList;
    @OneToMany
    List<Review> reviewListAboutMe;
    @OneToMany
    List<Review> reviewsListAuthored;

    public User() {}

    public User(String username, String firstName, String lastName, String password, String phoneNumber) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getActivity() {
        return activity;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public List<Review> getReviewListAboutMe() {
        return reviewListAboutMe;
    }

    public List<Review> getReviewsListAuthored() {
        return reviewsListAuthored;
    }

    
}
