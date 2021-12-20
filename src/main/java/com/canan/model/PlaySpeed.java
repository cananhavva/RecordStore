package com.canan.model;

public enum PlaySpeed {
	
	speed33(1, "33"), speed45(2, "45"), speed78(3, "78");
	
	private int id;
	private String speed;
	
	private PlaySpeed(int id, String speed) {
		this.id = id;
		this.speed = speed;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSpeed() {
		return speed;
	}
	
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
}
