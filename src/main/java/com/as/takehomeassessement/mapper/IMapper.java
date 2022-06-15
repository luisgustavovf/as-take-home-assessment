package com.as.takehomeassessement.mapper;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;

public interface IMapper<D extends IDomain, T extends IDTO> {
    T parseToDTO(D domain);
    D parseToDomain(T domain);
}
