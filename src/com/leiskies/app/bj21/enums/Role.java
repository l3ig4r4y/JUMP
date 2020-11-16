package com.leiskies.app.bj21.enums;

public enum Role {
	/*
	 * Roles and their names.
	 */
	PLAYER("Player"), 
	DEALER("Dealer");
	
	private String name;

	private Role(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
