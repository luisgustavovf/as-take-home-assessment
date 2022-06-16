package com.as.takehomeassessement.parser;

import com.as.takehomeassessement.domain.Cuisine;
import org.springframework.stereotype.Component;

@Component
public class CuisineCSVConverter implements ICSVConverter<Cuisine> {

    @Override
    public Cuisine convertToDomain(String[] csvRow) {

        if (csvRow == null || csvRow.length < 1) return Cuisine.builder().build();

        return Cuisine.builder()
                .id(Integer.parseInt(csvRow[Cuisine.INDEX_ID]))
                .name(csvRow[Cuisine.INDEX_NAME])
                .build();

    }
}
