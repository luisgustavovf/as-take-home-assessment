package com.as.takehomeassessement.controller;

import com.as.takehomeassessement.domain.Restaurant;
import com.as.takehomeassessement.dto.RestaurantDTO;
import com.as.takehomeassessement.dto.SearchBestMatchedRestaurantsRequestDTO;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import com.as.takehomeassessement.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController extends AbstractController<Restaurant, RestaurantDTO> {

    private static final int NUMBER_OF_RESTAURANTS_TO_MATCH = 5;

    public RestaurantController(RestaurantService service) {
        super(service);
    }

    @PostMapping("/findBestMatchedRestaurants")
    public ResponseEntity<List<Restaurant>> findTopNBestMatchedRestaurants(@RequestBody SearchBestMatchedRestaurantsRequestDTO requestDTO) {

        //TODO: If parameter values are invalid, return an error message.

        try {
            List<Restaurant> topNBestMatchedRestaurants = ((RestaurantService) service).findTopNBestMatchedRestaurants(requestDTO,
                    NUMBER_OF_RESTAURANTS_TO_MATCH);

            return new ResponseEntity<>(topNBestMatchedRestaurants, HttpStatus.OK);
        } catch (CustomRuntimeException e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }

}
