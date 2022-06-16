package com.as.takehomeassessement.mapper;

import com.as.takehomeassessement.domain.Cuisine;
import com.as.takehomeassessement.dto.CuisineDTO;
import org.springframework.stereotype.Component;

@Component
public class CuisineMapper implements IMapper<Cuisine, CuisineDTO> {

    @Override
    public CuisineDTO parseToDTO(Cuisine domain) {
        if (domain == null) return CuisineDTO.builder().build();
        return CuisineDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    @Override
    public Cuisine parseToDomain(CuisineDTO domain) {
        if (domain == null) return Cuisine.builder().build();
        return Cuisine.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }
}
