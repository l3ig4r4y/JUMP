package com.leiskies.app.bj21.utilities;

import com.leiskies.app.bj21.constants.Deck;
import com.leiskies.app.bj21.entities.Card;
import com.leiskies.app.bj21.entities.Hand;
import com.leiskies.app.bj21.enums.Suit;

public interface Dealer {

	public static Hand setGameDeck() {
		Hand fullDeck = new Hand(); 
		
		for(int i = Deck.RANGE[0]; i <= Deck.RANGE[1]; i++) {
			for (int j = 0; j < Suit.values().length; j++) {
				Card card = new Card(i, Suit.values()[j]);
				fullDeck.add(card);
			}
		}	
		return fullDeck;
	}
	
	public static Hand setSameValueCards(Integer carValue) {
		Hand fullDeck = new Hand(); 
		
		for(int i = Deck.RANGE[0]; i <= Deck.RANGE[1]; i++) {
			for (int j = 0; j < Suit.values().length; j++) {
				Card card = new Card(carValue, Suit.values()[j]);
				fullDeck.add(card);
			}
		}	//Collections.shuffle(fullDeck);
		return fullDeck;
	}
}
