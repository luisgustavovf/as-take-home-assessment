package com.as.takehomeassessement.dto;

import lombok.Getter;

@Getter
public class SearchBestMatchedRestaurantsRequestDTO {

    private String restaurantName;
    private Integer customerRating;
    private Integer distance;
    private Integer price;
    private String cuisine;

}
