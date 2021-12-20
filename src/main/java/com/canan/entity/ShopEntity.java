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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "shop")
public class ShopEntity implements Serializable {
	
	private static final long serialVersionUID = -5583805098749736314L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shop_id")
	private long shopId;
	
	@Column(name = "be_completed")
	private Boolean beCompleted;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "Shop", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ShopRowEntity> rows = new HashSet<>();
	
	public void addShopRow(ShopRowEntity row) {
		if (this.rows == null) {
			this.rows = new HashSet<>();
		}
		this.rows.add(row);
	}
}
