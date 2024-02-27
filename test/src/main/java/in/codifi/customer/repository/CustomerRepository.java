package in.codifi.customer.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.codifi.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	CustomerEntity findByName(String NAME);

	
	@Modifying
	@Query(value = "UPDATE TBL_CUSTOMER_DETAILS set ACTIVE_STATUS = 0 where created_on < Date(current_timestamp())")
	int updateActiveStatus();
	
	@Query("select a from TBL_CUSTOMER_DETAILS a where a.createdOn < Date(current_timestamp()) ")
	List<CustomerEntity> findNonActiveStatusCustomers();
	
	
	@Query("select a from TBL_CUSTOMER_DETAILS a where Date(a.createdOn) = :createdOn")
	List<CustomerEntity> findByDate(@Param("createdOn") Date createdOn);
	
	
	
	@Query("select a from TBL_CUSTOMER_DETAILS a where a.createdOn  between :From and :To")
	List<CustomerEntity> findByDateRange(@Param("From") Date From,@Param("To")Date To);
    
}
