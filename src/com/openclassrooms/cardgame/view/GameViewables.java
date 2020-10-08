package com.openclassrooms.cardgame.view;

import java.util.Vector;

import com.openclassrooms.cardgame.controller.GameController;

public class GameViewables implements GameViewable {
	Vector<GameViewable> views;
	
	public GameViewables () {
		views = new Vector<GameViewable> ();
	}
    
    public void addViewable (GameViewable view) {
        views.add(view);
    }

	@Override
	public void setController(GameController controller) {
        for (GameViewable view : views) {
            view.setController(controller);
        }
	}

	@Override
	public void promptForPlayerName() {
		for (GameViewable view : views) {
			view.promptForPlayerName();
		}
	}

	@Override
	public void showPlayerName(int playerIndex, String name) {
		for (GameViewable view : views) {
			view.showPlayerName(playerIndex, name);
		}
	}

	@Override
	public void showFaceDownCardForPlayer(int playerIndex, String name) {
		for (GameViewable view : views) {
			view.showFaceDownCardForPlayer(playerIndex, name);
		}
	}

	@Override
	public void promptForFlip() {
		for (GameViewable view : views) {
			view.promptForFlip();
		}
	}

	@Override
	public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
		for (GameViewable view : views) {
			view.showCardForPlayer(playerIndex, name, rank, suit);
		}
	}

	@Override
	public void showWinner(String winnerName) {
		for (GameViewable view : views) {
			view.showWinner(winnerName);
		}
	}

	@Override
	public void promptForNewGame() {
		for (GameViewable view : views) {
			view.promptForNewGame();
		}
	}
}
