package com.leiskies.app.bj21.utilities;

import java.util.List;
import java.util.Scanner;

import com.leiskies.app.bj21.constants.IOShop;
import com.leiskies.app.bj21.enums.Input;

public interface InputTaker {
	public static Integer getInputFrom(Scanner scanner, String question, List<String> options, String failCaseMessage) {
		Boolean wrongInput = true; 
		String instructUser = null;
		String promptAnswer = null;
		String tryAgain = null; 
		Integer answer = null;
		String input = null;
		if(question==null) {
			question = "";
		}
		if(scanner==null) {
			scanner = new Scanner(System.in);
		} 
		if(failCaseMessage==null) {
			failCaseMessage = "";
		} else { 
			failCaseMessage = "\n"+failCaseMessage;
		}
		promptAnswer = IOShop.ENTER_CHOICE;
		tryAgain = IOShop.OPTION_NA_TRY_AGAIN;
		if(options.size()<4) {
			instructUser = IOShop.SELECTION_PROMPT;
		} else {
			instructUser = "\n"+IOShop.SELECTION_PROMPT;
		}	
		if(!question.isBlank()) {
			System.out.println(question);
		}
		
		while(wrongInput) {
			
			System.out.println(instructUser);
			for (int i = 0; i < options.size(); i++) {
				int menuNumber = i + 1;
				if(options.size() <4 ) {
					System.out.print(options.get(i) + "["+menuNumber+"]" + " ");
					if(i==options.size()-1) {
						System.out.println();
					}
				} else {
					System.out.println("[" + menuNumber + "] " + options.get(i));
				}
			}	
			System.out.print(promptAnswer);
			input = scanner.nextLine().trim();
			
			if(!input.matches("^[1-"+String.valueOf(options.size())+"]$" )) {			
				System.out.println("\n" + tryAgain + failCaseMessage);		
			} else {
				if(Integer.valueOf(input)>options.size()) {
					System.out.println("\n" + tryAgain + failCaseMessage);
				} else {
					wrongInput = false;
					
					answer = IOShop.optionMap.get(options.get(Integer.parseInt(input)));
				}
			}
		}	return answer;
	}
	public static Integer getInputFrom(Scanner scanner, String question, List<String> options, Input promptFmt, boolean numLeft) {
		Boolean wrongInput = true; 
		String instructUser = null;
		String promptAnswer = null;
		String tryAgain = null; 
		Integer answer = null;
		String format = null;
		String input = null;
		String msg = null;
		if(question==null) {
			question = "";
		}
		if(scanner==null) {
			scanner = new Scanner(System.in);
		} 
		
		format = "%"+(Calculator.getMaxLen(options)+5)+"s";
		
		
		promptAnswer = IOShop.ENTER_CHOICE;
		tryAgain = IOShop.OPTION_NA_TRY_AGAIN;
		if(!question.isBlank()) {
			System.out.println(question);
		}	instructUser = "\n"+IOShop.SELECTION_PROMPT;
		
		
		
		while(wrongInput) {	
			System.out.println(instructUser);
			for (int i = 0; i < options.size(); i++) {
				if(numLeft) {
					msg = options.get(i) + "[" + i + "]";
				}	else {
					msg = "[" + i + "]" + options.get(i);	
				}
				switch(promptFmt) {
					case ALL_OPT_ONE_LINE:
						System.out.print(String.format(format, msg));
						break;
					case ONE_OPT_FIVE_NEXT_LINE:
						if(i==0 || i%5==0|| i==options.size()-1) {
							System.out.println(String.format(format, msg));
						}	else {
							System.out.print(String.format(format, msg));
						}
						break;
					case ONE_OPT_FOUR_NEXT_LINE:
						if(i==0 || i%4==0|| i==options.size()-1) {
							System.out.println(String.format(format, msg));
						}	else {
							System.out.print(String.format(format, msg));
						}
						
						break;
					case ONE_OPT_NEXT_LINE:
						if(i==0 || i==options.size()-1) {
							System.out.println(String.format(format, msg));
						}	else {
							System.out.print(String.format(format, msg));
						}
						break;
					case ONE_OPT_ONE_LINE:
						System.out.println(String.format(format, msg));
						break;
					default:
						break;
				}
			}
				
			System.out.print(promptAnswer);
			input = scanner.nextLine().trim();
			
			if(!input.matches("^[0-" + String.valueOf(options.size()-1) + "]$")) {			
				System.out.print(tryAgain + "\n");		
			} else {
				wrongInput = false;
				answer = Integer.parseInt(input);
			}
		}	return answer;
	}
	public static Integer getInputFrom(Scanner scanner, String question, String[] options, String failCaseMessage) {
		Boolean wrongInput = true;
		String instructUser = null;
		String promptAnswer = null;
		String tryAgain = null;
		Integer answer = null;
		String input = null;
		if(question==null) {
			question = "";
		}
		if(scanner==null) {
			scanner = new Scanner(System.in);
		}
		if(failCaseMessage==null) {
			failCaseMessage = "";
		} else {
			failCaseMessage = "\n"+failCaseMessage;
		}
		promptAnswer = IOShop.ENTER_CHOICE;
		tryAgain = IOShop.OPTION_NA_TRY_AGAIN;
		if(options.length<4) {
			instructUser = IOShop.SELECTION_PROMPT;
		} else {
			instructUser = "\n"+IOShop.SELECTION_PROMPT;
		}	
		if(!question.isBlank()) {
			System.out.println(question);
		}
		
		while(wrongInput) {
			
			System.out.println(instructUser);
			for (int i = 0; i < options.length; i++) {
				int menuNumber = i + 1;
				if(options.length <4 ) {
					System.out.print(options[i] + "["+menuNumber+"]" + " ");
					if(i==options.length-1) {
						System.out.println();
					}
				} else {
					System.out.println("[" + menuNumber + "] " + options[i]);
				}
			}	
			System.out.print(promptAnswer);
			input = scanner.nextLine().trim();
			
			if(!input.matches("^[1-"+String.valueOf(options.length)+"]$" )) {			
				System.out.println("\n" + tryAgain + failCaseMessage);		
			} else {
				if(Integer.valueOf(input)>options.length) {
					System.out.println("\n" + tryAgain + failCaseMessage);
				} else {
					wrongInput = false;
					answer = Integer.parseInt(input);
				}
			}
		}	
		return answer;
	}
}
