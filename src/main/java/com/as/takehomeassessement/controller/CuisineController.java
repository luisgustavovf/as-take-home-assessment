package com.as.takehomeassessement.controller;

import com.as.takehomeassessement.domain.Cuisine;
import com.as.takehomeassessement.dto.CuisineDTO;
import com.as.takehomeassessement.service.CuisineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuisines")
public class CuisineController extends AbstractController<Cuisine, CuisineDTO> {

    public CuisineController(CuisineService service) {
        super(service);
    }

}
