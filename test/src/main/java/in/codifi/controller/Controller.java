package in.codifi.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestResponse;

import in.codifi.controllerspec.ControllerSpec;
import in.codifi.response.GenericResponse;
import in.codifi.servicespec.ServiceSpec;

@Path("/getDetails")

public class Controller implements ControllerSpec {
	@Inject
	ServiceSpec service;

	@Override
	public RestResponse<GenericResponse> getSec() {
		return service.getSec();
	}

}
