package com.as.takehomeassessement.service;

import com.as.takehomeassessement.domain.Restaurant;
import com.as.takehomeassessement.dto.RestaurantDTO;
import com.as.takehomeassessement.dto.SearchBestMatchedRestaurantsRequestDTO;
import com.as.takehomeassessement.mapper.IMapper;
import com.as.takehomeassessement.mapper.RestaurantMapper;
import com.as.takehomeassessement.repository.IRepository;
import com.as.takehomeassessement.repository.RestaurantRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class RestaurantService extends AbstractService<Restaurant, RestaurantDTO> {

    public RestaurantService(RestaurantRepository repository, RestaurantMapper mapper) {
        super(repository, mapper);
    }


    @Override
    public IRepository<Restaurant> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Restaurant, RestaurantDTO> getMapper() {
        return mapper;
    }

    public List<Restaurant> findTopNBestMatchedRestaurants(SearchBestMatchedRestaurantsRequestDTO requestDTO, int n) {

        List<Restaurant> matchedRestaurants = ((RestaurantRepository) getRepository()).findBestMatchedRestaurants(requestDTO.getRestaurantName(),
                requestDTO.getCustomerRating(),
                requestDTO.getDistance(),
                requestDTO.getPrice(),
                requestDTO.getCuisine());

        orderRestaurants(matchedRestaurants);
        int subListSize = Math.min(matchedRestaurants.size(), n);
        return matchedRestaurants.subList(0, subListSize);
    }

    private void orderRestaurants(List<Restaurant> restaurants) {
        restaurants.sort(((o1, o2) -> {
            int order = o1.getDistance().compareTo(o2.getDistance());
            if (order == 0) order = o2.getCustomerRating().compareTo(o1.getCustomerRating());
            if (order == 0) order = o1.getPrice().compareTo(o2.getPrice());
            return order;
        }));
    }

}
