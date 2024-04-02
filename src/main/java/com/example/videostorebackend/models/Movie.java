package com.example.videostorebackend.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("movies")
public class Movie {
    @Id
    private String id;
    private String title;
    private String description;
    private String rating;
    private List<String> genre;
    private float rentPrice;
    private float buyPrice;
    private String posterImage;
    private String backgroundImage;
    private String MPARating;
    private int length;
    private String releaseDate;
    private String TrailerUrl;
    private boolean IsFeatured;
    private String addedOn;
    private String promoType;
    private boolean mostDemanded;
    private String releaseYear;
    private int totalRatings;

    public Movie() {
    }

    public Movie(String id, String title, String description, String rating, List<String> genre, float rentPrice, float buyPrice, String posterImage, String backgroundImage, String MPARating, int length, String releaseDate, String trailerUrl, boolean isFeatured, String addedOn, String promoType, boolean mostDemanded, String releaseYear, int totalRatings) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.genre = genre;
        this.rentPrice = rentPrice;
        this.buyPrice = buyPrice;
        this.posterImage = posterImage;
        this.backgroundImage = backgroundImage;
        this.MPARating = MPARating;
        this.length = length;
        this.releaseDate = releaseDate;
        this.TrailerUrl = trailerUrl;
        this.IsFeatured = isFeatured;
        this.addedOn = addedOn;
        this.promoType = promoType;
        this.mostDemanded = mostDemanded;
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
        return MPARating;
    }

    public void setMPARating(String MPARating) {
        this.MPARating = MPARating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
        return IsFeatured;
    }

    public void setFeatured(boolean featured) {
        IsFeatured = featured;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public String getPromoType() {
        return promoType;
    }

    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public boolean isMostDemanded() {
        return mostDemanded;
    }

    public void setMostDemanded(boolean mostDemanded) {
        this.mostDemanded = mostDemanded;
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
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", genre=" + genre +
                ", rentPrice=" + rentPrice +
                ", buyPrice=" + buyPrice +
                ", posterImage='" + posterImage + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", MPARating='" + MPARating + '\'' +
                ", length=" + length +
                ", releaseDate='" + releaseDate + '\'' +
                ", TrailerUrl='" + TrailerUrl + '\'' +
                ", isFeatured=" + IsFeatured +
                ", addedOn='" + addedOn + '\'' +
                ", promoType='" + promoType + '\'' +
                ", mostDemanded=" + mostDemanded +
                ", releaseYear='" + releaseYear + '\'' +
                ", totalRatings=" + totalRatings +
                '}';
    }
}
