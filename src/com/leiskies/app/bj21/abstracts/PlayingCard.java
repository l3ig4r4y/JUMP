package com.leiskies.app.bj21.abstracts;

import com.leiskies.app.bj21.enums.Suit;

public abstract class PlayingCard { 
	protected Integer number;
	protected Suit suit;
	public PlayingCard() {}
	public PlayingCard(Integer number, Suit suit) {
		super();
		this.number = number;
		this.suit = suit;
	}
	public PlayingCard(Suit suit, Integer number) {
		super();
		this.number = number;
		this.suit = suit;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	@Override
	public String toString() {
		return "PlayingCard [number=" + number + ", suit=" + suit + "]";
	}
}
