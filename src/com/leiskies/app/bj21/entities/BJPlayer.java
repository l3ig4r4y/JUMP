package com.leiskies.app.bj21.entities;

import com.leiskies.app.bj21.enums.Role;

public class BJPlayer extends CardPlayer {
	
	public BJPlayer() {}
	public BJPlayer(Integer id, String name) {
		super(id, name+" "+id);
		this.role = Role.PLAYER;
		this.setDeck(new Deck());
		this.SetDealer(false);
		this.setChips(com.leiskies.app.bj21.constants.Deck.INIT_CHIPS);
	}
	
	public BJPlayer(String name) {
		super(name);
		this.role = Role.PLAYER;
		this.setDeck(new Deck());
		this.setDeck(new Deck());
		this.SetDealer(false);
		this.setChips(com.leiskies.app.bj21.constants.Deck.INIT_CHIPS);
	}
}
