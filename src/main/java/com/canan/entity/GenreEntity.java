package com.canan.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.canan.model.Genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "genre")
public class GenreEntity implements Serializable {
	
	private static final long serialVersionUID = 6794144965893771321L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long genreId;
	
	@Column(name = "genre_name")
	private String genreName;
	
	@Column(name = "description")
	private String genreDescription;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
	private Set<CDEntity> cdAlbums = new HashSet<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
	private Set<DVDEntity> dvdAlbums = new HashSet<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
	private Set<VinylEntity> vinylAlbums = new HashSet<>();
	
	public GenreEntity(Genre genreType) {
		this.genreId = genreType.getId();
		this.genreName = genreType.getName();
		this.genreDescription = genreType.getDesc();
	}
	
	public void addCdAlbums(CDEntity album) {
		if (this.cdAlbums == null) {
			this.cdAlbums = new HashSet<>();
		}
		this.cdAlbums.add(album);
	}
	
	public void addDvdAlbums(DVDEntity album) {
		if (this.dvdAlbums == null) {
			this.dvdAlbums = new HashSet<>();
		}
		this.dvdAlbums.add(album);
	}
	
	public void addVinylAlbums(VinylEntity album) {
		if (this.vinylAlbums == null) {
			this.vinylAlbums = new HashSet<>();
		}
		this.vinylAlbums.add(album);
	}
}
