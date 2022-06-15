package com.as.takehomeassessement.controller.actions;


import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;
import com.as.takehomeassessement.service.IService;

public interface Actionable<D extends IDomain, T extends IDTO> {
	String STR_SUCCESS = "Success";
	String STR_NOT_FOUND = "Entity not found.";

	IService<D, T> getService();
}
