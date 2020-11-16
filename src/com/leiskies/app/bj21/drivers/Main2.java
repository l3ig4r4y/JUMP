package com.leiskies.app.bj21.drivers;

import java.util.List;
import java.util.Scanner;

import com.leiskies.app.bj21.entities.BJItemShop;
import com.leiskies.app.bj21.entities.CardPlayer;
import com.leiskies.app.bj21.entities.Hand;
import com.leiskies.app.bj21.enums.Render;
import com.leiskies.app.bj21.enums.Show;
import com.leiskies.app.bj21.enums.Size;
import com.leiskies.app.bj21.utilities.BJMechanics;
import com.leiskies.app.bj21.utilities.Renderer;
import com.leiskies.app.bj21.utilities.Settings;

public class Main2 {
	
	static Scanner scanner = new Scanner(System.in);
	static String bar = "_____________________________________________";
	public static void main(String[] args) {
		System.out.println("WELCOME TO BJ21"); 
		System.out.println();
		System.out.println();
		List<CardPlayer> players = BJItemShop.getBJPlayers(1);
		//Hand fullDeck = BJItemShop.getFullDeck(true);
		Hand fullDeck = BJItemShop.getTestDeckSameValues(4);
		BJMechanics.getPlayersBets(scanner, players);
		System.out.println(bar);
		Settings settings = new Settings(Size.SMALL, Show Render.CLOSE);
	
		for(int i = 0; i < 2; i++) {
			BJMechanics.dealCardToPlayers(players, fullDeck);
		}	Renderer.renderDecks(players, Size.SMALL, Show.ALL, Render.LOOSE);
		System.out.println(bar);
		boolean playable = true;
		
		while(playable) {
			for (int i = 0; i < players.size(); i++) {
				for (int j = 0; j < players.get(i).getDeck().size(); j++) {
					playable = BJMechanics.assess
							
					(scanner, players, players.get(i), players.get(i).getDeck().get(j), fullDeck);
					if(playable) {
						Renderer.renderDecks(players, Size.SMALL, Show.ALL, Render.LOOSE);
						System.out.println(bar);
					}
				}
			}	
			if(!playable) {
				Renderer.renderAll(players, Size.SMALL, Show.ALL, Render.LOOSE);
				
			}
		}
}
}
