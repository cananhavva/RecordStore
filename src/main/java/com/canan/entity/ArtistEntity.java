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
@Table(name = "artist")
public class ArtistEntity implements Serializable {
	
	private static final long serialVersionUID = 4400262885047745927L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long artistId;
	
	@Column(name = "artist_name")
	private String artistName;
	
	@Column(name = "artist_lastname")
	private String artistLastName;
	
	@Column(name = "desc")
	private String desc;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "cdArtist", fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private Set<CDEntity> cdAlbums = new HashSet<>();
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "dvdArtist", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<DVDEntity> dvdAlbums = new HashSet<>();
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "vinylArtist", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<VinylEntity> vinylAlbums = new HashSet<>();
	
	public void addCdAlbum(CDEntity album) {
		if (this.cdAlbums == null) {
			this.cdAlbums = new HashSet<>();
		}
		this.cdAlbums.add(album);
	}
	
	public void addDvdAlbum(DVDEntity album) {
		if (this.dvdAlbums == null) {
			this.dvdAlbums = new HashSet<>();
		}
		this.dvdAlbums.add(album);
	}
	
	public void addVinylAlbum(VinylEntity album) {
		if (this.vinylAlbums == null) {
			this.vinylAlbums = new HashSet<>();
		}
		this.vinylAlbums.add(album);
	}
}
