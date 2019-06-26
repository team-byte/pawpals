package com.pawpals.pawpals.models;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository<T extends Review> extends CrudRepository<T, Long> {
}
