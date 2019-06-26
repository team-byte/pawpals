package com.pawpals.pawpals.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("user")
public class UserReview extends Review {

    @ManyToOne
    AppUser userReviewSubject;

    public UserReview() {}

    public UserReview(int rating, String body, AppUser author, AppUser userReviewSubject) {
        super(rating, body, author);
        this.userReviewSubject = userReviewSubject;
    }

    public AppUser getUserReviewSubject() {
        return userReviewSubject;
    }

    public void setUserReviewSubject(AppUser userReviewSubject) {
        this.userReviewSubject = userReviewSubject;
    }
}
