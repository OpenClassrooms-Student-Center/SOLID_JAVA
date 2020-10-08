package com.openclassrooms.cardgame;

import com.openclassrooms.cardgame.controller.DeckFactory;
import com.openclassrooms.cardgame.controller.DeckFactory.DeckType;
import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.games.HighCardGameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.view.GameSwing;

public class CardGame {

	public static void main(String[] args) {
		// Deck deck = new Deck();
		// debugDeck(deck);
		// GameController gc = new GameController (new CommandLineView(), new Deck(), new HighCardGameEvaluator());
		GameSwing gs = new GameSwing();
		gs.createAndShowGUI();
		GameController gc = new GameController (gs, DeckFactory.makeDeck(DeckType.Normal), new HighCardGameEvaluator());
		// gc = new GameController (gs, new TestDeck(), new HighCardGameEvaluator());
		gc.run();
		
		/*
		gc.addPlayer("Elizabeth");
		gc.addPlayer("Helen");
		gc.addPlayer("Myles");
		for (int i = 0; i < 100; ++i) {
			gc.startGame();
			gc.flipCards();
		}
		*/
	}

	static void debugDeck(Deck deck) {
		for (int i = 0; i < 52; ++i) {
			PlayingCard pc = deck.removeTopCard();
			System.out.println("This card: " + pc);
			deck.returnCardToDeck(pc);
		}		
	}
}

