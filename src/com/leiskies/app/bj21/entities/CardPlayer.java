package com.leiskies.app.bj21.entities;

import java.math.BigDecimal;

import com.leiskies.app.bj21.abstracts.Player;
import com.leiskies.app.bj21.enums.Role;

public class CardPlayer extends Player {
	
	protected Deck deck;
	protected Role role;
	protected BigDecimal chips; 
	protected Boolean dealer;
	
	public CardPlayer() {
		this.deck = new Deck();
		this.setChips(new BigDecimal(0));
	}

	public CardPlayer(String string) {
		super(string);
		this.setChips(new BigDecimal(0));
	}

	public CardPlayer(Integer id, String name) {
		super(id,name);
		this.setChips(new BigDecimal(0));
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public static CardPlayer getPlayer(Role role) {
		switch(role) {
		case DEALER:	return new BJDealer(role.getName());
		case PLAYER:	return new BJPlayer(role.getName());
		default:
			return new CardPlayer();
		}
	}
	public static CardPlayer getPlayer(Integer id, Role role) {
		switch(role) {
		case DEALER:	return new BJDealer(role.getName());
		case PLAYER:	return new BJPlayer(id, role.getName());
		default:
			return new CardPlayer();
		}
	}
	
	public Boolean isDealer() {
		return dealer;
	}
	
	public void SetDealer(Boolean dealer) {
		this.dealer = dealer;
	}
	
	public BigDecimal getChips() {
		return chips;
	}
	
	public void setChips(BigDecimal chips) {
		this.chips = chips;
	}
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	@Override
	public String toString() {
		return "CardPlayer [chips=" + chips + ", role=" + role + ", deck=" + deck + ", dealer=" + dealer + "]";
	}

	
	
}
