package com.pawpals.pawpals.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String username;
    String firstName;
    String lastName;
    int activity;
    String bio;
    String imgUrl;
    String password;
    String phoneNumber;
    int rating;

    @OneToMany (mappedBy = "owner")
    List<Pet> petList;

    @OneToMany (mappedBy = "userReviewSubject")
    List<UserReview> reviewListAboutMe;

    @OneToMany (mappedBy = "author")
    List<Review> reviewsListAuthored;

    // would put a One to many playdate list

    public AppUser() {}

    public AppUser(String username, String firstName, String lastName, String password, String phoneNumber, int activity, String bio, String imgUrl) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.activity = activity;
        this.bio = bio;
        this.rating = 5;
        this.petList = null;
        this.reviewListAboutMe = null;
        this.imgUrl = imgUrl;
    }

    public void updateRating() {
        int sum = 0;
        for (UserReview review : reviewListAboutMe) {
            sum += review.rating;
        }
        rating = sum / reviewListAboutMe.size();
    }

    /*
        Setters and Getters Below
     */
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

    public String getImgUrl() {
        return imgUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public List<UserReview> getReviewListAboutMe() {
        return reviewListAboutMe;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void addReview(Review review) {

    }

    public void removeReview(Review review) {

    }

    public int getAverage(Review review) {
        return 0;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public List<Review> getReviewsListAuthored() {
        return reviewsListAuthored;
    }

    public void setReviewsListAuthored(List<Review> reviewsListAuthored) {
        this.reviewsListAuthored = reviewsListAuthored;
    }
}
