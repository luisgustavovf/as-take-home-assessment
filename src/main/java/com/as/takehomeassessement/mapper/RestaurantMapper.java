package com.as.takehomeassessement.mapper;

import com.as.takehomeassessement.domain.Cuisine;
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
                .cuisineName(domain.getCuisine() != null ? domain.getCuisine().getName() : "")
                .build();
    }

    @Override
    public Restaurant parseToDomain(RestaurantDTO dto) {
        if (dto == null) return Restaurant.builder().build();
        return Restaurant.builder()
                .name(dto.getName())
                .customerRating(dto.getCustomerRating())
                .distance(dto.getDistance())
                .price(dto.getPrice())
                .cuisineId(dto.getCuisineId())
                .cuisine(Cuisine.builder()
                        .id(dto.getCuisineId())
                        .name(dto.getCuisineName())
                        .build()
                )
                .build();
    }
}
