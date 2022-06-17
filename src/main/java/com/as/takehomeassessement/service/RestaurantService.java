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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<RestaurantDTO> findTopNBestMatchedRestaurants(SearchBestMatchedRestaurantsRequestDTO requestDTO, int n) {

        List<Restaurant> matchedRestaurants = ((RestaurantRepository) getRepository()).findBestMatchedRestaurants(requestDTO.getRestaurantName(),
                requestDTO.getCustomerRating(),
                requestDTO.getDistance(),
                requestDTO.getPrice(),
                requestDTO.getCuisine());

        orderRestaurants(matchedRestaurants);
        int subListSize = Math.min(matchedRestaurants.size(), n);

        return matchedRestaurants
                .subList(0, subListSize)
                .stream()
                .map(getMapper()::parseToDTO)
                .collect(Collectors.toList());
    }

    public void orderRestaurants(List<Restaurant> restaurants) {
        restaurants.sort(
                Comparator.comparing(Restaurant::getDistance)
                .thenComparing(Restaurant::getCustomerRating, Comparator.nullsFirst(Comparator.reverseOrder()))
                .thenComparing(Restaurant::getPrice)
        );
    }

}
