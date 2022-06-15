package com.as.takehomeassessement.controller.actions;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface DeleteAction<D extends IDomain, T extends IDTO> extends Actionable<D, T> {

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    default ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        try {
            getService().deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (CustomRuntimeException e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "")
    @ResponseBody
    default ResponseEntity<Boolean> delete(@RequestBody T dto) {
        try {
            D domain = getService().getMapper().parseToDomain(dto);
            getService().delete(domain);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (CustomRuntimeException e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = {"/batch"})
    @ResponseBody
    default ResponseEntity<Boolean> deleteAll(@RequestBody List<T> entities) {
        throw new CustomRuntimeException(CustomRuntimeException.DEFAULT_MESSAGE);
    }

}
