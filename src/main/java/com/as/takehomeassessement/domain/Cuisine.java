package com.as.takehomeassessement.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Cuisine implements IDomain {

    public static final int INDEX_ID = 0;
    public static final int INDEX_NAME = 1;

    private int id;
    private String name;

}
