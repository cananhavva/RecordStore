package com.canan.model;

public enum ShowQuality {
	p144(1, "144p"), p240(2, "240p"), p480(3, "480p"), p720(4, "720p"), p1080(5, "1080p");
	
	private int id;
	private String quality;
	
	ShowQuality(int id, String quality) {
		this.id = id;
		this.quality = quality;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuality() {
		return quality;
	}
	
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
}
