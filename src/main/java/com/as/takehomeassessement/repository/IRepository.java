package com.as.takehomeassessement.repository;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.exception.CustomRuntimeException;

import java.util.List;
import java.util.Optional;

public interface IRepository<D extends IDomain> {

    List<D> getCache();
    boolean isDirtyCache();

    void setDirtyCache(boolean b);

    Optional<D> findById(int id);

    List<D> findAll() throws CustomRuntimeException;

    default void deleteById(int entityId) {
        setDirtyCache(true);
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default void delete(D entity) {
        setDirtyCache(true);
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default void deleteAll(Iterable<? extends D> entities) {
        setDirtyCache(true);
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default boolean existsById(int id) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default long count() {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }
}
