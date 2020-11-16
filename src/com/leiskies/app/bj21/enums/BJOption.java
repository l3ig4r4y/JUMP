package com.leiskies.app.bj21.enums;

public enum BJOption {
	NEW_GAME(0, "New Game","new game"),
	HIT(1,"Hit","hit"),
	STAND(2,"Stand","stand"),
	SPLIT(3,"Split","split"),
	DOUBLE_DOWN(4,"Double Down", "double down"),
	SURRENDER(5, "Surrender", "surrender"),
	EXIT(6,"Exit","exit");
	BJOption(int id, String cap, String low) {
		this.setId(id);
		this.setCap(cap);
		this.setLow(low);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	private int id;
	private String cap;
	private String low;
}
