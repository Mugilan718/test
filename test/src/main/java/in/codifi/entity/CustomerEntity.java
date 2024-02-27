
package in.codifi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "TBL_CUSTOMER_DETAILS")
@Getter
@Setter
public class CustomerEntity extends CommonEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Column(name = "NAME")
	private String name;

	@Column(name = "DEPT")
	private String dept;
	
	@Column(name = "CUSTUMER_ID")
	private String CusId;
	
}


