package com.canan.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "records")
public class RecordEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private String name;
	private int year;
	
	@ManyToMany
	@JoinTable(name = "records_genres", joinColumns = @JoinColumn(name = "record_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<GenreEntity> genres;
	
	public void addGenre(GenreEntity genre) {
		if (this.genres == null) {
			this.genres = new ArrayList<GenreEntity>();
		}
		this.genres.add(genre);
	}
	
	public RecordEntity() {
		super();
	}
	
	public RecordEntity(long id, String name, int year, List<GenreEntity> genres, List<RecordUsersTag> recordTags) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.genres = genres;
		
		this.recordTags = recordTags;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(genres, id, name, recordTags, year);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecordEntity other = (RecordEntity) obj;
		return Objects.equals(genres, other.genres) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(recordTags, other.recordTags) && year == other.year;
	}
	
	@Override
	public String toString() {
		return "RecordEntity [id=" + id + ", name=" + name + ", year=" + year + ", genres=" + genres + ", recordTags="
				+ recordTags + "]";
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public List<GenreEntity> getGenres() {
		return genres;
	}
	
	public void setGenres(List<GenreEntity> genres) {
		this.genres = genres;
	}
	
	public List<RecordUsersTag> getRecordTags() {
		return recordTags;
	}
	
	public void setRecordTags(List<RecordUsersTag> recordTags) {
		this.recordTags = recordTags;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@OneToMany(mappedBy = "record", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<RecordUsersTag> recordTags = new ArrayList<>();
}