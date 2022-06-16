package com.as.takehomeassessement.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestaurantDTO implements IDTO {

    private String name;
    private int customerRating;
    private int distance;
    private int price;
    private int cuisineId;
    private String cuisineName;

    @Override
    public int getId() {
        return 0;
    }
}
