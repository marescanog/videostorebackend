package com.example.videostorebackend.controllers;


import com.example.videostorebackend.models.Movie;
import com.example.videostorebackend.models.TVShow;
import com.example.videostorebackend.services.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TVShowController {

    /* Expected Endpoints from React App
     *
     *  /shows?IsFeatured=true
     *
     *  /tv
     *
     *  /tv?free=on&genre=Action&sort=recentlyAdded
     *
     *  /tv?name=generic_name
     *
     * */

    @Autowired
    private TVShowService service;

    @GetMapping("/shows")
    public ResponseEntity<List<TVShow>> getFeaturedTVShow(
            @RequestParam(name = "IsFeatured", required = false) boolean IsFeatured
    ){
        if(IsFeatured) {
            return new ResponseEntity<>(service.getFeaturedTVShows(), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.getTVShows(), HttpStatus.OK);
    }

    @GetMapping("/tv")
    public ResponseEntity<List<TVShow>> getTVShow(
            @RequestParam(name = "free", required = false) String free,
            @RequestParam(name = "genre", required = false) String genre,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "name", required = false) String name
    ){
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

        return new ResponseEntity<>(service.getTVShows(), HttpStatus.OK);
    }

    @PostMapping(value = "/tvshows",consumes={MediaType.APPLICATION_JSON_VALUE})
    public void addTVShow(@RequestBody TVShow tvshow){
        service.insertIntoTVShows(tvshow);
    }
}
