package com.canan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.canan.util.EProduct;

@Entity
@Table(name = "Customer")
public class CustomerEntity implements Serializable {
	
	private static final long serialVersionUID = 173061641327967724L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Customer_id", updatable = false)
	private long id;
	
	@Column(name = "Customer_name")
	private String CustomerName;
	
	@Column(name = "Customer_surname")
	private String CustomerSurname;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Enumerated(value = EnumType.STRING)
	private EProduct ProductType;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private Date date;
	
	// parametresiz constructor
	public CustomerEntity() {
		super();
	}
	
	// parametreli constructor
	
	public CustomerEntity(String customerName, String customerSurname, String password, EProduct ProductType) {
		super();
		
		CustomerName = customerName;
		CustomerSurname = customerSurname;
		this.password = password;
		this.ProductType = ProductType;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", CustomerName=" + CustomerName + ", CustomerSurname=" + CustomerSurname
				+ ", ProductType=" + ProductType + ", date=" + date + "]";
	}
	
	// hashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(CustomerName, CustomerSurname, date, id, ProductType);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerEntity other = (CustomerEntity) obj;
		return Objects.equals(CustomerName, other.CustomerName)
				&& Objects.equals(CustomerSurname, other.CustomerSurname) && Objects.equals(date, other.date)
				&& id == other.id && ProductType == other.ProductType;
	}
	
	// getter and setter
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
	
	public EProduct getProductType() {
		return ProductType;
	}
	
	public void setProductType(EProduct ProductType) {
		this.ProductType = ProductType;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
		
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}