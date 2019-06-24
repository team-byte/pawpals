package com.pawpals.pawpals.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class AppUser implements Reviewables, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    String username;

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReviewListAboutMe(List<Review> reviewListAboutMe) {
        this.reviewListAboutMe = reviewListAboutMe;
    }

    public void setReviewsListAuthored(List<Review> reviewsListAuthored) {
        this.reviewsListAuthored = reviewsListAuthored;
    }

    String firstname;
    String lastname;
    int activity;
    String bio;
    String imgUrl;
    String password;
    String phoneNumber;
    int rating;
    @OneToMany
    List<Pet> petList;
    @OneToMany (mappedBy = "reviewSubject")
    List<Review> reviewListAboutMe;
    @OneToMany (mappedBy = "author")
    List<Review> reviewsListAuthored;

    public AppUser() {}

    public AppUser(String username, String firstName, String lastName, String password, String phoneNumber) {
        this.username = username;
        this.firstname = firstName;
        this.lastname = lastName;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getActivity() {
        return activity;
    }

    public String getBio() {
        return bio;
    }

    public String getImgUrl() {
        return imgUrl;
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public void addReview(Review review) {

    }

    @Override
    public void removeReview(Review review) {

    }

    @Override
    public int getAverage(Review review) {
        return 0;
    }
}
