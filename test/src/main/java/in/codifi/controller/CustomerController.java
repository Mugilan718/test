package in.codifi.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestResponse;
import in.codifi.controllerspec.CustomerSpec;
import in.codifi.request.CustomerReq;
import in.codifi.response.GenericResponse;
import in.codifi.servicespec.ServiceSpec;


/**
 * method to get customer details
 * 
 * @author Mugilan G
 */
@Path("/getEmpDetails")
public class CustomerController implements CustomerSpec {
	@Inject
	ServiceSpec service;
	/**
	 * method to get customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> getEmpDetails() {
		return service.getEmpDetails();
	}

	/**
	 * method to get customerdetailsBYName
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> getCustomerDetailsByName(CustomerReq req) {
		return service.getCustomerDetailsByName(req);
	}
	
	/**
	 * method to add customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> addCustomerDetails(CustomerReq req) {
		return service.addCustomerDetails(req);
	}
	
	/**
	 * method to delete customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> deleteCustomerDetails(CustomerReq req) {
		return service.deleteCustomerDetails(req);
	}
	
	/**
	 * method to update customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> updateCustomerDetails(CustomerReq req) {
		return service.updateCustomerDetails(req);
	}
	
	/**
	 * method to add Multiple customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> addMultipleCustomerDetails(List<CustomerReq> req) {
		return service.addMultipleCustomerDetails(req);
	}
	
	/**
	 * method to delete Multiple customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> deleteMultipleCustomerDetails(List<CustomerReq> req) {
		return service.deleteMultipleCustomerDetails(req);
	}
	
	/**
	 * method to update active status customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> updateActiveStatusCustomerDetails() {
		return service.updateActiveStatusCustomerDetails();
	}
	
	/**
	 * method to update get nonactive status customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> getNonActiveStatusCustomerDetails() {
		return service.getNonActiveStatusCustomerDetails();
	}
	
	/**
	 * method to get customer details byDate
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> getCustomerDetailsByDate(CustomerReq req) {
		return service.getCustomerDetailsByDate(req);
	}
	
	/**
	 * method to get customer details by date range
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> getCustomerDetailsByDateRange(CustomerReq req) {
		return service.getCustomerDetailsByDateRange(req);
	}
	
	
}
