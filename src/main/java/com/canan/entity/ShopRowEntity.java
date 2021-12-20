package com.canan.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "shop_row")
public class ShopRowEntity implements Serializable {
	
	private static final long serialVersionUID = -2645693087847879959L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shop_row_id")
	private long ShopRowId;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "price")
	private double price;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Shop_id", referencedColumnName = "shop_row_id")
	private ShopEntity Shop;
}
