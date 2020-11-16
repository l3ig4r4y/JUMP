package com.leiskies.app.bj21.utilities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.leiskies.app.bj21.constants.IOShop;
import com.leiskies.app.bj21.entities.Card;
import com.leiskies.app.bj21.entities.CardPlayer;
import com.leiskies.app.bj21.entities.Deck;
import com.leiskies.app.bj21.entities.Hand;
import com.leiskies.app.bj21.enums.Input;
import com.leiskies.app.bj21.enums.Render;
import com.leiskies.app.bj21.enums.Role;
import com.leiskies.app.bj21.enums.Show;
import com.leiskies.app.bj21.enums.Size;

public interface BJMechanics {
	public static int getBlackJackCount(List<CardPlayer> players) {
		int count = 0;
		for(CardPlayer player : players) {
			for(Hand hand : player.getDeck()) {
				if(hand.getSum()==21) {
					count++;
				}
			}
		}	return count;
	}
	public static int getStandingCount(List<CardPlayer> players) {
		int count = 0;
		for(CardPlayer player : players) {
			for(Hand hand : player.getDeck()) {
				if(hand.isStanding()) {
					count++;
				}
			}
		}	return count;
	}
	public static int getBustedCount(List<CardPlayer> players) {
		int count = 0;
		for(CardPlayer player : players) {
			for(Hand hand : player.getDeck()) {
				if(hand.isBusted()) {
					count++;
				}
			}
		}	return count;
	}	
	public static boolean addCardToHand(Card card, Hand hand, boolean doSum) {
		boolean add = hand.add(card);
		if(doSum) {
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
	public static void addCardToHand(int index, Card card, Hand hand, boolean doSum) {
		hand.add(index, card);
		if(doSum) {
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
		}	
	}	
	public static boolean dealCard(String emptySourceMsg, Hand handSource, Hand handTarget, boolean doSum) {
		boolean added = false;
		if(handSource.size() > 0) {
			added = addCardToHand(handSource.get(0), handTarget, doSum);
			handSource.remove(0);
		}	else {
			if(emptySourceMsg!=null && !emptySourceMsg.isBlank()) { 
				System.out.println(emptySourceMsg);
			}	else {
				System.out.println("No more cards to deal!");
			}
		}	return added;
	}
	public static void dealCard(Hand handSource, Hand handTarget, String emptySourceMsg, boolean doSum) {
		if(handSource.size() > 0) {
			addCardToHand(handSource.get(0), handTarget, doSum);
			handSource.remove(0);
		}	else {
			if(emptySourceMsg!=null && !emptySourceMsg.isBlank()) { 
				System.out.println(emptySourceMsg);
			}	else {
				System.out.println("No more cards to deal!");
			}
		}
	}
	public static void dealCard(Hand handSource, Hand handTarget) {
		if(handSource.size() > 0) {
			addCardToHand(handSource.get(0), handTarget, true);
			handSource.remove(0);
		}	else {
			System.out.println("No more cards to deal!");
		}
		
	}
	public static void dealCardToPlayers(List<CardPlayer> players, Hand fullDeck) {
		for(CardPlayer player : players) {
			for (Hand hand : player.getDeck()) {
				dealCard(fullDeck, hand);
				 
			}
		}
	}
	public static void checkSplittable(Deck deck) {
		//not modulable to hand level without throwing a concurrentMod exception and deck is needed to manage new hands.
		if(deck!=null && deck.getSplitCount()<4) {
			int count = 0;
			int splitAns = 0;
			int curSplittable = 0;
			
			for (int i = 0; i < deck.getHands().size(); i++) {
				
				if(deck.getHands().get(i).isSplittable()) {
					count++;
					
					if(curSplittable==1) {
						splitAns = InputTaker.getInputFrom(new Scanner(System.in), "Do you want to split this hand?", IOShop.YES_OR_NO, "");
					} else {
						splitAns = InputTaker.getInputFrom(new Scanner(System.in), "Do you want to split hand "+count+"?", IOShop.YES_OR_NO, "");
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
	public static void checkSplittable(Scanner scanner, CardPlayer player, Hand fullDeck) {
		if(!player.getRole().equals(Role.DEALER) && player.getDeck()!=null && player.getDeck().getSplitCount()<4) {
			int count = 0;
			int splitAns = 0;
			int curSplittable = 0;
			
			for(int i = 0; i < player.getDeck().size(); i++){
				if(player.getDeck().get(i).isSplittable()) {
					curSplittable++;
				}
			}
			
			for (int i = 0; i < player.getDeck().getHands().size(); i++) {
				
				if(player.getDeck().get(i).isSplittable() && player.getDeck().getSplitCount() < 4) {
					count++;
					
					
				
					if(curSplittable==1) {
						
						splitAns = InputTaker.getInputFrom(scanner, "Do you want to split this hand?", IOShop.YES_OR_NO, "");
					} else {
						splitAns = InputTaker.getInputFrom(scanner, "Do you want to split hand "+count+"?", IOShop.YES_OR_NO, "");
					} 
					
					
					if(splitAns==1) {
						if(player.getDeck().get(i).size()==2 && player.getDeck().get(i).get(0).getNumber() == player.getDeck().get(i).get(1).getNumber()) {
							Hand hand1 = new Hand();
							hand1.setSplittable(false);
							Hand hand2 = new Hand();
							hand2.setSplittable(false);
							addCardToHand(i,player.getDeck().get(i).get(0), hand1, true);
							dealCard(fullDeck, hand1);
							
							addCardToHand(i,player.getDeck().get(i).get(1), hand2, true);
							dealCard(fullDeck, hand2);
							player.getDeck().add(hand1);
							player.getDeck().add(hand2);
							player.getDeck().remove(i+2);
							player.getDeck().setSplitCount(player.getDeck().getSplitCount()+1);
							i=-1; // <=== HA!
						}
					}  
				}
			}
		}
	}
	public static void checkSplittable(Scanner scanner, List<CardPlayer> players, Hand fullDeck) {
		
		for(CardPlayer player : players) {
			
		
			//excludes dealer, null decks and triply split decks
			if(!player.getRole().equals(Role.DEALER) && player.getDeck()!=null && player.getDeck().getSplitCount()<4) {
				int count = 0;
				int splitAns = 0;
				int curSplittable = 0;
				
				//traverse through each decks hands
				for (int i = 0; i < player.getDeck().getHands().size(); i++) {
					
					if(player.getDeck().get(i).isSplittable() && player.getDeck().getSplitCount() < 3) {
						count++;
						for(int j = 0; j < player.getDeck().size(); j++){
							if(player.getDeck().get(i).isSplittable()) {
								curSplittable++;
							}
						}
						
						
						
						if(curSplittable==1) {
					
							int handNum = i+1;
							splitAns = InputTaker.getInputFrom(scanner, "\n"+player.getName()+" for Hand "+count+", ", IOShop.HIT_STAND_DOUBLE_SURRENDER_EXIT, "");
						} 
						
						if(splitAns==1) {
							if(player.getDeck().get(i).size()==2 && player.getDeck().get(i).get(0).getNumber() == player.getDeck().get(i).get(1).getNumber()) {
								Hand hand1 = new Hand();
								hand1.setSplittable(false);
								Hand hand2 = new Hand();
								hand2.setSplittable(false);
								addCardToHand(player.getDeck().get(i).get(0), hand1, true);
								//dealCard(fullDeck, hand1);
								
								addCardToHand(player.getDeck().get(i).get(1), hand2, true);
								//dealCard(fullDeck, hand2);
								player.getDeck().add(hand1);
								player.getDeck().add(hand2);
								player.getDeck().remove(i);
								player.getDeck().setSplitCount(player.getDeck().getSplitCount()+1);
								//System.out.println(player.getDeck().getSplitCount());
								//i=-1; // <=== HA!
								System.out.println();
								System.out.println("===========================");
								try {
									Renderer.renderDecks(players, Size.SMALL, Show.ALL, Render.CLOSE);
									Thread.sleep(1500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								dealCard(fullDeck, player.getDeck().get(i));
							
								checkSplittable(scanner, players, fullDeck);
								i=-1;
							}
						}  else {
							
							player.getDeck().get(i).setSplittable(false);
						}
						
					}
					
					
				}
			}
		}
	}
	public static void checkStats(Scanner scanner, List<CardPlayer> players, Hand fullDeck) {
		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < players.get(i).getDeck().size(); j++) {
				if(players.get(i).getDeck().get(j).isBlackJack()) {
					
				}	else if(players.get(i).getDeck().get(j).isSplittable()) {
					checkSplittable(scanner, players, fullDeck);
				}	else {
					
				}
			}
		}
	}
	public static void getPlayersBets(Scanner scanner, List<CardPlayer> players) {
		for(CardPlayer player : players) {
			if(!player.isDealer()) {
				for(Hand hand : player.getDeck()) {
					BigDecimal answer = null;
					System.out.print(player.getName()+", place your bet\n");
					answer = getAmount(scanner, com.leiskies.app.bj21.constants.Deck.INIT_CHIPS.intValue(), "");
					hand.setBet(answer);
					player.setChips(player.getChips().subtract(answer));
				}
			}
		}
	}
	public static BigDecimal getAmount(Scanner scanner, Integer limit, String failCaseMessage) {
		Boolean wrongInput = true;
		String promptAnswer = null;
		String tryAgain = null;
		Integer answer = null;
		String input = null;
		if(scanner==null) {
			scanner = new Scanner(System.in);
		}
		if(failCaseMessage==null) {
			failCaseMessage = "";
		} else {
			failCaseMessage = "\n"+failCaseMessage;
		}
		promptAnswer = IOShop.ENTER_AMOUNT;
		tryAgain = IOShop.INSUFFICIENT_FUNDS;
			
		while(wrongInput) {
			System.out.print(promptAnswer);
			
			input = scanner.nextLine().trim();
			
			if(!input.matches("^[1-9]*[0-9]+$" )) {	
				tryAgain = IOShop.OPTION_NOT_AVAIL;
				System.out.println(tryAgain + failCaseMessage);		
			} else {
				if(Integer.valueOf(input)>limit) {
				
					System.out.println(tryAgain + failCaseMessage);
				} else {
					wrongInput = false;
					answer = Integer.parseInt(input);
				}
			}
		}	return new BigDecimal(answer);
	}
	public static void surrender(CardPlayer player, Hand hand) {
		Calculator.surrenderHandBet(player, hand);
	}
	public static void doubleDown(CardPlayer player, Hand hand) {

		Calculator.surrenderHandBet(player, hand);
	}
	public static boolean arePlayersDone(List<CardPlayer> players) {
		boolean arePlayersDone = true;
		for(CardPlayer player : players) {
			if(!player.isDealer()) {
				for(Hand hand : player.getDeck()) {
					if(isHandPlayable(hand)) {
						return !arePlayersDone;
					}
				} 
			}
		}	return arePlayersDone;
	}
	
	public static boolean  assess(Scanner scanner, List<CardPlayer> players, CardPlayer player, Hand hand, Hand fullDeck) {
		boolean gameContinues = true;
		boolean arePlayersDone = arePlayersDone(players);
		boolean isDealerDone = false;
		int opt = 0;
		
		if(!arePlayersDone) {
				
			if(isHandPlayable(hand) && !player.isDealer()) {
				if(hand.isSplittable() && hand.size()<3) {
					opt =	InputTaker.getInputFrom
						(scanner, "", IOShop.HIT_STAND_SPLIT_DOUBLE_SURRENDER, Input.ONE_OPT_NEXT_LINE, true);
				}	else {
					opt =	InputTaker.getInputFrom
							(scanner, "", IOShop.HIT_STAND, Input.ONE_OPT_NEXT_LINE, true);
				}
				
				switch(opt) {
				
					case 0:	
						
					break;
					
					case 1: 
						dealCard(fullDeck, hand);
					break;
						
					case 2: hand.setStanding(true);					
					break;
						
					case 3:
						if(hand.isSplittable()) 
							checkSplittable(player.getDeck());
					break;
						
					case 4:
						Calculator.doubleDownHandBet(player, hand);
						dealCard(fullDeck, hand);
					break;
					
					case 5:
						hand.setSurrended(true);
						Calculator.surrenderHandBet(player, hand);
					break;
						
					case 6:
						System.out.println("bye");
					break;
						
					default:
					break;
				}
			}
	    } else {
	    	if(player.isDealer()==true && hand.getSum()<18) {
				dealCard(fullDeck, hand);
				
			}
			if(isHandPlayable(hand)!=true) {
				isDealerDone = true;
			}
			if(isDealerDone==true) {
				gameContinues = false;
			}
	    }
	
		
		return gameContinues;
	}

	public static boolean isHandPlayable(Hand hand) {
		boolean isHandPlayable = false;
		if(!hand.isSurrendered() && !hand.isBlackJack() && !hand.isStanding() && !hand.isBusted()) {
			isHandPlayable = !isHandPlayable;
		}	return isHandPlayable;
	}
	
	

}
