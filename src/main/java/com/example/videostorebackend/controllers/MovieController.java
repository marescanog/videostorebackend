package com.example.videostorebackend.controllers;

import com.example.videostorebackend.models.Movie;
import com.example.videostorebackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return service.getMovies();
    }

    @PostMapping(value = "/movies",consumes={MediaType.APPLICATION_JSON_VALUE})
    public void addMovie(@RequestBody Movie movie){
        service.insertIntoMovies(movie);
    }
}
