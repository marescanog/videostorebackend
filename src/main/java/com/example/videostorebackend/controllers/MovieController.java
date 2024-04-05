package com.example.videostorebackend.controllers;

import com.example.videostorebackend.models.Movie;
import com.example.videostorebackend.models.TVShow;
import com.example.videostorebackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MovieController {

    /* Expected Endpoints from React App
     *
     *  /mostDemanded?releaseYear=2021 TODO
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

    @GetMapping("/")
    public ResponseEntity<String> homeOk(){
        return new ResponseEntity<>("API for videostore", HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(
            @RequestParam(name = "IsFeatured", required = false) boolean IsFeatured,
            @RequestParam(name = "free", required = false) String free,
            @RequestParam(name = "genre", required = false) String genre,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "name", required = false) String name
    ){
        System.out.println(free);
        if(IsFeatured) {
            return new ResponseEntity<>(service.getFeaturedMovies(), HttpStatus.OK);
        }

        // mostWatched releaseDate recentlyAdded
        if(sort != null){
            switch (sort) {
                case "mostWatched":
                case "releaseDate":
                case "recentlyAdded":
                    // Do nothing, this is just a shortcut to validate the sort params
                    break;
                default:
                    // Handling unexpected values
                    return ResponseEntity.noContent().build();
            }
        }

        // Action Adventure Horror
        if(genre != null){
            switch (genre) {
                case "Action":
                case "Adventure":
                case "Horror":
                    // Do nothing, this is just a shortcut to validate the genre params
                    break;
                default:
                    // Handling unexpected values
                    return ResponseEntity.noContent().build();
            }
        }


        if(free != null || genre != null || sort!= null || name != null){
            return new ResponseEntity<>(service.getFilteredSearch(free, genre, sort, name), HttpStatus.OK);
        }


        return new ResponseEntity<>(service.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/mostDemanded")
    public ResponseEntity<List<Object>> getMostDemandedMoviesAndShows(
            @RequestParam(name = "releaseYear", required = false) Integer releaseYear
    ){
        if(releaseYear!=null) {
            return new ResponseEntity<>(service.getMostDemandedByReleaseyear(releaseYear), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.getMostDemandedShowsAndMovies(), HttpStatus.OK);
    }

    @PostMapping(value = "/movies",consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addMovie(@Validated  @RequestBody Movie movie){
        service.insertIntoMovies(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Added new Movie!"));
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        Optional<Movie> found = service.getMovieById(id);

        if(found.isPresent()){
            return ResponseEntity.ok(found);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Movie not found!"));
    }

    @PutMapping(path = "/updateMovie/{id}", consumes = "application/json")
    public ResponseEntity<?> updateTVShow(@PathVariable String id, @RequestBody Movie movie) {
        Optional<Movie> updatedMovie = service.updateMovie(id, movie);

        if(updatedMovie.isPresent()){
            return ResponseEntity.ok(updatedMovie);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Movie not found!"));
    }

    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity<?> deleteTVShow(@PathVariable String id) {
        service.deleteMovie(id);
        return ResponseEntity.ok("deleted");
    }
}
