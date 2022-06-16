package com.as.takehomeassessement.service;

import com.as.takehomeassessement.domain.Cuisine;
import com.as.takehomeassessement.dto.CuisineDTO;
import com.as.takehomeassessement.mapper.CuisineMapper;
import com.as.takehomeassessement.mapper.IMapper;
import com.as.takehomeassessement.repository.CuisineRepository;
import com.as.takehomeassessement.repository.IRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class CuisineService extends AbstractService<Cuisine, CuisineDTO> {

    public CuisineService(CuisineRepository repository, CuisineMapper mapper) {
        super(repository, mapper);
    }


    @Override
    public IRepository<Cuisine> getRepository() {
        return repository;
    }

    @Override
    public IMapper<Cuisine, CuisineDTO> getMapper() {
        return mapper;
    }

}
