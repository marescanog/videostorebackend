package com.example.videostorebackend.services;

import com.example.videostorebackend.models.Movie;
import com.example.videostorebackend.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Movie> getMovies(){
        return repository.findAll();
    }

    public List<Movie> getFeaturedMovies() {
        return repository.findFeaturedMovies();
    }


    public void insertIntoMovies(Movie movie){
        repository.insert(movie);
    }

    public List<Movie> getFilteredSearch(String free, String genre, String sort, String name) {
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

        return mongoTemplate.find(query, Movie.class);
    }
}
