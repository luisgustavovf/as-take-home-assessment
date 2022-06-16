package com.as.takehomeassessement.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant implements IDomain {

    public static final int INDEX_NAME = 0;
    public static final int INDEX_CUSTOMER_RATING = 1;
    public static final int INDEX_DISTANCE = 2;
    public static final int INDEX_PRICE = 3;
    public static final int INDEX_CUISINE_ID = 4;

    private String name;
    private Integer customerRating;
    private Integer distance;
    private Integer price;
    private Integer cuisineId;
    @Setter private Cuisine cuisine;

    @Override
    public int getId() {
        return 0;
    }
}
