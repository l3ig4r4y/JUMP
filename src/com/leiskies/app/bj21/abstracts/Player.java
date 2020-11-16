package com.leiskies.app.bj21.abstracts;

public abstract class Player {
	protected Integer id;
	protected String name;
	 
	public Player() {} 
	public Player(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Player(String name, Integer id) {
		super();
		this.id = id;
		this.name = name;
	}
	public Player(Integer id) {
		super();
		this.id = id;
	}
	public Player(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}
	
	
} 
