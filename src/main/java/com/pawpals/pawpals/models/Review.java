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
}

//@Entity
//public class Review {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    long id;
//
//    int rating;
//    String body;
//
//    @ManyToOne
//    AppUser author;
//
//    private Date createdOn;
//
//    @Entity
//    public class PetReview extends Review{
//      @ManyToOne
//      Pet petReviewSubject;
//
//      public PetReview() {}
//
//        public PetReview(int rating, String body, AppUser author, Pet petReviewSubject) {
//            this.rating = rating;
//            this.body = body;
//            this.author = author;
//            this.petReviewSubject = petReviewSubject;
//        }
//
//        public Pet getPetReviewSubject() {
//            return petReviewSubject;
//        }
//
//        public void setPetReviewSubject(Pet petReviewSubject) {
//            this.petReviewSubject = petReviewSubject;
//        }
//    }
//
//    @Entity
//    public class UserReview extends Review {
//        @ManyToOne
//        AppUser userReviewSubject;
//
//        public UserReview() {}
//
//        public UserReview(int rating, String body, AppUser author, AppUser userReviewSubject) {
//            this.rating = rating;
//            this.body = body;
//            this.author = author;
//            this.userReviewSubject = userReviewSubject;
//        }
//
//        public AppUser getUserReviewSubject() {
//            return userReviewSubject;
//        }
//
//        public void setUserReviewSubject(AppUser userReviewSubject) {
//            this.userReviewSubject = userReviewSubject;
//        }
//    }
//
//
//    public long getId() {
//        return id;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public AppUser getAuthor() {
//        return author;
//    }
//
//    public Date getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public void setAuthor(AppUser author) {
//        this.author = author;
//    }
//
//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }
//}
