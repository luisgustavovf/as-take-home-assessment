package com.as.takehomeassessement.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode(of = {"id"})
public class Cuisine implements IDomain {

    public static final int INDEX_ID = 0;
    public static final int INDEX_NAME = 1;

    private int id;
    private String name;

}
