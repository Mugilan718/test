package in.codifi.controllerspec;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestResponse;

import in.codifi.request.CustomerReq;
import in.codifi.response.GenericResponse;

public interface CustomerSpec {
	/**
	 * method to get customer details
	 * 
	 * @author Mugilan G
	 */
	@Path("/getEmployeDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> getEmpDetails();
	
	/**
	 * method to get customer detailsByName
	 * 
	 * @author Mugilan G
	 */
	@Path("/getCustomerByName")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> getCustomerDetailsByName(CustomerReq req);
	
	/**	
	 * method to add customer details
	 * 
	 * @author Mugilan G
	 */
	@Path("/addCustomerDetails")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> addCustomerDetails(CustomerReq req);
	
	
	/**
	 * method to delete customer details
	 * 
	 * @author Mugilan G
	 */
	@Path("/deleteCustomerDetails")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> deleteCustomerDetails(CustomerReq req);
	
	/**
	 * method to update customer details
	 * 
	 * @author Mugilan G
	 */
	@Path("/updateCustomerDetails")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> updateCustomerDetails(CustomerReq req);
	
	/**
	 * method to add Multiple customer details
	 * 
	 * @author Mugilan G
	 */
	@Path("/addMultipleCustomerDetails")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> addMultipleCustomerDetails(List<CustomerReq> req);
	
	/**
	 * method to delete Multiple customer details
	 * 
	 * @author Mugilan G
	 */
	@Path("/deleteMultipleCustomerDetails")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> deleteMultipleCustomerDetails(List<CustomerReq> req);
	
	/**
	 * method to update active status customer details
	 * 
	 * @author Mugilan G
	 */
	@Path("/updateActiveStatusCustomerDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> updateActiveStatusCustomerDetails();
	
	/**
	 * method to get non active status customer details
	 * 
	 * @author Mugilan G
	 */
	@Path("/getNonActiveStatusCustomerDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> getNonActiveStatusCustomerDetails();
	
	@Path("/getCustomerDetailsByDate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> getCustomerDetailsByDate(CustomerReq req);
	
	@Path("/getCustomerDetailsByDateRange")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<GenericResponse> getCustomerDetailsByDateRange(CustomerReq req);
	
	 
}
