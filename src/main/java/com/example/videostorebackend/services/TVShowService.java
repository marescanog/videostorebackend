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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

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

    public Optional<TVShow> updateTVShow(String id, TVShow updatedTVShow) {
        Optional<TVShow> found = repository.findById(id);

        if(found.isEmpty()){
            return Optional.empty();
        }

        return found
                .map(tvShow -> {

                    String title = updatedTVShow.getTitle();
                    Integer numSeasons = updatedTVShow.getNumOfSeasons();
                    Integer numEpisodes = updatedTVShow.getNumOfTotalEpisodes();
                    String description = updatedTVShow.getDescription();
                    String rating = updatedTVShow.getRating();
                    List<String> genre = updatedTVShow.getGenre();
                    Float rentPrice = updatedTVShow.getRentPrice();
                    Float buyPrice = updatedTVShow.getBuyPrice();
                    String posterImage = updatedTVShow.getPosterImage();
                    String backgroundImage = updatedTVShow.getBackgroundImage();
                    String releaseDate = updatedTVShow.getReleaseDate();
                    String promoType = updatedTVShow.getPromoType();
                    String addedOn = updatedTVShow.getAddedOn();
                    String releaseYear = updatedTVShow.getReleaseYear();
                    Integer totalRatings = updatedTVShow.getTotalRatings();
                    Boolean IsFeatured = updatedTVShow.isFeatured();
                    String mparating = updatedTVShow.getMparating();
                    String trailerURL = updatedTVShow.getTrailerUrl();
                    Boolean mostDemanded = updatedTVShow.isMostDemanded();

                    if(title != null){
                        tvShow.setTitle(title);
                    }

                    if(numSeasons != null){
                        tvShow.setNumOfSeasons(numSeasons);
                    }

                    if(numEpisodes != null){
                        tvShow.setNumOfSeasons(numEpisodes);
                    }

                    if(description != null){
                        tvShow.setDescription(description);
                    }

                    if(rating != null){
                        tvShow.setRating(rating);
                    }

                    if(genre != null){
                        tvShow.setGenre(genre);
                    }

                    if(rentPrice != null){
                        tvShow.setRentPrice(rentPrice);
                    }

                    if(buyPrice != null){
                        tvShow.setBuyPrice(buyPrice);
                    }

                    if(posterImage != null){
                        tvShow.setPosterImage(posterImage);
                    }

                    if(backgroundImage != null){
                        tvShow.setBackgroundImage(backgroundImage);
                    }

                    if(releaseDate != null){
                        tvShow.setReleaseDate(releaseDate);
                    }

                    if(promoType != null){
                        tvShow.setPromoType(promoType);
                    }

                    if(addedOn != null){
                        tvShow.setAddedOn(addedOn);
                    }

                    if(releaseYear != null){
                        tvShow.setReleaseYear(releaseYear);
                    }

                    if(totalRatings != null){
                        tvShow.setTotalRatings(totalRatings);
                    }

                    if(IsFeatured != null){
                        tvShow.setFeatured(IsFeatured);
                    }

                    if(mparating != null){
                        tvShow.setMparating(mparating);
                    }

                    if(trailerURL != null){
                        tvShow.setTrailerUrl(trailerURL);
                    }

                    if(mostDemanded != null){
                        tvShow.setMostDemanded(mostDemanded);
                    }
                    return repository.save(tvShow);
                });
    }

    public void deleteTVShow(String id) throws ResponseStatusException{
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TVShow not found with id " + id);
        }
        repository.deleteById(id);
    }
}
