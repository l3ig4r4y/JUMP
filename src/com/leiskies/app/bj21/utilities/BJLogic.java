package com.leiskies.app.bj21.utilities;

import java.util.Scanner;

import com.leiskies.app.bj21.constants.IOShop;
import com.leiskies.app.bj21.entities.Card;
import com.leiskies.app.bj21.entities.Deck;
import com.leiskies.app.bj21.entities.Hand;

public interface BJLogic {
	public static boolean addCardToHand(Card card, Hand hand, boolean cal) {
		boolean add = hand.add(card);
		if(cal) {
			hand.setSum(Calculator.getHandSum(hand));
			if(hand.getSum()==21) {
				hand.setBlackJack(true);
			}	else if(hand.getSum()>21) {
				hand.setBlackJack(false);
				hand.setBusted(true);
			}
			if(hand.size()==2 && hand.get(0).getNumber() == hand.get(1).getNumber()) {
				hand.setSplittable(true);
			}
		}	return add;
	}
	public static boolean dealCardtoHand(Hand handSource, Hand handTarget, boolean cal) {
		boolean added = false;
		if(handSource.size() > 0) {
			added = addCardToHand(handSource.get(0), handTarget, cal);
			handSource.remove(0);
		}	else {
			System.out.println("No more cards to deal!");
		}	return added;
	}
	public static void checkSplit(Scanner scanner, Deck deck) {
		if(deck!=null && deck.getSplitCount()<4) {
			int count = 0;
			int splitAns = 0;
			int curSplittable = 0;
			
			for (int i = 0; i < deck.getHands().size(); i++) {
				if(deck.getHands().get(i).isSplittable()) {
					count++;
					
					if(curSplittable==1) {
						splitAns = InputTaker.getInputFrom(scanner, "Do you want to split this hand?", IOShop.YES_OR_NO, "");
					} else {
						splitAns = InputTaker.getInputFrom(scanner, "Do you want to split hand "+count+"?", IOShop.YES_OR_NO, "");
					} 
					
					if(splitAns==1) {
						if(deck.getHands().get(i).size()==2 && deck.getHands().get(i).get(0).getNumber() == deck.getHands().get(i).get(1).getNumber()) {
							Hand hand1 = new Hand();
							hand1.setSplittable(false);
							Hand hand2 = new Hand();
							hand2.setSplittable(false);
							addCardToHand(deck.getHands().get(i).get(0), hand1, true);
							addCardToHand(deck.getHands().get(i).get(1), hand2, true);
							deck.getHands().add(hand1);
							deck.getHands().add(hand2);
							deck.getHands().remove(i);
							deck.setSplitCount(deck.getSplitCount()+1);
							i=-1; // <=== HA!
						}
					}  
				}
			}
		}
	}
}
