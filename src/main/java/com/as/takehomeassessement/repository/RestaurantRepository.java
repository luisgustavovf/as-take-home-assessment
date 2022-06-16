package com.as.takehomeassessement.repository;

import com.as.takehomeassessement.domain.Cuisine;
import com.as.takehomeassessement.domain.Restaurant;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import com.as.takehomeassessement.parser.RestaurantCSVConverter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class RestaurantRepository extends CSVAbstractRepository<Restaurant> {

    private final CuisineRepository cuisineRepository;

    public RestaurantRepository(RestaurantCSVConverter csvConverter, CuisineRepository cuisineRepository) {
        super(csvConverter);
        this.cuisineRepository = cuisineRepository;
    }

    @Override
    public String getFilePath() {
        return "static/restaurants.csv";
    }

    @Override
    public Optional<Restaurant> findById(int id) {
        return findAll().parallelStream()
                .filter(o -> Objects.equals(o.getId(), id))
                .findFirst();
    }

    @Override
    public List<Restaurant> findAll() throws CustomRuntimeException {
        List<Restaurant> restaurants = super.findAll();
        Map<Integer, Cuisine> cuisineMap = cuisineRepository.findAll().parallelStream().collect(Collectors.toMap(Cuisine::getId, Function.identity()));
        restaurants.forEach(o -> o.setCuisine(cuisineMap.get(o.getCuisineId())));
        return restaurants;
    }

    public List<Restaurant> findBestMatchedRestaurants(String searchRestaurantName,
                                                      Integer searchCustomerRating,
                                                      Integer searchDistance,
                                                      Integer searchPrice,
                                                      String searchCuisine) {

        List<Restaurant> restaurants = this.findAll();

        restaurants.removeIf(restaurant ->
                !matchRestaurantName(restaurant, searchRestaurantName) ||
                        !matchCustomerRating(restaurant, searchCustomerRating) ||
                        !matchDistance(restaurant, searchDistance) ||
                        !matchPrice(restaurant, searchPrice) ||
                        !matchCuisine(restaurant, searchCuisine)
        );

        return restaurants;
    }

    private boolean matchRestaurantName(Restaurant restaurant, String searchRestaurantName) {
        return searchRestaurantName == null || searchRestaurantName.trim().isEmpty() || restaurant.getName().contains(searchRestaurantName);
    }

    private boolean matchCustomerRating(Restaurant restaurant, Integer searchCustomerRating) {
        return searchCustomerRating == null || restaurant.getCustomerRating() >= searchCustomerRating;
    }

    private boolean matchDistance(Restaurant restaurant, Integer searchDistance) {
        return searchDistance == null || restaurant.getDistance() <= searchDistance;
    }

    private boolean matchPrice(Restaurant restaurant, Integer searchPrice) {
        return searchPrice == null || restaurant.getPrice() <= searchPrice;
    }

    private boolean matchCuisine(Restaurant restaurant, String searchCuisine) {
        return searchCuisine == null
                || searchCuisine.trim().isEmpty()
                || (restaurant.getCuisine() != null && restaurant.getCuisine().getName().contains(searchCuisine));
    }

}
