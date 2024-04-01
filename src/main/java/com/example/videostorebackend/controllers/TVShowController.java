package com.example.videostorebackend.controllers;


import com.example.videostorebackend.models.TVShow;
import com.example.videostorebackend.services.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TVShowController {
    @Autowired
    private TVShowService service;

    @GetMapping("/tvshows")
    public List<TVShow> getTVShow(){
        return service.getTVShows();
    }

    @PostMapping(value = "/tvshows",consumes={MediaType.APPLICATION_JSON_VALUE})
    public void addTVShow(@RequestBody TVShow tvshow){
        service.insertIntoTVShows(tvshow);
    }
}
