package com.pawpals.pawpals.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Pet implements Reviewables {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    User owner;

    @OneToMany (mappedBy = "reviewSubject")
    List<Review> reviewListAboutMe;

    Pet() {}

    public Pet(String name, String species, String breed, int age, String bio, int activity, String size, String imgUrl, int rating, User owner) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.bio = bio;
        this.activity = activity;
        this.size = size;
        this.imgUrl = imgUrl;
        this.rating = rating;
        this.owner = owner;
    }

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

    public User getOwner() {
        return owner;
    }

    public List<Review> getReviewListAboutMe() {
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

    public void setOwner(User owner) {
        this.owner = owner;
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
