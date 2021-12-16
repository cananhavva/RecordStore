package com.canan.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class GenreEntity {
	@Id
	private long id;
	
	@Column(name = "genre")
	private String genre;
	
	@ManyToMany
	private List<RecordEntity> Records;
	
	public void addRecord(RecordEntity Record) {
		if (this.Records == null) {
			this.Records = new ArrayList<RecordEntity>();
		}
		this.Records.add(Record);
	}
	
	public GenreEntity() {
		super();
	}
	
	public GenreEntity(long id, String genre, List<RecordEntity> records) {
		super();
		this.id = id;
		this.genre = genre;
		Records = records;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Records, genre, id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenreEntity other = (GenreEntity) obj;
		return Objects.equals(Records, other.Records) && Objects.equals(genre, other.genre) && id == other.id;
	}
	
	@Override
	public String toString() {
		return "GenreEntity [id=" + id + ", genre=" + genre + ", Records=" + Records + "]";
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public List<RecordEntity> getRecords() {
		return Records;
	}
	
	public void setRecords(List<RecordEntity> records) {
		Records = records;
	}
	
}