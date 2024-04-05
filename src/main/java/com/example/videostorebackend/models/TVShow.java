package com.example.videostorebackend.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("tvshows")
public class TVShow {
    @Id
    private String id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotNull(message = "Number of seasons is required")
    private Integer numOfSeasons;
    @NotNull(message = "Number of total episodes is required")
    private Integer numOfTotalEpisodes;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Rating is required")
    private String rating;
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
    @NotBlank(message = "Release Date is required")
    private String releaseDate;
    @NotBlank(message = "Promo Type is required")
    private String promoType;
    @NotBlank(message = "Date added on is required")
    private String addedOn;
    @NotBlank(message = "Release year is required")
    private String releaseYear;
    @NotNull(message = "Total Ratings is required")
    private Integer totalRatings;
    private Boolean IsFeatured;
    @NotBlank(message = "MPA rating is required")
    private String mparating;
    @NotBlank(message = "Trailer URL is required")
    private String TrailerUrl;
    private Boolean mostDemanded;


    public TVShow() {
    }

    public TVShow(String id, String title, Integer numOfSeasons, Integer numOfTotalEpisodes, String description, String rating, List<String> genre, Float rentPrice, Float buyPrice, String posterImage, String backgroundImage, String releaseDate, String promoType, String addedOn, String releaseYear, Integer totalRatings, Boolean isFeatured, String mparating, String trailerUrl, Boolean mostDemanded) {
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
        this.releaseDate = releaseDate;
        this.promoType = promoType;
        this.addedOn = addedOn;
        this.releaseYear = releaseYear;
        this.totalRatings = totalRatings;
        this.IsFeatured = isFeatured;
        this.mparating = mparating;
        this.TrailerUrl = trailerUrl;
        this.mostDemanded = mostDemanded;
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

    public Integer getNumOfSeasons() {
        return numOfSeasons;
    }

    public void setNumOfSeasons(Integer numOfSeasons) {
        this.numOfSeasons = numOfSeasons;
    }

    public Integer getNumOfTotalEpisodes() {
        return numOfTotalEpisodes;
    }

    public void setNumOfTotalEpisodes(Integer numOfTotalEpisodes) {
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }

    public Boolean isFeatured() {
        return IsFeatured;
    }

    public void setFeatured(Boolean featured) {
        IsFeatured = featured;
    }

    public String getMparating() {
        return mparating;
    }

    public void setMparating(String mparating) {
        this.mparating = mparating;
    }

    public String getTrailerUrl() {
        return TrailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        TrailerUrl = trailerUrl;
    }

    public Boolean isMostDemanded() {
        return mostDemanded;
    }

    public void setMostDemanded(Boolean mostDemanded) {
        this.mostDemanded = mostDemanded;
    }

    @Override
    public String toString() {
        return "TVShow{" +
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
                ", releaseDate='" + releaseDate + '\'' +
                ", promoType='" + promoType + '\'' +
                ", addedOn='" + addedOn + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", totalRatings=" + totalRatings +
                ", isFeatured=" + IsFeatured +
                ", mparating='" + mparating + '\'' +
                ", TrailerUrl='" + TrailerUrl + '\'' +
                ", mostDemanded=" + mostDemanded +
                '}';
    }
}
