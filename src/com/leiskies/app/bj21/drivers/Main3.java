package com.leiskies.app.bj21.drivers;

import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import com.leiskies.app.bj21.constants.IOShop;
import com.leiskies.app.bj21.enums.Input;
import com.leiskies.app.bj21.utilities.Calculator;
import com.leiskies.app.bj21.utilities.InputTaker;

public class Main3 {
	public static void main(String[] args) {
		int maxLen = Calculator.getMaxLen(IOShop.HIT_STAND_SPLIT_DOUBLE_SURRENDER);
		//System.out.println(maxLen);
		Scanner scanner = new Scanner(System.in);
		List<String> list = IOShop.HIT_STAND_SPLIT_DOUBLE_SURRENDER;

		String format = "|%-30s|";
		StringBuilder sb = new StringBuilder();
		Formatter fmt = new Formatter(sb);
		
		
		InputTaker.getInputFrom
		(scanner, "", IOShop.HIT_STAND_SPLIT_DOUBLE_SURRENDER, Input.ONE_OPT_NEXT_LINE, true);
		
		
		
		//InputTaker.getInputFrom(scanner, "", IOShop.HIT_STAND_SPLIT_DOUBLE_SURRENDER, Input.ONE_OPT_ONE_LINE, true);
	}
} 
