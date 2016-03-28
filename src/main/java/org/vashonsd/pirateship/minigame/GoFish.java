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
	private int turn;
	private int n;
	private Card fish;
	private ArrayList<Card> askedFor;
	private boolean winCondition;
	
	
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
		checkPairs(hand);
		dealHand(otherHand);
		checkPairs(otherHand);
		score = 0;
		n = 0;
		fish = new Card(0, 'F');
		askedFor = new ArrayList<Card>();
		winCondition = false;
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
		
		if(hand.isEmpty() || otherHand.isEmpty())
		{
			winCondition = true;
			breakCondition = false;
		}
		
		String winner = "No winner";
		String toReturn = "";
		
		if(turn == COMPUTER_TURN && winCondition == false)
		{
			Card c = otherHand.cardAt(Randomizer.nextInt(otherHand.getList().size()));
			
			for(int i=askedFor.size(); i>askedFor.size(); i--)
			{
				Card q = askedFor.get(i);
				
				if(otherHand.hasCard(q))
				{
					c = q;
				}
			}
			
			if(hand.hasCard(c))
			{
				hand.removeCardByRank(c);
				otherHand.addCard(c);
				otherHand.addPair(c);
				checkPairs(otherHand);
				turn = PLAYER_TURN;
				
				if(winCondition == false)
				{
					toReturn = "Computer asked for a " + c.getRankName() + ". Computer got a pair. Computer has " + otherHand.getSize() + " cards in its hand \n" + "Your turn, ask for a card. Hand: ( " + hand.gofishToString() + " )";
				}
				else if(winCondition == true)
				{
					toReturn = "Computer asked for a " + c.getRankName() + ". Computer got a pair. Computer has " + otherHand.getSize() + " cards in its hand \n";
				}
			}
			else
			{
				fish = deck.deal();
				goFish(otherHand, fish);
				turn = PLAYER_TURN;
				
				if(winCondition == false)
				{
					toReturn = "Computer asked for a " + c.getRankName() + ". Computer goes fish. Computer has " + otherHand.getSize() + " cards in its hand \n" + "Your turn, ask for a card. Hand: ( " + hand.gofishToString() + " )";
				}
				else if (winCondition == true)
				{
					toReturn = "Computer asked for a " + c.getRankName() + ". Computer goes fish. Computer has " + otherHand.getSize() + " cards in its hand \n";
				}
			}
			
			return toReturn;
		}
		
		for(Card c: hand.getList())
		{
			if(s.equals(c.getRankName()))
			{
				breakCondition = false;
				fish = nameToCard(s);
			}
		}
		
		if(breakCondition == true)
			return "You must choose a card from your hand.";
		
		if(turn == PLAYER_TURN && winCondition == false)
		{
			if(otherHand.hasCard(fish))
			{
				otherHand.removeCardByRank(fish);
				hand.addCard(fish);
				askedFor.add(fish);
				hand.addPair(fish);
				checkPairs(hand);
				turn = COMPUTER_TURN;
				
				if(winCondition == false)
				{
					toReturn = "You got a pair! Hand: ( " + hand.gofishToString() + " ) \n" + "Enter for Computer's turn.";
				}
				else if(winCondition == true)
				{
					toReturn = "You got a pair! Hand: ( " + hand.gofishToString() + " ) \n";
				}
			}
			else
			{
				askedFor.add(fish);
				fish = deck.deal();
				goFish(hand, fish);
				turn = COMPUTER_TURN;
				
				if(winCondition == false)
				{
					toReturn = "Go Fish. You drew a " + fish.getRankName() + ". \nHand: ( " + hand.gofishToString() + " ) \n" + "Enter for Computer's turn.";
				}
				else if(winCondition == true)
				{
					toReturn = "Go Fish. You drew a " + fish.getRankName() + ". \nHand: ( " + hand.gofishToString() + " ) \n";
				}
			}
			return toReturn;
		}
		
		if(turn == PLAYER_TURN)
		{
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
		}
		else if(turn == COMPUTER_TURN)
		{
			if(otherHand.isEmpty())
			{
				winner = "Computer wins.";
				score = 0 - otherHand.getPairs().size();
			}
			
			if(hand.isEmpty())
			{
				winner = "Player wins!";
				score = hand.getPairs().size();
			}
		}
		
		setUpGame();
		return winner + " Score: " + score + "\nWould you like to play again?";
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Thanks for playing, you quitter you! \n";
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
		
		if(other.isEmpty())
			winCondition = true;
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
	
	public Card nameToCard(String s)
    {
		String[] rankStrings = {"X", "X", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
    	String str = "";
    	Card c = new Card(0, 'A');
    	
    	for(int i=0; i<rankStrings.length; i++)
    	{
    		 str = rankStrings[i];
    		 
    		 if(s.equals(str))
    		 {
    			 c.setRank(i);
    		 }
    	}
    	
    	return c;
    }
}
