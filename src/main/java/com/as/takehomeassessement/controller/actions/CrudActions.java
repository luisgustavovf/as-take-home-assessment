package com.as.takehomeassessement.controller.actions;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;

public interface CrudActions<D extends IDomain, T extends IDTO> extends ListAction<D, T>, SaveAction<D, T>, DeleteAction<D, T> {
}
