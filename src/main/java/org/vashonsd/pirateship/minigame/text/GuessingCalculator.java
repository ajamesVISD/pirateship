package org.vashonsd.pirateship.minigame.text;

import java.util.Random;

public class GuessingCalculator implements TextMinigame 
{	
	private int intOne;
	private int intTwo;
	
	public GuessingCalculator() 
	{
		super();
		setUpGame();
	}
	
	private void setUpGame() 
	{
		Random randomOne = new Random();
		Random randomTwo = new Random();
		
		intOne = randomOne.nextInt(1000) + 1;
		intTwo = randomTwo.nextInt(1000) + 1;
	}
	
	public String Run() 
	{
		return greeting();
	}
	
	public String greeting()
	{
		return "What is the sum of " + intOne + " and " + intTwo + "?";
	}
	
	public String getPrompt() 
	{
		// TODO Auto-generated method stub
		return "Guessing Calculator";
	}

	public String Handle(String s) 
	{
		int answer = intOne + intTwo;
		int guess;
		
		//First let's see if it's a number.
		try
		{
			guess = Integer.parseInt(s);
		} 
		
		catch (NumberFormatException err) 
		{
			return "Sorry, you have to enter a number.";
		}
		
		String response = "";

		if(guess == answer)
		{

			//run game again
			//how in the heck do i run the game again?
			
			response = "Yes! " + guess + " is the sum of " + intOne + " and " + intTwo + ". Good job!";
			setUpGame();
			response += "\n" + greeting();
			//return "Yes! " + answer + " is the sum of " + intOne + " and " + intTwo + ". Good job!";
			
		}
		
		else
		{
			response = "Nope, " + guess + " is not the answer. Try again!";
		}
		
		return response;
	}

	public String Exit() 
	{
		// TODO Auto-generated method stub
		return "Thanks for playing!";
	}

}
