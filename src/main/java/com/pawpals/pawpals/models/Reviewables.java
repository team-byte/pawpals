package com.pawpals.pawpals.models;

public interface Reviewables {

    void addReview(Review review);

    void removeReview(Review review);

    int getAverage(Review review);


}
