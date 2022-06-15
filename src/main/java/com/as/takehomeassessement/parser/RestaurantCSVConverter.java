package com.as.takehomeassessement.parser;

import com.as.takehomeassessement.domain.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantCSVConverter implements ICSVConverter<Restaurant> {

    @Override
    public Restaurant convertToDomain(String[] csvRow) {

        if (csvRow == null || csvRow.length < 1) return Restaurant.builder().build();

        return Restaurant.builder()
                .name(csvRow[Restaurant.INDEX_NAME])
                .customerRating(Integer.parseInt(csvRow[Restaurant.INDEX_CUSTOMER_RATING]))
                .distance(Integer.parseInt(csvRow[Restaurant.INDEX_DISTANCE]))
                .price(Integer.parseInt(csvRow[Restaurant.INDEX_PRICE]))
                .cuisineId(Integer.parseInt(csvRow[Restaurant.INDEX_CUISINE_ID]))
                .build();

    }
}
