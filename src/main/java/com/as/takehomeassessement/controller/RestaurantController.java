package com.as.takehomeassessement.controller;

import com.as.takehomeassessement.domain.Restaurant;
import com.as.takehomeassessement.dto.RestaurantDTO;
import com.as.takehomeassessement.service.RestaurantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController extends AbstractController<Restaurant, RestaurantDTO> {

    public RestaurantController(RestaurantService service) {
        super(service);
    }

}
