package com.leiskies.app.bj21.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.leiskies.app.bj21.constants.IOShop;
import com.leiskies.app.bj21.utilities.InputTaker;

@SuppressWarnings("serial")
public class Deck extends ArrayList<Hand> {
	private List<Hand> hands;
	private Integer splitCount;
  
	public Deck() {
		super();
		Hand hand = new Hand();
		List<Hand> hands = new ArrayList<Hand>();
		hands.add(hand);
		this.setHands(hands);
		this.setSplitCount(0);
	}
	public Deck(List<Hand> hands, BigDecimal totalBet, Integer splitCount) {
		super();
		this.setHands(hands);
		this.setSplitCount(splitCount);
	}
	public Deck(List<Hand> hands) {
		super();
		this.setHands(hands);
		this.setSplitCount(0);
	}
	public List<Hand> getHands() {
		return hands;
	}
	public void setHands(List<Hand> hands) {
		this.hands = hands;
	}
	public Integer getSplitCount() {
		return splitCount;
	}
	public void setSplitCount(Integer splitCount) {
		this.splitCount = splitCount;
	}
	@Override
	public boolean add(Hand hand) {
		// TODO Auto-generated method stub
		return hands.add(hand);
	}
	@Override
	public void add(int index, Hand element) {
		// TODO Auto-generated method stub
		hands.add(index, element);
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		hands.clear();
	}
	@Override
	public Deck clone() {
		// TODO Auto-generated method stub
		return ((Deck) hands).clone();
	}
	@Override
	public void forEach(Consumer<? super Hand> arg0) {
		// TODO Auto-generated method stub
		hands.forEach(arg0);
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return hands.isEmpty();
	}
	@Override
	public Iterator<Hand> iterator() {
		// TODO Auto-generated method stub
		return hands.iterator();
	}
	@Override
	public Hand remove(int index) {
		// TODO Auto-generated method stub
		return hands.remove(index);
	}
	@Override
	public boolean remove(Object hand) {
		// TODO Auto-generated method stub
		return hands.remove(hand);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return hands.size();
	}
	@Override
	public Hand get(int index) {
		// TODO Auto-generated method stub
		return hands.get(index);
	}
	@Override
	public String toString() {
		return "Deck [hands=" + hands + ", splitCount=" + splitCount + "]";
	}
	
	
}
