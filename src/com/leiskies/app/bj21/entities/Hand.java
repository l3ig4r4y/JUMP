package com.leiskies.app.bj21.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.leiskies.app.bj21.enums.Render;
import com.leiskies.app.bj21.enums.Show;
import com.leiskies.app.bj21.enums.Size;
import com.leiskies.app.bj21.utilities.Calculator;
import com.leiskies.app.bj21.utilities.Renderer;

@SuppressWarnings("serial")
public class Hand extends ArrayList<Card>{
	private List<Card> cards;
	private Integer sum;
	private Boolean splittable;
	private Boolean blackJack;
	private Boolean busted;
	private Boolean standing;
	private Boolean surrendered;
	private BigDecimal bet;
	public BigDecimal getBet() {
		return bet;
	}
	public void setBet(BigDecimal bet) {
		this.bet = bet;
	}
	public Hand() { 
		super();
		this.setCards(new ArrayList<Card>());
		this.setBet(new BigDecimal(0));
		this.setBlackJack(false);
		this.setBusted(false);
		this.setStanding(false);
		this.setSum(Calculator.getHandSum(this.getCards()));
		this.setSplittable(false); 
		this.setSurrended(false);
	}
	public Hand(List<Card> cards) {
		super();
		this.setCards(cards);
		this.setBet(new BigDecimal(0));
		this.setBlackJack(false);
		this.setBusted(false);
		this.setStanding(false);
		this.setSum(Calculator.getHandSum(this.getCards()));
		this.setSplittable(false); 
		this.setSurrended(false);
	}
	public boolean isSurrendered() {
		return surrendered;
	}
	public void setSurrended(Boolean surrendered) {
		this.surrendered = surrendered;
	}
	
	public boolean isSplittable() {
		return splittable;
	}
	public void setSplittable(Boolean splittable) {
		this.splittable = splittable;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public Boolean isBlackJack() { 
		return blackJack;
	}
	public void setBlackJack(Boolean blackJack) {
		this.blackJack = blackJack;
	}
	public Boolean isBusted() {
		return busted;
	}
	public void setBusted(Boolean busted) {
		this.busted = busted;
	}
	public Boolean isStanding() {
		return standing;
	}
	public void setStanding(Boolean standing) {
		this.standing = standing;
	}
	
	@Override
	public void add(int index, Card card) {
		cards.add(index, card);
	}
	@Override
	public void clear() {
		cards.clear();
	}
	@Override
	public boolean equals(Object card) {
		return cards.equals(card);
	}
	@Override
	public Card get(int index) {
		return cards.get(index);
	}
	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}

	@Override
	public boolean add(Card card) {
		// TODO Auto-generated method stub
		return cards.add(card);
	}
	@Override
	public Card remove(int index) {
		// TODO Auto-generated method stub
		return cards.remove(index);
	}
	
	@Override
	public Card set(int index, Card card) {
		return cards.set(index, card);
	}
	@Override
	public int size() {
		return cards.size();
	}
	@Override
	public Card[] toArray() {
		return (Card[]) cards.toArray();
	}
	@Override
	public Hand clone() {
		return ((Hand) cards).clone();
	}
	@Override
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	@Override
	public String toString() {
		return "Hand [sum=" + sum + ", cards=" + cards + ", splittable=" + splittable + ", blackJack=" + blackJack
				+ ", busted=" + busted + ", standing=" + standing + ", bet=" + bet +  "]";
	}
	
	

	public void render(String cap, boolean dealer) {
		System.out.println(cap);
		if(!dealer) {
			Renderer.renderHand(this, Size.LARGE, Show.ALL, Render.LOOSE);
		}	else {
			Renderer.renderHand(this, Size.LARGE, Show.ALL_BUT_LAST, Render.LOOSE);
		}
	}
}
