package in.codifi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "TBL_EMPLOYEE_DETAILS")
@Getter
@Setter
public class Entity1 extends CommonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column(name = "NAME")
	private String name;

	@Column(name = "DEPARTMENT")
	private String dept;

	@Column(name = "EMPLOYE_ID")
	private int empId;
}
