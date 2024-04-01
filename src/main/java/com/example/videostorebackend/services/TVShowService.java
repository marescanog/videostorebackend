package com.example.videostorebackend.services;

import com.example.videostorebackend.models.TVShow;
import com.example.videostorebackend.models.TVShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TVShowService {
    @Autowired
    private TVShowRepository repository;
    public List<TVShow> getTVShows(){
        return repository.findAll();
    }

    public void insertIntoTVShows(TVShow tvshow){
        repository.insert(tvshow);
    }
}
