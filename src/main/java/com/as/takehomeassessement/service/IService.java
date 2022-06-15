package com.as.takehomeassessement.service;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import com.as.takehomeassessement.mapper.IMapper;
import com.as.takehomeassessement.repository.IRepository;

import java.util.List;

public interface IService<D extends IDomain, T extends IDTO>{

    IRepository<D> getRepository();

    IMapper<D, T> getMapper();


    <S extends D> S save(S entity) throws CustomRuntimeException;

    <S extends D> Iterable<S> saveAll(Iterable<S> entities) throws CustomRuntimeException;

    <S extends D> Iterable<S> updateAll(Iterable<S> entities) throws CustomRuntimeException;

    D findOne(int id);

    List<D> findAll();

    List<T> findAllDTO();

    T findByDTOID(int id);

    void deleteById(int entityId);

    void delete(D entity);

    void deleteAll(Iterable<? extends D> entities);

    boolean exists(int id);

    long count();

    D update(D entity);
}
