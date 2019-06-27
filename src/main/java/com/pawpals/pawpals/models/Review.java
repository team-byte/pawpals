package com.pawpals.pawpals.models;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    int rating;
    String body;
    Timestamp createdOn;
    @ManyToOne
    AppUser author;

    String targetName;

    public Review() {}

    public Review(int rating, String body, AppUser author) {
        this.rating = rating;
        this.body = body;
        this.author = author;
        this.createdOn = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public AppUser getAuthor() {
        return author;
    }

    public void setAuthor(AppUser author) {
        this.author = author;
    }

    public String getTargetName() {
        return targetName;
    }
}

