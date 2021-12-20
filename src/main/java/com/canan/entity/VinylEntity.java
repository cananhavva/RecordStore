package com.canan.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.canan.model.PlaySpeed;

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
@Table(name = "vinyl_albums")
public class VinylEntity implements Serializable {
	private static final long serialVersionUID = 4131047737393148325L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long Id;
	
	@Column(name = "name")
	private String albumName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "status")
	private Boolean status = true;
	
	@Enumerated(value = EnumType.STRING)
	private PlaySpeed playSpeed;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "artist_id", referencedColumnName = "id")
	protected ArtistEntity vinylArtist;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(targetEntity = GenreEntity.class, fetch = FetchType.EAGER)
	protected Set<GenreEntity> genres = new HashSet<>();
	
	public void addGenre(GenreEntity genre) {
		if (this.genres == null) {
			this.genres = new HashSet<>();
		}
		this.genres.add(genre);
	}
	
}
