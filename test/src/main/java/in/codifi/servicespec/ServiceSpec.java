package in.codifi.servicespec;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;
import in.codifi.request.CustomerReq;
import in.codifi.response.GenericResponse;

public interface ServiceSpec {
	/**
	 * method to get customer details
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> getSec();
	
	/**
	 * method to get customer details
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> getEmpDetails();

	/**
	 * method to get customer detailsByName
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> getCustomerDetailsByName(CustomerReq req);
	
	/**
	 * method to get addcustomer details
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> addCustomerDetails(CustomerReq req);
	
	
	/**
	 * method to delete customer details
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> deleteCustomerDetails(CustomerReq req);
	
	/**
	 * method to update customer details
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> updateCustomerDetails(CustomerReq req);
	
	/**
	 * method to add Multiple customer details
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> addMultipleCustomerDetails(List<CustomerReq> req);
	
	/**
	 * method to delete Multiple customer details
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> deleteMultipleCustomerDetails(List<CustomerReq> req);
	
	
	/**
	 * method to update active status customer details
	 * 
	 * @author Mugilan G
	 */
	RestResponse<GenericResponse> updateActiveStatusCustomerDetails();
	
	RestResponse<GenericResponse> getNonActiveStatusCustomerDetails();
	
	RestResponse<GenericResponse> getCustomerDetailsByDate(CustomerReq req);
	
	RestResponse<GenericResponse> getCustomerDetailsByDateRange(CustomerReq req);
	
	
}
