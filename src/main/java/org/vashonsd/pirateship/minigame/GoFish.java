package org.vashonsd.pirateship.minigame;

import org.vashonsd.pirateship.minigame.playingcards.*;
import java.io.IOException;
import java.util.*;
import org.vashonsd.pirateship.io.*;

public class GoFish implements Minigame {
	private static final int PLAYER_TURN = 0;
	private static final int COMPUTER_TURN = 1;
	
	private Hand hand;
	private Hand otherHand;
	private Deck deck;
	private int score;
	// Player turn = 0, Computer Turn = 1
	private int turn;
	private int n;
	private Card fish;
	
	
	public GoFish() 
	{
		super();
		setUpGame();
	}

	public void setUpGame() 
	{
		turn = PLAYER_TURN;
		deck = new Deck();
		deck.shuffle();
		hand = new Hand();
		otherHand = new Hand();
		dealHand(hand);
		System.out.println(hand.gofishToString());
		checkPairs(hand);
		dealHand(otherHand);
		checkPairs(otherHand);
		score = 0;
		n = 0;
		fish = new Card(0, 'F');
	}
	
	public String Run() 
	{
		return "Let's play Go Fish, ask for a card. Hand: ( " + hand.gofishToString() + " )";
	}

	public String getPrompt() {
		// TODO Auto-generated method stub
		return "Go Fish";
	}
	
	public String Handle(String s)
	{
		boolean breakCondition = true;
		boolean winCondition = false;
		
		if(hand.isEmpty() || otherHand.isEmpty())
			winCondition = true;
		
		String winner = "No winner";
		
		if(turn == COMPUTER_TURN && winCondition == false)
		{
			Card c = otherHand.cardAt(Randomizer.nextInt(otherHand.getList().size()));
			
			if(hand.hasCard(c))
			{
				hand.removeCardByRank(c);
				otherHand.addCard(c);
				otherHand.addPair(c);
				checkPairs(otherHand);
				turn = PLAYER_TURN;
				return "Computer asked for a " + c.getRankName() + ". Computer got a pair. \n" + "Your turn, ask for a card. Hand: ( " + hand.gofishToString() + " )";
			}
			else
			{
				fish = deck.deal();
				goFish(otherHand, fish);
				turn = PLAYER_TURN;
				return "Computer asked for a " + c.getRankName() + ". Computer goes fish. \n" + "Your turn, ask for a card. Hand: ( " + hand.gofishToString() + " )";
			}
		}
		
		for(Card c: hand.getList())
		{
			if(s.equals(c.getRankName()))
			{
				breakCondition = false;
			}
		}
		
		if(breakCondition == true && winCondition == false)
			return "You must choose a card from your hand.";
		
		if(turn == PLAYER_TURN && winCondition == false)
		{
			for(Card c: otherHand.getList())
			{
				if(s.equals(c.rankToString()))
				{
					otherHand.removeCardByRank(c);
					hand.addCard(c);
					hand.addPair(c);
					checkPairs(hand);
					turn = COMPUTER_TURN;
					return "You got a pair! Hand: ( " + hand.gofishToString() + " ) \n" + "Enter for Computer's turn.";
				}
			}
			
			fish = deck.deal();
			goFish(hand, fish);
			turn = COMPUTER_TURN;
			return "Go Fish. You drew a " + fish.getRankName() + ". \nHand: ( " + hand.gofishToString() + " ) \n" + "Enter for Computer's turn.";
		}
		
		if(hand.isEmpty())
		{
			winner = "Player wins!";
			score = hand.getPairs().size();
		}
		
		if(otherHand.isEmpty())
		{
			winner = "Computer wins.";
			score = 0 - otherHand.getPairs().size();
		}
		
		setUpGame();
		return winner + "Score: " + score;
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Thanks for playing, you quitter you!";
	}
	
	public void dealHand(Hand other)
	{
		for(int i=0; i<6; i++)
			other.addCard(deck.deal());
	}
	
	public void checkPairs(Hand other)
	{
		for(int i=0; i<other.getSize(); i++)
		{
			n = checkDuplicates(other.getList(), i);
			other.removePair(n);
		}
	}
	
	public int checkDuplicates(ArrayList<Card> cards, int k)
	{
		Card checkFor = cards.get(k);
		ArrayList<Card> checkFrom = new ArrayList<Card>();
		checkFrom = cards;
		
		for(Card c: checkFrom)
		{
			if(checkFor.getRank() == c.getRank() && c.getSuit() != checkFor.getSuit())
			{
				return checkFor.getRank();
			}
		}
		
		return 15;
	}
	
	public void goFish(Hand other, Card c)
	{
		other.addCard(c);
		checkPairs(other);
	}
	
}
