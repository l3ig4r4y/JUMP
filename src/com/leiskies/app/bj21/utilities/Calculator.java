package com.leiskies.app.bj21.utilities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leiskies.app.bj21.constants.Deck;
import com.leiskies.app.bj21.constants.IOShop;
import com.leiskies.app.bj21.entities.Card;
import com.leiskies.app.bj21.entities.CardPlayer;
import com.leiskies.app.bj21.entities.Hand;

public interface Calculator {
	public static Integer getHandSum(Hand hand) {
		Integer sum = 0;
		List<Integer> cardNumbers = new ArrayList<Integer>();
		for(Card card:hand) {
			cardNumbers.add(card.getNumber());
		}	Collections.sort(cardNumbers,Collections.reverseOrder());
		//System.out.println(cardNumbers);
		for(int i=0; i<cardNumbers.size(); i++) {
			List<Integer> cardValues = Deck.VALUES.get(cardNumbers.get(i)).getActualValues();
			
			Collections.sort(cardValues,Collections.reverseOrder());
			for(int j=0; j<cardValues.size(); j++) {
				int cardValue = cardValues.get(j);
				if(cardNumbers.get(i)!=1) { 
					sum+= cardValue;
				} else {
					if(cardValue==11) {
						if( (sum + cardValue) + (cardNumbers.size() - i - 1 ) < 22) {
							sum+=cardValue;
						}	else {
							sum+=1;
						}
					} 
				}
			}
		}	return sum;
	}
	public static Integer getHandSum(List<Card> cards) {
		Integer sum = 0;
		List<Integer> cardNumbers = new ArrayList<Integer>();
		for(Card card:cards) {
			cardNumbers.add(card.getNumber());
		}	Collections.sort(cardNumbers,Collections.reverseOrder());
		//System.out.println(cardNumbers);
		for(int i=0; i<cardNumbers.size(); i++) {
			List<Integer> cardValues = Deck.VALUES.get(cardNumbers.get(i)).getActualValues();
			
			Collections.sort(cardValues,Collections.reverseOrder());
			for(int j=0; j<cardValues.size(); j++) {
				int cardValue = cardValues.get(j);
				if(cardNumbers.get(i)!=1) { 
					sum+= cardValue;
				} else {
					if(cardValue==11) {
						if( (sum + cardValue) + (cardNumbers.size() - i - 1 ) < 22) {
							sum+=cardValue;
						}	else {
							sum+=1;
						}
					} 
				}
			}
		}	return sum;
	}

	public static BigDecimal add(BigDecimal bigDecimal1, BigDecimal bigDecimal2) {
		return bigDecimal2.add(bigDecimal1);
	}
	public static BigDecimal substract(BigDecimal bigDecimal1, BigDecimal bigDecimal2) {
		return bigDecimal1.subtract(bigDecimal2);
	}

	public static void substractBetfromChips(CardPlayer player, BigDecimal bet) {
		player.setChips(substract(player.getChips(), bet));
	}
	public static void substractBetfromChips(CardPlayer player, Integer bet) {
		player.setChips(substract(player.getChips(), new BigDecimal(bet)));
	}
	public static void addToChips(CardPlayer player, BigDecimal bet) {
		player.setChips(add(player.getChips(), bet));
	}
		
	public static void addToChips(CardPlayer player, Integer bet) {
		player.setChips(add(player.getChips(), new BigDecimal(bet)));
	}
	
	public static BigDecimal addWinToBet(BigDecimal bet, boolean blackJack) {
		if(blackJack) {
			return bet.multiply(new BigDecimal(2.5));
		}	else {
			return bet.multiply(new BigDecimal(2));
		}
	}
	public static void addBetWinToPlayerChips(CardPlayer player, Hand hand, boolean blackJack) {
		addToChips(player, addWinToBet(hand.getBet(), blackJack));
		hand.setBet(new BigDecimal(0));
	}
	
	public static void setPlayerBetForHand(BigDecimal bet, CardPlayer player, Hand hand) {
		if(bet.compareTo(player.getChips())==1 || bet.compareTo(player.getChips())==0) {
			substractBetfromChips(player, bet);
			hand.setBet(bet);
		}	else {
			System.out.println(IOShop.INSUFFICIENT_FUNDS);
		}
		
	}
	public static void setPlayerBetForHand(Integer bet, CardPlayer player, Hand hand) {
		if((new BigDecimal(bet)).compareTo(player.getChips())==-1 || (new BigDecimal(bet)).compareTo(player.getChips())==0) {
			substractBetfromChips(player, bet);
			hand.setBet(new BigDecimal(bet));
		}	else {
			System.out.println(IOShop.INSUFFICIENT_FUNDS);
		}
	}
	
	public static void doubleDownHandBet(CardPlayer player, Hand hand) {
		BigDecimal dd = hand.getBet().multiply(new BigDecimal(2));
		if(hand.getBet().compareTo(player.getChips())==-1 || hand.getBet().compareTo(player.getChips())==0)	{
			substractBetfromChips(player, hand.getBet());
			hand.setBet(new BigDecimal(0));
		}	else {
			System.out.println(IOShop.INSUFFICIENT_FUNDS);
		}
	}
	public static void surrenderHandBet(CardPlayer player, Hand hand) {
		BigDecimal dd = hand.getBet().multiply(new BigDecimal(0.5));
		addToChips(player, dd); 
		hand.setBet(new BigDecimal(0));
	}
	
	public static void addToBet(Integer add, CardPlayer player, Hand hand) {
		if((new BigDecimal(add)).compareTo(player.getChips())==-1 || (new BigDecimal(add)).compareTo(player.getChips())==0) {
			substractBetfromChips(player, add);
			hand.setBet(hand.getBet().add(new BigDecimal(add)));
		}	else {
			System.out.println(IOShop.INSUFFICIENT_FUNDS);
		}
	}
	
	public static Integer getMaxLen(List<String> strList) {
		return strList.stream().mapToInt( v -> v.length()).max().orElseThrow();
	}
}
