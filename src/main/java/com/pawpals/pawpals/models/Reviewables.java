package com.pawpals.pawpals.models;

import javax.persistence.Embeddable;


public interface Reviewables {

    void addReview(Review review);

    void removeReview(Review review);

    int getAverage(Review review);


}
