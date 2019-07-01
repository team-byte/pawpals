package com.pawpals.pawpals.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    String species;
    String breed;
    int age;
    String bio;
    int activity;
    String size;
    String imgUrl;
    int rating;

    @ManyToOne
    AppUser owner;
    // would change this so two or more owners could be linked to a single pet.

    @OneToMany (mappedBy = "petReviewSubject")
    List<PetReview> reviewListAboutMe;

    //one to many playdate list.

    public Pet() {}

    public Pet(String name, String species, String breed, String bio, int age, int activity, String size, String imgUrl, AppUser owner) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.bio = bio;
        this.activity = activity;
        this.size = size;
        this.imgUrl = imgUrl;
        this.owner = owner;
        this.rating = 5;
    }

    public void updateRating() {
        int sum = 0;
        for (PetReview review : reviewListAboutMe) {
            sum += review.rating;
        }
        rating = sum / reviewListAboutMe.size();
    }

    /*
        Setters and Getters Below
     */

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getBio() {
        return bio;
    }

    public int getActivity() {
        return activity;
    }

    public String getSize() {
        return size;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getRating() {
        return rating;
    }

    public AppUser getOwner() {
        return owner;
    }

    public List<PetReview> getReviewListAboutMe() {
        return reviewListAboutMe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }
}
