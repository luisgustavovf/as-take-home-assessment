package com.as.takehomeassessement.controller.actions;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface SaveAction<D extends IDomain, T extends IDTO> extends Actionable<D, T> {

    @PostMapping(value = {""})
    @ResponseBody
    default ResponseEntity<T> create(@RequestBody T dto) {
        try {
            D entity = getService().getMapper().parseToDomain(dto);
            D saved = getService().save(entity);
            T savedDto = getService().getMapper().parseToDTO(saved);
            return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        } catch (CustomRuntimeException e) {
            return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = {""})
    @ResponseBody
    default ResponseEntity<T> update(@RequestBody T dto) {
        try {
            D entity = getService().getMapper().parseToDomain(dto);
            D saved = getService().update(entity);
            T savedDto = getService().getMapper().parseToDTO(saved);
            return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        } catch (CustomRuntimeException e) {
            return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = {"/batch"})
    @ResponseBody
    default ResponseEntity<T> updateAll(@RequestBody List<T> entities) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    @PostMapping(value = "/batch")
    @ResponseBody
    default ResponseEntity<Object> saveAll(@RequestBody List<T> entities) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

    default <S extends T> S save(S entity) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

}
