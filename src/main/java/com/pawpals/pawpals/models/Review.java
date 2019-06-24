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
    User author;
    Date createdOn;
    @ManyToOne
    Reviewables reviewSubject;

    Review() {}

    public Review(int rating, String body, User author, Reviewables reviewSubject) {
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

    public User getAuthor() {
        return author;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Reviewables getReviewSubject() {
        return reviewSubject;
    }


}
