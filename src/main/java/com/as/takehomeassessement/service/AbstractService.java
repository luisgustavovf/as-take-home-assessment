package com.as.takehomeassessement.service;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import com.as.takehomeassessement.mapper.IMapper;
import com.as.takehomeassessement.repository.IRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractService<D extends IDomain, T extends IDTO> implements IService<D, T> {

    protected IRepository<D> repository;
    protected IMapper<D, T> mapper;

    protected AbstractService(IRepository<D> repository, IMapper<D, T> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public <S extends D> S save(S entity) throws CustomRuntimeException {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    public  <S extends D> Iterable<S> saveAll(Iterable<S> entities) throws CustomRuntimeException {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    public <S extends D> Iterable<S> updateAll(Iterable<S> entities) throws CustomRuntimeException {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    public D findOne(int id) {
        return getRepository().findById(id).orElse(null);
    }

    public List<D> findAll() {
        return getRepository().findAll();
    }

    public List<T> findAllDTO() {
        return findAll().parallelStream()
                .map(domain -> getMapper().parseToDTO(domain))
                .collect(Collectors.toList());
    }

    public T findByDTOID(int id) {
        return getMapper().parseToDTO(findOne(id));
    }

    public void deleteById(int entityId) {
        getRepository().deleteById(entityId);
    }

    public void delete(D entity) {
        getRepository().delete(entity);
    }

    public void deleteAll(Iterable<? extends D> entities) {
        getRepository().deleteAll(entities);
    }

    public boolean exists(int id) {
        return getRepository().existsById(id);
    }

    public long count() {
        return getRepository().count();
    }

    public D update(D entity) {
        return null;
    }

}
