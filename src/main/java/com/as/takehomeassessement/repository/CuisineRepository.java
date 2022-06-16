package com.as.takehomeassessement.repository;

import com.as.takehomeassessement.domain.Cuisine;
import com.as.takehomeassessement.parser.CuisineCSVConverter;
import org.springframework.stereotype.Repository;

@Repository
public class CuisineRepository extends CSVAbstractRepository<Cuisine> {

    public CuisineRepository(CuisineCSVConverter csvConverter) {
        super(csvConverter);
    }

    @Override
    public String getFilePath() {
        return "static/cuisines.csv";
    }
}
