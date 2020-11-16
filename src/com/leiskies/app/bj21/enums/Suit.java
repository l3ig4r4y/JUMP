package com.leiskies.app.bj21.enums;

public enum Suit {
	/*
	 * suits with names, initials and symbols.
	 */
	CLUB	("Clubs", 	"C", "♣"),
	DIAMOND	("Diamonds","D", "♦"), 
	HEART	("Hearts", 	"H", "♥"),
	SPADE	("Spades", 	"S", "♠");
	
	private String name;
	private String initial;
	private String symbol;
	
	private Suit(String name, String initial, String symbol) {
		this.name = name;
		this.initial = initial;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}
	public String getInitial() {
		return initial;
	}
	public String getSymbol() {
		return symbol;
	} 
} 
