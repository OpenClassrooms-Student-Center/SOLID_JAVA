package com.openclassrooms.cardgame.model;

public interface IPlayer {
	String getName();
	void addCardToHand(PlayingCard pc);
	PlayingCard getCard(int index) ;
	PlayingCard removeCard();
}
