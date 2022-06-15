package com.as.takehomeassessement.controller.actions;

import com.as.takehomeassessement.domain.IDomain;
import com.as.takehomeassessement.dto.IDTO;
import com.as.takehomeassessement.exception.CustomRuntimeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ListAction<D extends IDomain, T extends IDTO> extends Actionable<D, T> {

	@GetMapping(value = { "" })
	@ResponseBody
	default List<T> index() throws CustomRuntimeException {
		try {
			return getService().findAllDTO();
		} catch (CustomRuntimeException e) {
			throw new CustomRuntimeException(e);
		}
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	default Object indexById(@PathVariable("id") int id, HttpServletResponse response) {
		try {
			return getService().findByDTOID(id);
		} catch (CustomRuntimeException e) {
			throw new CustomRuntimeException(e);
		}
	}

}
