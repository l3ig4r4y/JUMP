package com.leiskies.app.bj21.constants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.leiskies.app.bj21.enums.BJOption;

public interface IOShop {
	public static final String [] HIT_STAND_DOUBLE_SURRENDER_EXIT = new String[] {"Hit", "Stand", "Double down", "Surrender", "Exit" };
	public static final List<String> HIT_STAND_SPLIT_DOUBLE_SURRENDER = new ArrayList<String>(Arrays.asList("New Game","Hit","Stand","Split","Double Down","Surrender"));

	public static final List<String> HIT_STAND = HIT_STAND_SPLIT_DOUBLE_SURRENDER.subList(0,HIT_STAND_SPLIT_DOUBLE_SURRENDER.size()-3);
	public static final List<String> HIT_STAND_DOUBLE_SURRENDER = new ArrayList<String>(Arrays.asList("New Game","Hit","Stand", "Double Down","Surrender"));
	
	public static final String [] FIRST_PROMPT = new String[] {"Play", "Exit" };
	public static final String [] YES_OR_NO = new String[] {"Yes", "No" };
	public static final String [] HIT_OR_STAND = new String[] {"Hit", "Stand" };
	public static final String [] HIT = new String[] {"Hit", "Continue Hand" };
	public static final String [] HIT_OR_STAND_OR_SPLIT = new String[] {"Hit", "Stand","Split"};
	public static final String PUSH = "Push!";
	public static final String INSUFFICIENT_FUNDS = "Insufficient funds!";
	public static final String ENTER_BET = "Place your bet!";
	public static final String SELECTION_PROMPT = "Please select from the following: ";
	public static final String OPTION_NOT_AVAIL = "Option not available";
	public static final String OPTION_NA_TRY_AGAIN = OPTION_NOT_AVAIL + ", try again.";
	public static final String ENTER_CHOICE = "Enter choice: ";
	public static final String ENTER_AMOUNT = "Enter desired amount: ";
	public static String amountReminder(BigDecimal amount) {
		return "You have " + amount + " available.";
	} 
	public static final Map<String, Integer> optionMap = Map.of(
		BJOption.NEW_GAME.getCap(), 0,
		BJOption.HIT.getCap(), 1,
		BJOption.STAND.getCap(), 2,
		BJOption.SPLIT.getCap(), 3,
		BJOption.DOUBLE_DOWN.getCap(), 4,
		BJOption.SURRENDER.getCap(), 5,
		BJOption.EXIT.getCap(), 6
	);
	
}
