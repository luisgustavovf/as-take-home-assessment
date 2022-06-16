package com.as.takehomeassessement.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchBestMatchedRestaurantsRequestDTO {

    private String restaurantName;
    private Integer customerRating;
    private Integer distance;
    private Integer price;
    private String cuisine;

}
