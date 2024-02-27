package in.codifi.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.resteasy.reactive.RestResponse;


//import in.codifi.common.config.PropertiesConfig;
import in.codifi.entity.CustomerEntity;
import in.codifi.entity.Entity1;
import in.codifi.customer.repository.Repository;
import in.codifi.request.CustomerReq;
import in.codifi.response.GenericResponse;
import in.codifi.response.PrepareResponse;

import in.codifi.servicespec.ServiceSpec;
import in.codifi.utility.AppConstants;
import io.quarkus.logging.Log;
import in.codifi.customer.repository.CustomerRepository;

@ApplicationScoped
public class Service implements ServiceSpec {

	@Inject
	Repository repository;
	@Inject
	PrepareResponse prepareResponse;

	@Inject
	CustomerRepository customerRep;
	
	

	/**
	 * method to get customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> getSec() {
		try {
			List<Entity1> entity = repository.findAll();
			// ObjectMapper mapper = new ObjectMapper();
			// System.out.println(mapper.writeValueAsString(entity));
			return prepareResponse.prepareSuccessResponseObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);

	}

	/**
	 * method to get customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> getEmpDetails() {
		try {
			List<CustomerEntity> entity = customerRep.findAll();
			return prepareResponse.prepareSuccessResponseObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}

	/**
	 * method to get customer details by name
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> getCustomerDetailsByName(CustomerReq req) {
		try {
			CustomerEntity entity = customerRep.findByName(req.getName());
			if (entity != null) {
				return prepareResponse.prepareSuccessResponseObject(entity);
			} else {
				return prepareResponse.prepareFailedResponse("User not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}

	/**
	 * method to get addcustomer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> addCustomerDetails(CustomerReq req) {
		try {
			CustomerEntity entity = new CustomerEntity();

			entity.setName(req.getName());
			entity.setDept(req.getDept());
			entity.setCusId(req.getCustomerId());

			CustomerEntity newCustomer = customerRep.save(entity);

			return prepareResponse.prepareSuccessResponseObject(AppConstants.SUCCESS_STATUS);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}

	/**
	 * method to delete customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> deleteCustomerDetails(CustomerReq req) {
		try {
			CustomerEntity entity = new CustomerEntity();
			long id;
			id = req.getId();
			customerRep.deleteById(id);
			return prepareResponse.prepareSuccessResponseObject(AppConstants.SUCCESS_STATUS);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);

	}

	/**
	 * method to update customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> updateCustomerDetails(CustomerReq req) {
		try {
			Optional<CustomerEntity> entity = customerRep.findById(req.getId());
			if (entity.isPresent()) {
				CustomerEntity existingCustomer = entity.get();
				existingCustomer.setDept(req.getDept());
				existingCustomer.setCusId(req.getCustomerId());
				CustomerEntity updatedCustomer = customerRep.save(existingCustomer);
				return prepareResponse.prepareSuccessResponseObject(AppConstants.SUCCESS_STATUS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}

	/**
	 * method to add Multiple customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> addMultipleCustomerDetails(List<CustomerReq> customerList) {
		try {
			List<CustomerEntity> entityList = new ArrayList<>();
			for (CustomerReq req : customerList) {
				CustomerEntity entity = new CustomerEntity();
				entity.setName(req.getName());
				entity.setDept(req.getDept());
				entity.setCusId(req.getCustomerId());

				entityList.add(entity);
			}
			customerRep.saveAll(entityList);
			return prepareResponse.prepareSuccessResponseObject(AppConstants.SUCCESS_STATUS);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}

	/**
	 * method to delete Multiple customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> deleteMultipleCustomerDetails(List<CustomerReq> customerList) {
		try {
			for (CustomerReq req : customerList) {
				long id = req.getId();
				customerRep.deleteById(id);
			}
			return prepareResponse.prepareSuccessResponseObject(AppConstants.SUCCESS_STATUS);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}
    
	/**
	 * method to update active status customer details
	 * 
	 * @author Mugilan G
	 */
	@Override
	public RestResponse<GenericResponse> updateActiveStatusCustomerDetails() {
		try {
			int existingCustomers = customerRep.updateActiveStatus();
			if (existingCustomers > 0) {
				return prepareResponse.prepareSuccessResponseObject(AppConstants.SUCCESS_STATUS);
			} else {
				return prepareResponse.prepareSuccessResponseObject(AppConstants.NO_RECORDS_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}

	/**
	 * method to get non active status customer details
	 * 
	 * @author Mugilan G
	 */
	public RestResponse<GenericResponse> getNonActiveStatusCustomerDetails() {
		try {
			List<CustomerEntity> nonActiveStatusCustomers = customerRep.findNonActiveStatusCustomers();
			
			System.out.println(nonActiveStatusCustomers);
			return prepareResponse.prepareSuccessResponseObject(nonActiveStatusCustomers);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}
	
	@Override
	public RestResponse<GenericResponse> getCustomerDetailsByDate(CustomerReq req) {
		try {
			List<CustomerEntity> entity = customerRep.findByDate(req.getDate());
			if (!entity.isEmpty()) {
				return prepareResponse.prepareSuccessResponseObject(entity);
			} else {
				return prepareResponse.prepareFailedResponse("User not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}
	
	public RestResponse<GenericResponse> getCustomerDetailsByDateRange(CustomerReq req) {
	    try {
	        List<CustomerEntity> entityList = customerRep.findByDateRange(req.getFromDate(),req.getToDate());
	        if (!entityList.isEmpty()) {
	            return prepareResponse.prepareSuccessResponseObject(entityList);
	        } else {
	            return prepareResponse.prepareFailedResponse("No customers found ");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        Log.error(e.getMessage());
	    }
	    return prepareResponse.prepareFailedResponse(AppConstants.FAILED_STATUS);
	}
	

}
