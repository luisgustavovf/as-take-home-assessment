package com.as.takehomeassessement.controller;

import com.as.takehomeassessement.controller.actions.CrudActions;
import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;
import com.as.takehomeassessement.service.IService;
import lombok.Getter;

@Getter
public abstract class AbstractController<D extends IDomain, T extends IDTO> implements CrudActions<D, T> {

    protected IService<D, T> service;

    protected AbstractController(IService<D, T> service) {
        this.service = service;
    }
}
