package com.example.videostorebackend.controllers;

import com.example.videostorebackend.models.Movie;
import com.example.videostorebackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    /* Expected Endpoints from React App
     *
     *  /mostDemanded?releaseYear=2021
     *
     *  /movies?IsFeatured=true
     *
     *  /movies?free=on&genre=Action&sort=recentlyAdded
     *
     *  /movies?name=generic_name
     *
     * */

    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(
            @RequestParam(name = "IsFeatured", required = false) boolean IsFeatured
    ){
        if(IsFeatured) {
            return new ResponseEntity<>(service.getFeaturedMovies(), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/mostDemanded")
    public ResponseEntity<List<Movie>> getMostDemandedMoviesAndShows(
            @RequestParam(name = "releaseYear", required = false) String releaseYear
    ){
        if(releaseYear!=null) {
            return null;
        }
        return null;
    }

    @PostMapping(value = "/movies",consumes={MediaType.APPLICATION_JSON_VALUE})
    public void addMovie(@RequestBody Movie movie){
        service.insertIntoMovies(movie);
    }

}
