package com.leiskies.app.bj21.utilities;

import java.util.List;

import com.leiskies.app.bj21.constants.Deck;
import com.leiskies.app.bj21.constants.Visual;
import com.leiskies.app.bj21.entities.Card;
import com.leiskies.app.bj21.entities.CardPlayer;
import com.leiskies.app.bj21.entities.Hand;
import com.leiskies.app.bj21.enums.Render;
import com.leiskies.app.bj21.enums.Role;
import com.leiskies.app.bj21.enums.Show;
import com.leiskies.app.bj21.enums.Size;
import com.leiskies.app.bj21.enums.Suit;

public interface Renderer {
	public static void renderCard(Suit suit, int number, Size size) {
		String[][] deckTemplate = null;
		if(size==null) {
			size = Size.SMALL;
		} 
		switch(size) {
		case LARGE:
			deckTemplate = Visual.LARGE;
			for(int i = 0; i< deckTemplate[0].length; i++) {
				for (int j = number; j < number+1; j++) {
					System.out.print(deckTemplate[j][i].replace("x", suit.getSymbol()));
				}	System.out.println();
			}	break;
		case SMALL:
			deckTemplate = Visual.SMALL;
			for (int i = 0; i < deckTemplate[0].length; i++) {
				System.out.println(deckTemplate[1][i].replace("x", suit.getSymbol()).replace("DD", Deck.VALUES.get(number).toCard()));
			}	break;	
		default:
			deckTemplate = Visual.SMALL;
			for (int i = 0; i < deckTemplate[0].length; i++) {
				System.out.println(deckTemplate[1][i].replace("x", suit.getSymbol()).replace("DD", Deck.VALUES.get(number).toCard()));
			}	break;
		
		}
	}
	public static void renderCard(Card card, Size size) {
		String[][] deckTemplate = null;
		if(size==null) {
			size = Size.SMALL;
		}
		switch(size) {
		case LARGE:
			deckTemplate = Visual.LARGE;
			for(int i = 0; i< deckTemplate[0].length; i++) {
				for (int j = card.getNumber(); j < card.getNumber()+1; j++) {
					System.out.print(deckTemplate[j][i].replace("x", card.getSuit().getSymbol()));
				}	System.out.println();
			}	break;
		case SMALL:
			deckTemplate = Visual.SMALL;
			for (int i = 0; i < deckTemplate[0].length; i++) {
				System.out.println(deckTemplate[1][i].replace("x", card.getSuit().getSymbol()).replace("DD", Deck.VALUES.get(card.getNumber()).toCard()));
			}	break;	
		default:
			deckTemplate = Visual.SMALL;
			for (int i = 0; i < deckTemplate[0].length; i++) {
				System.out.println(deckTemplate[1][i].replace("x", card.getSuit().getSymbol()).replace("DD", Deck.VALUES.get(card.getNumber()).toCard()));
			}	break;
			
		}
	}
	public static void renderHand(int index, Hand hand, Size size, Show show, Render render, Role role) {
		
		String status = "";
		if(role.equals(Role.PLAYER)) {
			if(hand.isBusted()) {
				status = "BUST!";
			} else if(hand.isBlackJack()){
				status = "BLACKJACK!";
			}
		}
		
		int[] proximity = null;
		switch(render) {
		case ONLY_NUMBER: 
			proximity = new int [] {0,Visual.LARGE[0][0].length()/4};
			break;
		case CLOSE:	
			proximity = new int [] {0,Visual.LARGE[0][0].length()/3};
			break;
		case FULL_CARD:
			proximity = new int [] {0,Visual.LARGE[0][0].length()/1};
			break;
		case LOOSE:
			proximity = new int [] {0,Visual.LARGE[0][0].length()/2};
			break;
		default:
			break;
		}
		
		String[][] deckTemplate = null;
		int cardNumber = 0;
		String symbol = null;
		
		switch(size) {
		
		case LARGE:
			deckTemplate = Visual.LARGE;
			////////////////////////////
			if(!role.equals(Role.DEALER)) {
				System.out.println("HAND "+ index+"\t["+hand.getSum()+"]  " + status);
			}
			
			/////////////////////////////
			for(int i=0; i < deckTemplate[0].length; i++) {
				for(int j = 0; j < hand.size(); j++) {
					cardNumber = hand.get(j).getNumber();
					symbol = hand.get(j).getSuit().getSymbol();
					
					switch(show) { 
					case NONE:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						}
						break;
					case ALL:	
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						}
						break;
					case ALL_BUT_LAST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						}
						break;
					case ONLY_LAST:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						}
						break;
					case ONLY_FIRST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						} 	else {
							if(j==0) {
								System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							} else {
								System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							}
							
						}
						break;
					case ALL_BUT_FIRST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						} 	else {
							if(j==0) {
								System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							} else {
								System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							}
						}
						break;
					default:
						break;
					
					}
				}	System.out.println();
			} 	break;
		
		case SMALL:
			deckTemplate = Visual.SMALL; 
			////////////////////////////
			if(!role.equals(Role.DEALER)) {
				System.out.println("HAND "+ index+"\t["+hand.getSum()+"]  " + status);
			}
			/////////////////////////////
			for (int i = 0; i < deckTemplate[0].length; i++) {
				for(int j = 0; j < hand.size(); j++) {
					cardNumber = hand.get(j).getNumber();
					symbol = hand.get(j).getSuit().getSymbol();
					switch(show) {
					case NONE:	
						System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						break;
					case ALL:	
						System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						break;
					case ALL_BUT_FIRST:
						if(j==0) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ALL_BUT_LAST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ONLY_LAST:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ONLY_FIRST:
						if(j!=0) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						
						break;
					default:
						break;
					}
				
				}	System.out.println();
			} 	break;
			
		default:
			break; 
		}
	}
	public static void renderHand(Hand hand, boolean large, Show show, Render render) {
		String status = "";
		if(hand.isBusted()) {
			status = "BUST!";
		} else if(hand.isBlackJack()){
			status = "BLACKJACK!";
		}
		
		int[] proximity = null;
		switch(render) {
		case ONLY_NUMBER: 
			proximity = new int [] {0,Visual.LARGE[0][0].length()/4};
			break;
		case CLOSE:	
			proximity = new int [] {0,Visual.LARGE[0][0].length()/3};
			break;
		case FULL_CARD:
			proximity = new int [] {0,Visual.LARGE[0][0].length()/1};
			break;
		case LOOSE:
			proximity = new int [] {0,Visual.LARGE[0][0].length()/2};
			break;
		default:
			break;
		}
		
		String[][] deckTemplate = null;
		int cardNumber = 0;
		String symbol = null;
		if(large) { 
			deckTemplate = Visual.LARGE;
			////////////////////////////
			//System.out.println("HAND \t["+hand.getSum()+"]  " + status);
			/////////////////////////////
			for(int i=0; i < deckTemplate[0].length; i++) {
				for(int j = 0; j < hand.size(); j++) {
					cardNumber = hand.get(j).getNumber();
					symbol = hand.get(j).getSuit().getSymbol();
					
					switch(show) {
					case NONE:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						}
						break;
					case ALL:	
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						}
						break;
					case ALL_BUT_LAST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						}
						break;
					case ONLY_LAST:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						}
						break;
					case ONLY_FIRST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						} 	else {
							if(j==0) {
								System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							} else {
								System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							}
							
						}
						break;
					case ALL_BUT_FIRST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						} 	else {
							if(j==0) {
								System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							} else {
								System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							}
						}
						break;
					default:
						break;
						
					}
				}	System.out.println();
			} 
		} else {
			deckTemplate = Visual.SMALL; 
			////////////////////////////
			//System.out.println("HAND \t["+hand.getSum()+"]  " + status);
			/////////////////////////////
			for (int i = 0; i < deckTemplate[0].length; i++) {
				for(int j = 0; j < hand.size(); j++) {
					cardNumber = hand.get(j).getNumber();
					symbol = hand.get(j).getSuit().getSymbol();
					switch(show) {
					case NONE:	
						System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						break;
					case ALL:	
						System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						break;
					case ALL_BUT_FIRST:
						if(j==0) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ALL_BUT_LAST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ONLY_LAST:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ONLY_FIRST:
						if(j!=0) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						
						break;
					default:
						break;
					}
					
				}	System.out.println();
			} 
		}
	}
	public static void renderHand(Hand hand, Size size, Show show, Render render) {
		String status = "";
		if(hand.isBusted()) {
			status = "BUST!";
		} else if(hand.isBlackJack()){
			status = "BLACKJACK!";
		}
		
		int[] proximity = null;
		switch(render) {
		case ONLY_NUMBER: 
			proximity = new int [] {0,Visual.LARGE[0][0].length()/4};
			break;
		case CLOSE:	
			proximity = new int [] {0,Visual.LARGE[0][0].length()/3};
			break;
		case FULL_CARD:
			proximity = new int [] {0,Visual.LARGE[0][0].length()/1};
			break;
		case LOOSE:
			proximity = new int [] {0,Visual.LARGE[0][0].length()/2};
			break;
		default:
			break;
		}
		
		String[][] deckTemplate = null;
		int cardNumber = 0;
		String symbol = null;
		switch(size) {
		case LARGE:
			deckTemplate = Visual.LARGE;
			////////////////////////////
			System.out.println("HAND \t["+hand.getSum()+"]  " + status);
			/////////////////////////////
			for(int i=0; i < deckTemplate[0].length; i++) {
				for(int j = 0; j < hand.size(); j++) {
					cardNumber = hand.get(j).getNumber();
					symbol = hand.get(j).getSuit().getSymbol();
					
					switch(show) {
					case NONE:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						}
						break;
					case ALL:	
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						}
						break;
					case ALL_BUT_LAST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						}
						break;
					case ONLY_LAST:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
						} 	else {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						}
						break;
					case ONLY_FIRST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol));
						} 	else {
							if(j==0) {
								System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							} else {
								System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							}
							
						}
						break;
					case ALL_BUT_FIRST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[cardNumber][i].replace("x", symbol));
						} 	else {
							if(j==0) {
								System.out.print(deckTemplate[0][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							} else {
								System.out.print(deckTemplate[cardNumber][i].substring(proximity[0],proximity[1]).replace("x", symbol));
							}
						}
						break;
					default:
						break;
						
					}
				}	System.out.println();
			} 
			break;
			
		case SMALL:
			deckTemplate = Visual.SMALL; 
			////////////////////////////
			System.out.println("HAND \t["+hand.getSum()+"]  " + status);
			/////////////////////////////
			for (int i = 0; i < deckTemplate[0].length; i++) {
				for(int j = 0; j < hand.size(); j++) {
					cardNumber = hand.get(j).getNumber();
					symbol = hand.get(j).getSuit().getSymbol();
					switch(show) {
					case NONE:	
						System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						break;
					case ALL:	
						System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						break;
					case ALL_BUT_FIRST:
						if(j==0) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ALL_BUT_LAST:
						if(j==hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ONLY_LAST:
						if(j!=hand.size()-1) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						break;
					case ONLY_FIRST:
						if(j!=0) {
							System.out.print(deckTemplate[0][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						} else {
							System.out.print(deckTemplate[1][i].replace("x", symbol).replace("DD", Deck.VALUES.get(cardNumber).toCard()));
						}
						
						break;
					default:
						break;
					}
					
				}	System.out.println();
			} 
			break;
			
		default:
			break;
		
		}
	}


	public static void renderDecks(List<CardPlayer> players, Size size, Show show, Render render) {
		
		for (int i = 0; i < players.size(); i++) {
			CardPlayer tempPlayer = players.get(i);
			if(tempPlayer.getRole().equals(Role.DEALER)) {
				System.out.println(tempPlayer.getName());
				int index = 0;
				for (int j = 0; j < tempPlayer.getDeck().getHands().size(); j++) {
					Hand tempDeck = tempPlayer.getDeck().getHands().get(j);
					index++;
					
					if(tempPlayer.getRole().equals(Role.DEALER)) {
						renderHand(index, tempDeck, Size.SMALL, Show.ALL_BUT_FIRST, Render.CLOSE, Role.DEALER);
					}	else {
						renderHand(index, tempDeck, Size.SMALL, Show.ALL, Render.CLOSE, Role.DEALER);
					}
					
				}
			}	else {
				System.out.println(tempPlayer.getName());
				int index = 0;
				for (int j = 0; j < tempPlayer.getDeck().getHands().size(); j++) {
					Hand tempDeck = tempPlayer.getDeck().getHands().get(j);
					index++;
					renderHand(index, tempDeck, Size.SMALL, Show.ALL, Render.CLOSE, Role.PLAYER);
				}
			}
		}
	}
	public static void renderAll(List<CardPlayer> players, Size size, Show show, Render render) {
		
		for (int i = 0; i < players.size(); i++) {
			CardPlayer tempPlayer = players.get(i);
				System.out.println(tempPlayer.getName());
				int index = 0;
				for (int j = 0; j < tempPlayer.getDeck().getHands().size(); j++) {
					Hand tempDeck = tempPlayer.getDeck().getHands().get(j);
					index++;
					
				renderHand(index, tempDeck, Size.SMALL, Show.ALL, Render.CLOSE, Role.PLAYER);	
			}
			
		}
	}
	
	public static void renderDecks(boolean playable, List<CardPlayer> players, Size size, Show show, Render render) {
		
		for (int i = 0; i < players.size(); i++) {
			if(playable) {
				Renderer.renderDecks(players, Size.SMALL, Show.ALL, Render.LOOSE);
			}	else {
				Renderer.renderAll(players, Size.SMALL, Show.ALL, Render.LOOSE);
			}
		}
	}

}
