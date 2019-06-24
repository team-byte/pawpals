package com.pawpals.pawpals.models;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    int rating;
    String body;

    @ManyToOne
    AppUser author;

    Date createdOn;

//    @ManyToOne
//    Reviewable reviewSubject;


//    public Review() {}

//    public class PetReview extends Review{
//      @ManyToOne
//      Pet reviewSubject;
//
//      public PetReview() {}
//
//        public PetReview(int rating, String body, AppUser author, Pet reviewSubject) {
//            this.rating = rating;
//            this.body = body;
//            this.author = author;
//            this.reviewSubject = reviewSubject;
//        }
//    }

//    public class UserReview extends Review {
//        @ManyToOne
//        AppUser reviewSubject;

        public Review() {}

        public Review(int rating, String body, AppUser author, AppUser reviewSubject) {
            this.rating = rating;
            this.body = body;
            this.author = author;
//            this.reviewSubject = reviewSubject;
        }
//    }


    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getBody() {
        return body;
    }

    public AppUser getAuthor() {
        return author;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

//    public Reviewable getReviewSubject() {
//        return reviewSubject;
//    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(AppUser author) {
        this.author = author;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
