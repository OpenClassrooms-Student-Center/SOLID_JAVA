package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;

public interface GameViewable {
	public void setController(GameController controller);
	
	void promptForPlayerName();
	void showPlayerName(int playerIndex, String name);
	
	void showFaceDownCardForPlayer(int playerIndex, String name);
	
	void promptForFlip();
	void showCardForPlayer(int playerIndex, String name, String rank, String suit);
	void showWinner (String winnerName);
	
	void promptForNewGame();
}
