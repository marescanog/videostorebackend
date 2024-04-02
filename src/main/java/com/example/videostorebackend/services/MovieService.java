package com.example.videostorebackend.services;

import com.example.videostorebackend.models.Movie;
import com.example.videostorebackend.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> getMovies(){
        return repository.findAll();
    }

    public List<Movie> getFeaturedMovies() {
        return repository.findFeaturedMovies();
    }


    public void insertIntoMovies(Movie movie){
        repository.insert(movie);
    }
}
