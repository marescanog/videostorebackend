package com.example.videostorebackend.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TVShowRepository extends MongoRepository<TVShow, String> {
    @Query("{'mostDemanded': true}")
    List<TVShow> findMostDemandedTVShows();

    @Query("{'IsFeatured': true}")
    List<TVShow> findFeaturedTVShows();
}
