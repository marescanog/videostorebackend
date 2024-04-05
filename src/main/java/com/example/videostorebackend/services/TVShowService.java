package com.example.videostorebackend.services;

import com.example.videostorebackend.models.Movie;
import com.example.videostorebackend.models.TVShow;
import com.example.videostorebackend.models.TVShowRepository;
import com.example.videostorebackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class TVShowService {

    @Autowired
    private TVShowRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<TVShow> getTVShows(){

        return repository.findAll();
    }

    public List<TVShow> getFeaturedTVShows() {
        return repository.findFeaturedTVShows();
    }

    public List<TVShow> getFilteredSearch(String free, String genre, String sort, String name) {
        Query query = new Query();

        // Genre Filter
        if (genre != null && !genre.isEmpty()) {
            query.addCriteria(Criteria.where("genre").in(genre));
        }

        // Free Filter
        if ("on".equals(free)) {
            query.addCriteria(Criteria.where("promoType").is("Free with Ads"));
        }

        // Sorting
        if (sort != null && !sort.isEmpty()) {
            switch (sort){
                case "mostWatched":
                    query.with(Sort.by(Sort.Direction.DESC, "totalRatings"));
                    break;
                case "releaseDate":
                    query.with(Sort.by(Sort.Direction.ASC, "releaseDate"));
                    break;
                case "recentlyAdded":
                    query.with(Sort.by(Sort.Direction.ASC, "addedOn"));
                    break;
            }
        }

        // Name Filter
        if (name != null) {
            query.addCriteria(Criteria.where("title").regex(name, "i"));
        }

        return mongoTemplate.find(query, TVShow.class);
    }

    public void insertIntoTVShows(TVShow tvshow){
        repository.insert(tvshow);
    }

    public Optional<TVShow> getTVShowById(String id) {
        return repository.findById(id);
    }

}
