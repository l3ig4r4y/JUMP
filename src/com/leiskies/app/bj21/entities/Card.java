package com.leiskies.app.bj21.entities;

import com.leiskies.app.bj21.abstracts.PlayingCard;
import com.leiskies.app.bj21.enums.Size;
import com.leiskies.app.bj21.enums.Suit;
import com.leiskies.app.bj21.utilities.Renderer;

public class Card extends PlayingCard {
 	
	public Card() {}
	public Card(Integer number, Suit suit) {
		super(number, suit);
	}
	public Card(Suit suit, Integer number) {
		super(number, suit);
	}
	 
	public void renderSmall() {
		Renderer.renderCard(this, Size.SMALL);
	}
	
	public void renderLarge() {
		Renderer.renderCard(this, Size.LARGE);
	}
	
	@Override
	public String toString() {
		return "Card [number=" + number + ", suit=" + suit + "]";
	}
}
