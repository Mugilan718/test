package in.codifi.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerReq {
	private String name;
	private String dept;
	private String customerId;
	private long id;
	public int activeStatus;
	public Date date;
	private Date fromDate;
    private Date toDate;
	
}
