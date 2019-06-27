package com.pawpals.pawpals.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("pet")
public class PetReview extends Review {

    @ManyToOne
    Pet petReviewSubject;

    public PetReview() {}

    public PetReview(int rating, String body, AppUser author, Pet petReviewSubject) {
        super(rating, body, author);
        this.petReviewSubject = petReviewSubject;
        this.targetName = petReviewSubject.name;
    }

    public Pet getPetReviewSubject() {
        return petReviewSubject;
    }

    public void setPetReviewSubject(Pet petReviewSubject) {
        this.petReviewSubject = petReviewSubject;
    }
}
