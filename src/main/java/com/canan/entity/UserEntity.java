package com.canan.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 2980810188265138844L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "user_id")
	private long id;
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_lastname")
	private String userLastname;
	
	@Column(name = "email")
	private String eMail;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "phone")
	private String phoneNumber;
	
	@Column(name = "isadmin")
	private Boolean isAdmin = false;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ShopEntity> shops = new HashSet<>();
	
	public void addshop(ShopEntity shop) {
		if (this.shops == null) {
			this.shops = new HashSet<>();
		}
		this.shops.add(shop);
	}
}