package com.example.videostorebackend.services;

import com.example.videostorebackend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private TVShowRepository tvShowRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Movie> getMovies(){
        return repository.findAll();
    }

    public List<Movie> getFeaturedMovies() {
        return repository.findFeaturedMovies();
    }


    public Optional<Movie> insertIntoMovies(Movie movie){
        return Optional.of(repository.insert(movie));
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

    public List<Object> getMostDemandedShowsAndMovies() {
        List<Movie> mostDemandedMovies = repository.findMostDemandedMovies();
        List<TVShow> mostDemandedTVShows = tvShowRepository.findMostDemandedTVShows();

        // Combine results into a single list (for now as Object, ideally should be a common interface but no time to redesign)
        List<Object> combinedResults = new ArrayList<>();
        combinedResults.addAll(mostDemandedMovies);
        combinedResults.addAll(mostDemandedTVShows);

        return combinedResults;
    }

    public List<Object> getMostDemandedByReleaseyear(Integer releaseYear) {
        Query query = new Query();

        query.addCriteria(Criteria.where("mostDemanded").is(true));
        query.addCriteria(Criteria.where("releaseYear").is(releaseYear));

        List<Movie> mostDemandedMovies = mongoTemplate.find(query, Movie.class);
        List<TVShow> mostDemandedTVShows = mongoTemplate.find(query, TVShow.class);

        List<Object> combinedResults = new ArrayList<>();
        combinedResults.addAll(mostDemandedMovies);
        combinedResults.addAll(mostDemandedTVShows);

        return combinedResults;
    }

    public Optional<Movie> getMovieById(String id) {
        return repository.findById(id);
    }

    public Optional<Movie> updateMovie(String id, Movie updatedMovie) {
        Optional<Movie> found = repository.findById(id);

        if(found.isEmpty()){
            return Optional.empty();
        }

        return found
                .map(movie -> {
                    String title = updatedMovie.getTitle();
                    String description = updatedMovie.getDescription();
                    Float rating = updatedMovie.getRating();
                    List<String> genre = updatedMovie.getGenre();
                    Float rentPrice = updatedMovie.getRentPrice();
                    Float buyPrice = updatedMovie.getBuyPrice();
                    String posterImage = updatedMovie.getPosterImage();
                    String backgroundImage = updatedMovie.getBackgroundImage();
                    String MPARating = updatedMovie.getMPARating();
                    Integer Length = updatedMovie.getLength();
                    String releaseDate = updatedMovie.getReleaseDate();
                    String TrailerUrl = updatedMovie.getTrailerUrl();
                    Boolean IsFeatured = updatedMovie.isFeatured();
                    String addedOn = updatedMovie.getAddedOn();
                    String promoType = updatedMovie.getPromoType();
                    Boolean mostDemanded = updatedMovie.isMostDemanded();
                    Integer releaseYear = updatedMovie.getReleaseYear();
                    Integer totalRatings = updatedMovie.getTotalRatings();

                    if(title != null){
                        movie.setTitle(title);
                    }

                    if(description != null){
                        movie.setDescription(description);
                    }

                    if(rating != null){
                        movie.setRating(rating);
                    }

                    if(genre != null){
                        movie.setGenre(genre);
                    }

                    if(rentPrice != null){
                        movie.setRentPrice(rentPrice);
                    }

                    if(buyPrice != null){
                        movie.setBuyPrice(buyPrice);
                    }

                    if(posterImage != null){
                        movie.setPosterImage(posterImage);
                    }

                    if(backgroundImage != null){
                        movie.setBackgroundImage(backgroundImage);
                    }

                    if(MPARating != null){
                        movie.setMPARating(MPARating);
                    }

                    if(Length != null){
                        movie.setLength(Length);
                    }

                    if(releaseDate != null){
                        movie.setReleaseDate(releaseDate);
                    }

                    if(TrailerUrl != null){
                        movie.setTrailerUrl(TrailerUrl);
                    }

                    if(IsFeatured != null){
                        movie.setFeatured(IsFeatured);
                    }

                    if(addedOn != null){
                        movie.setAddedOn(addedOn);
                    }

                    if(promoType != null){
                       movie.setPromoType(promoType);
                    }

                    if(mostDemanded != null){
                        movie.setMostDemanded(mostDemanded);
                    }

                    if(releaseYear != null){
                        movie.setReleaseYear(releaseYear);
                    }

                    if(totalRatings != null){
                        movie.setTotalRatings(totalRatings);
                    }

                    return repository.save(movie);
                });
    }

    public Optional<Movie> deleteMovie(String id) {
        Optional<Movie> found = repository.findById(id);
        // can also use repository.existsById(id) but since the requirement is to return the deleted object
        // using this function instead
        if(found.isEmpty()){
            return Optional.empty();
        }

        if(id.isEmpty()){
            return Optional.empty();
        }

        repository.deleteById(id);

        return found;
    }
}



