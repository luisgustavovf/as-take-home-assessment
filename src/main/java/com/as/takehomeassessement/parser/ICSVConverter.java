package com.as.takehomeassessement.parser;

import com.as.takehomeassessement.domain.IDomain;

public interface ICSVConverter<D extends IDomain> {

    D convertToDomain(String[] csvRow);

}
