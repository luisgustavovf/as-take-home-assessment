package com.as.takehomeassessement.repository;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.exception.CustomRuntimeException;

import java.util.List;
import java.util.Optional;

public interface IRepository<D extends IDomain> {

    Optional<D> findById(int id);

    List<D> findAll() throws CustomRuntimeException;

    default void deleteById(int entityId) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default void delete(D entity) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default void deleteAll(Iterable<? extends D> entities) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default boolean existsById(int id) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default long count() {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }
}
