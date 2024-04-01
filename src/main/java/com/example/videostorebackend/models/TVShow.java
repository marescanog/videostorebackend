package com.example.videostorebackend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("tvshows")
public class TVShow {
    @Id
    private String id;
    private String title;
    private int numOfSeasons;
    private int numOfTotalEpisodes;
    private String description;
    private String rating;
    private List<String> genre;
    private float rentPrice;
    private float buyPrice;
    private String posterImage;
    private String backgroundImage;
    private String releaseDate;
    private String promoType;
    private String addedOn;
    private String releaseYear;
    private int totalRatings;
    private boolean isFeatured;
    private String mparating;
    private String TrailerUrl;






    public TVShow() {
    }

    public TVShow(String id, String title, int numOfSeasons, int numOfTotalEpisodes, String description, String rating, List<String> genre, float rentPrice, float buyPrice, String posterImage, String backgroundImage, String MPARating, String releaseDate, String trailerUrl, boolean isFeatured, String promoType, String addedOn, String releaseYear, int totalRatings) {
        this.id = id;
        this.title = title;
        this.numOfSeasons = numOfSeasons;
        this.numOfTotalEpisodes = numOfTotalEpisodes;
        this.description = description;
        this.rating = rating;
        this.genre = genre;
        this.rentPrice = rentPrice;
        this.buyPrice = buyPrice;
        this.posterImage = posterImage;
        this.backgroundImage = backgroundImage;
        this.mparating = MPARating;
        this.releaseDate = releaseDate;
        TrailerUrl = trailerUrl;
        this.isFeatured = isFeatured;
        this.promoType = promoType;
        this.addedOn = addedOn;
        this.releaseYear = releaseYear;
        this.totalRatings = totalRatings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfSeasons() {
        return numOfSeasons;
    }

    public void setNumOfSeasons(int numOfSeasons) {
        this.numOfSeasons = numOfSeasons;
    }

    public int getNumOfTotalEpisodes() {
        return numOfTotalEpisodes;
    }

    public void setNumOfTotalEpisodes(int numOfTotalEpisodes) {
        this.numOfTotalEpisodes = numOfTotalEpisodes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getMPARating() {
        return mparating;
    }

    public void setMPARating(String MPARating) {
        this.mparating = MPARating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailerUrl() {
        return TrailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        TrailerUrl = trailerUrl;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public String getPromoType() {
        return promoType;
    }

    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    @Override
    public String toString() {
        return "TVShows{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", numOfSeasons=" + numOfSeasons +
                ", numOfTotalEpisodes=" + numOfTotalEpisodes +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", genre=" + genre +
                ", rentPrice=" + rentPrice +
                ", buyPrice=" + buyPrice +
                ", posterImage='" + posterImage + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", MPARating='" + mparating + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", TrailerUrl='" + TrailerUrl + '\'' +
                ", isFeatured=" + isFeatured +
                ", promoType='" + promoType + '\'' +
                ", addedOn='" + addedOn + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", totalRatings=" + totalRatings +
                '}';
    }
}
