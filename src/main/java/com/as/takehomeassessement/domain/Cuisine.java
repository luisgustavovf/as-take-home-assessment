package com.as.takehomeassessement.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cuisine implements IDomain {

    private int id;
    private String name;

}
