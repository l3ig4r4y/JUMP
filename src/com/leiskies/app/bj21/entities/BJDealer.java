package com.leiskies.app.bj21.entities;

import com.leiskies.app.bj21.enums.Role;

public class BJDealer extends CardPlayer {

	
	public BJDealer() {
		super();
		this.role = Role.DEALER;
		this.setDeck(new Deck());
		this.SetDealer(true);
	}
	
	public BJDealer(String string) {
		super(string);
		this.role = Role.DEALER;
		this.setDeck(new Deck());
		this.SetDealer(true);
	}

	@Override
	public String toString() {
		return "BJDealer [deck=" + deck + ", role=" + role + ", id=" + id + ", name=" + name + "]";
	}

	
	
}
