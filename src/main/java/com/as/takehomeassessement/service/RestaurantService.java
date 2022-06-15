package com.as.takehomeassessement.service;

import com.as.takehomeassessement.domain.Restaurant;
import com.as.takehomeassessement.dto.RestaurantDTO;
import com.as.takehomeassessement.mapper.IMapper;
import com.as.takehomeassessement.mapper.RestaurantMapper;
import com.as.takehomeassessement.repository.IRepository;
import com.as.takehomeassessement.repository.RestaurantRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

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

}
