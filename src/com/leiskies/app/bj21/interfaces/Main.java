package com.leiskies.app.bj21.interfaces;

import com.leiskies.app.bj21.entities.Card;
import com.leiskies.app.bj21.entities.Hand;
import com.leiskies.app.bj21.enums.Suit;
import com.leiskies.app.bj21.utilities.BJMechanics;

public class Main {
	public static void main(String[] args) {
		Hand hand = new Hand();
		Card card1 = new Card(1,Suit.CLUB);
		Card card2 = new Card(11,Suit.CLUB);
		
		//BJMechanics.addCardToHand(card1, hand, true);
		BJMechanics.addCardToHand(card2, hand, true);
		BJMechanics.addCardToHand(card2, hand, true);
		
		System.out.println(hand);
		
		System.out.println(BJMechanics.isHandPlayable(hand));
		boolean playerCanPlay = true;
		boolean dealCanPlayer = true;
		
	}
}
