package com.leiskies.app.bj21.enums;

import java.util.ArrayList;
import java.util.List;

public enum Card {
	CARD_01(1,"A ","11,1"),
	CARD_02(2,"2 ","2"),
	CARD_03(3,"3 ","3"),
	CARD_04(4,"4 ","4"),
	CARD_05(5,"5 ","5"),
	CARD_06(6,"6 ","6"), 
	CARD_07(7,"7 ","7"),
	CARD_08(8,"8 ","8"),
	CARD_09(9,"9 ","9"),
	CARD_10(10,"10","10"),
	CARD_11(11,"J ","10"),
	CARD_12(12,"Q ","10"),
	CARD_13(13,"K ","10");

	private Integer faceValue;
	private String toCard;
	private ArrayList<Integer> actualValues;
	
	Card(Integer faceValue, String toCard, String actualValues) {
		this.faceValue = faceValue;
		this.toCard = toCard;
		List<Integer> intValues = new ArrayList<Integer>();
		for(String s: actualValues.split(",")) {
			intValues.add(Integer.valueOf(s));	}
		this.actualValues = (ArrayList<Integer>) intValues;
	}
	public Integer getFaceValue() {
		return faceValue;
	}
	public String toCard() {
		return toCard;
	}
	public ArrayList<Integer> getActualValues() {
		return actualValues;
	}
}
