package com.bean;

public class CustomerStatus {
	private long ssn_id;
	private long customer_id;
	private String status;
	private String message;
	private String last_updated;
	public long getSsn_id() {
		return ssn_id;
	}
	public void setSsn_id(long ssn_id) {
		this.ssn_id = ssn_id;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
	

}
