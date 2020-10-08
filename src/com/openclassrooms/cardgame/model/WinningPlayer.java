package com.openclassrooms.cardgame.model;

public class WinningPlayer implements IPlayer {
	IPlayer winner;
	
	public WinningPlayer (IPlayer player) {
		winner = player;
	}

	public String getName() {
		return "***** " + winner.getName() + " *****";
	}

	@Override
	public void addCardToHand(PlayingCard pc) {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayingCard getCard(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayingCard removeCard() {
		// TODO Auto-generated method stub
		return null;
	}

}
