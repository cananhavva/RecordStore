package com.canan.model;

import java.util.Date;

import com.canan.util.EProduct;

public class CustomerDto {
	
	private long id;
	private String CustomerName;
	private String CustomerSurname;
	private String password;
	private EProduct ProductType;
	private Date date;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCustomerName() {
		return CustomerName;
	}
	
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	
	public String getCustomerSurname() {
		return CustomerSurname;
	}
	
	public void setCustomerSurname(String customerSurname) {
		CustomerSurname = customerSurname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public EProduct getProductType() {
		return ProductType;
	}
	
	public void setProductType(EProduct productType) {
		ProductType = productType;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}