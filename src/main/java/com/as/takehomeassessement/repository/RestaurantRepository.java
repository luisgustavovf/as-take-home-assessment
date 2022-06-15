package com.as.takehomeassessement.repository;

import com.as.takehomeassessement.domain.Restaurant;
import com.as.takehomeassessement.parser.RestaurantCSVConverter;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantRepository extends CSVAbstractRepository<Restaurant> {

    public RestaurantRepository(RestaurantCSVConverter csvConverter) {
        super(csvConverter);
    }

    @Override
    public String getFilePath() {
        return "static/restaurants.csv";
    }
}
