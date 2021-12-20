package com.canan.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.canan.entity.GenreEntity;

public enum Genre {
	
	Rock(1, "Rock", "Rock SEC"), Jazz(2, "Jazz", "Jazz SEC"),
	
	Classic(3, "Classic", "Classic SEC"), Pop(4, "Pop", "Pop SEC"), Rap(5, "Rap", "Rap SEC"),
	DoNotGenre(999, "DoNotGenre", "DoNotGenre SEC");
	
	private static final HashMap<String, Genre> BY_NAME = new HashMap<String, Genre>();
	private static final HashMap<Long, Genre> BY_ID = new HashMap<Long, Genre>();
	private static final ArrayList<GenreEntity> ALL_GENRES = new ArrayList<>();
	
	static {
		for (Genre genre : values()) {
			BY_NAME.put(genre.name, genre);
			BY_ID.put(genre.id, genre);
			ALL_GENRES.add(new GenreEntity(genre));
		}
	}
	
	private long id;
	private String name;
	private String desc;
	
	private Genre(long id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	
	public static Genre byName(String name) {
		Genre genre = BY_NAME.get(name);
		if (genre != null)
			return BY_NAME.get(name);
		else
			return DoNotGenre;
	}
	
	public static ArrayList<GenreEntity> getAllGenres() {
		return ALL_GENRES;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getId() {
		return this.id;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public static Genre getById(long id) {
		return BY_ID.get(id);
	}
	
	public static Genre getByName(String name) {
		return BY_NAME.get(name);
	}
	
	public static ArrayList<Genre> getAllGenreTypes() {
		return new ArrayList<>(BY_NAME.values());
	}
}
