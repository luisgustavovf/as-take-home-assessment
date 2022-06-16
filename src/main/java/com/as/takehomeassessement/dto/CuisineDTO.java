package com.as.takehomeassessement.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CuisineDTO implements IDTO {

    private int id;
    private String name;

}
