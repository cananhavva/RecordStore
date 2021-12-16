package com.canan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class TagEntity {
	@Id
	private long id;
	@Column(name = "tag")
	private String tag;
	
	@OneToMany(mappedBy = "tag", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<RecordUsersTag> tags = new ArrayList<>();
	
	public void addMovieTag(RecordUsersTag tag) {
		this.tags.add(tag);
	}
	
}