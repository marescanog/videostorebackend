package com.example.videostorebackend.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("movies")
public class Movie {
    @Id
    private String id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Rating is required")
    private Float rating;
    @NotNull(message = "List of genres is required")
    private List<String> genre;
    @NotNull(message = "Rent price is required")
    private Float rentPrice;
    @NotNull(message = "Buy Price is required")
    private Float buyPrice;
    @NotBlank(message = "Poster Image is required")
    private String posterImage;
    @NotBlank(message = "Background Image is required")
    private String backgroundImage;
    @NotBlank(message = "Rating is required")
    private String MPARating;
    @NotNull(message = "Movie length is required")
    private Integer length;
    @NotBlank(message = "Release Date is required")
    private String releaseDate;
    @NotBlank(message = "Trailer URL is required")
    private String TrailerUrl;
    private Boolean IsFeatured;
    @NotBlank(message = "Date added on is required")
    private String addedOn;
    private String promoType;
    private Boolean mostDemanded;
    @NotNull(message = "Release Year is required")
    private Integer releaseYear;
    @NotNull(message = "Total Ratings is required")
    private Integer totalRatings;

    public Movie() {
    }

    public Movie(String id, String title, String description, Float rating, List<String> genre, Float rentPrice, Float buyPrice, String posterImage, String backgroundImage, String MPARating, Integer length, String releaseDate, String trailerUrl, Boolean isFeatured, String addedOn, String promoType, Boolean mostDemanded, Integer releaseYear, Integer totalRatings) {
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

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public Float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
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

    public Boolean isFeatured() {
        return IsFeatured;
    }

    public void setFeatured(Boolean featured) {
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

    public Boolean isMostDemanded() {
        return mostDemanded;
    }

    public void setMostDemanded(Boolean mostDemanded) {
        this.mostDemanded = mostDemanded;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
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
