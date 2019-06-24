package com.pawpals.pawpals.models;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    int rating;
    String body;
    @ManyToOne
    AppUser author;
    Date createdOn;
    @ManyToOne
    Reviewables reviewSubject;

    Review() {}

    public Review(int rating, String body, AppUser author, Reviewables reviewSubject) {
        this.rating = rating;
        this.body = body;
        this.author = author;
        this.reviewSubject = reviewSubject;
    }

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

    public Reviewables getReviewSubject() {
        return reviewSubject;
    }


}
