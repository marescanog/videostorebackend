package com.example.videostorebackend.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    @Query("{'mostDemanded': true}")
    List<Movie> findMostDemandedMovies();

    @Query("{'IsFeatured': true}")
    List<Movie> findFeaturedMovies();
}
