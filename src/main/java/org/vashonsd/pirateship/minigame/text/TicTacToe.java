package org.vashonsd.pirateship.minigame.text;

import java.util.*;

public class TicTacToe implements TextMinigame {

	public int[][] board;
	public boolean playerWin;
	public boolean computerWin;
	
	public TicTacToe() {
		super();
		playerWin = false;
		computerWin = false;
		board = new int[3][3];
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                board[i][j] = 0;  
            }
        }
		setUpGame();
	}
	
	private void setUpGame() {
		// TODO Auto-generated method stub
		//Make board
		printBoard();
		
	}

	public String Run() {
		// TODO Auto-generated method stub

		return "Where would you like to place a piece? Ex. --> row, column";

	}

	public String getPrompt() {

		return "TicTacToe";
	}

	//Get move
	public String Handle(String s) {
		
		String testOne = Character.toString(s.charAt(0)); 
		String testTwo = Character.toString(s.charAt(2));
		
		
		//make sure input is a number 
		try {
			Integer.parseInt(testOne);
			Integer.parseInt(testTwo);
		} catch (NumberFormatException err) {
			return "Sorry, I don't recognize that move. Ex. 1,2 ";
		}
		


		
		//PLAYER TURN
		
		//check row and col are a numbers 1,3
		int row = Character.getNumericValue(s.charAt(0));
		
		int col = Character.getNumericValue(s.charAt(2));
		
		if(row < 1 || row > 3 || col < 1 ||  col > 3)
		{
			return "Numbers must be between 1 and 3";
		}

		//Add move to board and print
		setVal(row - 1, col-1, 1);	
		printBoard();
		
		// COMPUTER TURN
		
		//Get random numbers for the computer turn
		Random rnd = new Random();
		int rndRow = rnd.nextInt(3);
		int rndCol = rnd.nextInt(3);
		
		System.out.println("My turn:");
		
		//Make move is not taken
		while(board[rndRow][rndCol] ==1 || board[rndRow][rndCol] ==2)
		{
			rndRow = rnd.nextInt(3);
			rndCol = rnd.nextInt(3);
		}
		
		//Add to board and print
		setVal(rndRow, rndCol,2);
		
		printBoard();
		
		
		//Check for Winners and return a message to user
		playerWins();
		computerWins();
		
		if(playerWin == true)
		{
			newBoard();
			System.out.println("You Won! I'm ready to play again. Here's a new board");
			printBoard();
			return "What is your move? Ex. 1,3 ";
		}
		else if(computerWin == true)
		{
			newBoard();
			System.out.println("I Won! I'm ready to play again. Here's a new board");
			printBoard();
			return "What is your move? Ex. 1,3 ";
		}
		else
		{
			return "I have set a piece! Your turn.";
		}
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Thanks for playing";
	}
	
	
	
	
	
	
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	//If player wins reset game
	
	//New Board
	public void newBoard()
	{
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                board[i][j] = 0;  
            }
        }
	}
	
	
	//Check for player win
	public void playerWins()
	{
		for(int i=0; i<3; i++)
		{
			if(board[i][0]==1 && board[i][1]==1 && board[i][2]==1)
			{
				playerWin = true;
			}
			if(board[0][i]==1 && board[1][i]==1 && board[2][i]==1)
			{
				playerWin = true;
			}
		}
		
		if(board[0][0]==1 && board[1][1]==1 && board[2][2]==1)
		{
			playerWin = true;
		}
		if(board[0][2]==1 && board[1][1]==1 && board[2][0]==1)
		{
			playerWin = true;
		}
	}
	
	//check for computer win
	public void computerWins()
	{
		for(int i=0; i<3; i++)
		{
			if(board[i][0]==2 && board[i][1]==2 && board[i][2]==2)
			{
				computerWin = true;
			}
			if(board[0][i]==2 && board[1][i]==2 && board[2][i]==2)
			{
				computerWin = true;
			}
		}
		
		if(board[0][0]==2 && board[1][1]==2 && board[2][2]==2)
		{
			computerWin = true;
		}
		if(board[0][2]==2 && board[1][1]==2 && board[2][0]==2)
		{
			computerWin = true;
		}
	}
	
	
	//Print to board
	public String printNum(int val)
	{
		if(val==0)
		{
			return "-";
		}
		else if(val==1)
		{
			return "X";
		}
		else
		{
			return "0";
		}
	}
	
	public void setVal(int row, int col, int val)
	{
		board[row][col] = val;
	}
	
	public int getVal(int row, int col)
	{
		return board[row][col];
	}
	
	
    public void printBoard()
    {
        //Print header
        System.out.println(" ");
        for(int i = 0; i<4; i++)
        {
            if(i==0)
            {
                System.out.print("  ");
            }
            else
            {
                System.out.print(" " + i);
            }
        }
        System.out.println("");
        //make an array for the letters on the side
        String[] arr = {"1 ", "2 ", "3 "};
        
        //Print Grid
        for(int i=0; i<3; i++)
        {
            System.out.println("");
            System.out.print(arr[i]);
            
            for(int j=0; j<3; j++)
            {
                System.out.print(" " + printNum(getVal(i, j)));
            }
        }
        
        System.out.println("");
    }
	
}


