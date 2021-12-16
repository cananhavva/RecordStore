package com.canan.model;

import java.util.Objects;

public class Genre {
	private long id;
	private String genre;
	
	public Genre() {
		super();
	}
	
	public Genre(long id, String genre) {
		super();
		this.id = id;
		this.genre = genre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(genre, id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(genre, other.genre) && id == other.id;
	}
	
	@Override
	public String toString() {
		return "Genre [id=" + id + ", genre=" + genre + "]";
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
	
}
