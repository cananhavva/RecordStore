package com.canan.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	private long id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<RecordUsersTag> RecordTags = new ArrayList<>();
	
	public void addRecordTag(RecordUsersTag tag) {
		this.RecordTags.add(tag);
	}
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(long id, String name, List<RecordUsersTag> recordTags) {
		super();
		this.id = id;
		this.name = name;
		RecordTags = recordTags;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(RecordTags, id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(RecordTags, other.RecordTags) && id == other.id && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", RecordTags=" + RecordTags + "]";
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
	
	public List<RecordUsersTag> getRecordTags() {
		return RecordTags;
	}
	
	public void setRecordTags(List<RecordUsersTag> recordTags) {
		RecordTags = recordTags;
	}
	
}