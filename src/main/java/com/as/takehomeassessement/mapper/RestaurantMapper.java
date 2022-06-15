package com.as.takehomeassessement.mapper;

import com.as.takehomeassessement.domain.Restaurant;
import com.as.takehomeassessement.dto.RestaurantDTO;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper implements IMapper<Restaurant, RestaurantDTO> {

    @Override
    public RestaurantDTO parseToDTO(Restaurant domain) {
        if (domain == null) return RestaurantDTO.builder().build();
        return RestaurantDTO.builder()
                .name(domain.getName())
                .customerRating(domain.getCustomerRating())
                .distance(domain.getDistance())
                .price(domain.getPrice())
                .cuisineId(domain.getCuisineId())
                .build();
    }

    @Override
    public Restaurant parseToDomain(RestaurantDTO domain) {
        if (domain == null) return Restaurant.builder().build();
        return Restaurant.builder()
                .name(domain.getName())
                .customerRating(domain.getCustomerRating())
                .distance(domain.getDistance())
                .price(domain.getPrice())
                .cuisineId(domain.getCuisineId())
                .build();
    }
}
