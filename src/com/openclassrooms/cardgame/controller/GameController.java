package com.openclassrooms.cardgame.controller;

import java.util.ArrayList;

import com.openclassrooms.cardgame.games.GameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.model.WinningPlayer;
import com.openclassrooms.cardgame.view.GameViewable;
import com.openclassrooms.cardgame.view.GameViewables;


public class GameController {
	enum GameState {
		AddingPlayers,
		CardsDealt,
		WinnerRevealed,
		AddingView
	}
	
	Deck deck;
	ArrayList<IPlayer> players;
	IPlayer winner;
	GameViewables views;
	GameEvaluator evaluator;
	GameState gameState;
	
	public GameController(GameViewable view, Deck deck, GameEvaluator evaluator) {
		views = new GameViewables();
		this.deck = deck;
		this.evaluator = evaluator;
		players = new ArrayList<IPlayer>();
		gameState = GameState.AddingPlayers;
		addViewable(view);
	}

	public void addViewable(GameViewable newView) {
		GameState curState = gameState;
		gameState = GameState.AddingView;
		newView.setController(this);
		views.addViewable(newView);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameState = curState;
	}
	
	public void run() {
		while (true) {
			switch (gameState) {
				case AddingPlayers:
					views.promptForPlayerName();
					break;
				case CardsDealt:
					views.promptForFlip();
					break;
				case WinnerRevealed:
					views.promptForNewGame();
					break;
				case AddingView:
					break;
			}
		}
	}
	
	public void addPlayer(String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player (playerName));
			views.showPlayerName(players.size(), playerName);
		}
	}
	
	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for (IPlayer player : players) {
				player.addCardToHand(deck.removeTopCard());
				views.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
	}
	
	public void flipCards() {
		int playerIndex = 1;
		for (IPlayer player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			views.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
		}
		
		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
	}

	public void restartGame() {
		rebuildDeck();
		gameState = GameState.AddingPlayers;
	}
	
	void evaluateWinner() {
		winner = new WinningPlayer(evaluator.evaluateWinner(players));
	}
	
	void displayWinner() {
		views.showWinner(winner.getName());
	}
	
	void rebuildDeck() {
		for (IPlayer player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
};

