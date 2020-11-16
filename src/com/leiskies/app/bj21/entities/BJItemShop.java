package com.leiskies.app.bj21.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leiskies.app.bj21.enums.Role;
import com.leiskies.app.bj21.utilities.Dealer;

public class BJItemShop {
	private BJItemShop() {}
	public static CardPlayer getCardPlayer(Role role) {
		switch (role) {
		case DEALER:
			return new BJDealer(role.getName());
		case PLAYER:
			return new BJPlayer(role.getName());
		default:
			return new CardPlayer();
		}
	}
	public static CardPlayer getCardPlayer(Integer id, Role role) {
		switch (role) {
		case DEALER:
			return new BJDealer(role.getName());
		case PLAYER:
			return new BJPlayer(id,role.getName());
		default:
			return new CardPlayer();
		}
	}
	
	public static Hand getFullDeck(boolean shuffled) {
		Hand hand = Dealer.setGameDeck();
		if(shuffled) {
			Collections.shuffle(hand);
		}	return hand;
	}
	
	public static Hand getTestDeckSameValues(Integer cardValue) {
		return Dealer.setSameValueCards(cardValue);
	}
	
	public static List<CardPlayer> getBJPlayers(Integer numPlayers){
		List<CardPlayer> players = null;
		if(numPlayers!=null && numPlayers!=0) {
			players = new ArrayList<CardPlayer>();
			for (int i = 0; i <= numPlayers; i++) {
				players.add(i==0?getCardPlayer(Role.DEALER):getCardPlayer(i,Role.PLAYER));
			}
		}	return players;
	}
}
