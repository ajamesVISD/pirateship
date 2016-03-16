package org.vashonsd.pirateship.minigame;

import java.util.*;
import java.util.Random;

public class MathGame implements Minigame {
	private int firstNumber;
	private int secondNumber;
	private int answer;
	private char sign;
	private int correctProblems;
	private int totalProblems;
	
	public MathGame() {
		super();
		setUpGame();
	}
	
	private void setUpGame() {
		Random rnd = new Random();
		rnd.setSeed(System.nanoTime());
		
		Random rsd = new Random();
		int g = rsd.nextInt(3);
		if (g == 0) {
			firstNumber = rnd.nextInt(100) + 1;
			secondNumber = rnd.nextInt(100) + 1;
			answer = firstNumber + secondNumber;
			sign = '+';
		} if (g == 1) {
			firstNumber = rnd.nextInt(100) + 1;
			secondNumber = rnd.nextInt(100) + 1;
			answer = firstNumber - secondNumber;
			sign = '-';
		} if (g == 2) {
			firstNumber = rnd.nextInt(10) + 1;
			secondNumber = rnd.nextInt(10) + 1;
			answer = firstNumber * secondNumber;
			sign = 'x';
		} if (g == 3) {
			answer = firstNumber / secondNumber;
			sign = '/';
		}
		
	}
	
	public String Run() {
		return "What is " + firstNumber + " " + sign + " " + secondNumber + "?";
	}
	
	public String Handle(String s) {
		// TODO Auto-generated method stub
		
		int a;
		try {
			a = Integer.parseInt(s);
		} catch (NumberFormatException err) {
			return "Sorry, you have to enter a number.";
		}
		int lastAnswer = answer;
		if (!(a == answer)) {
			totalProblems++;
			setUpGame();
			return "Wrong, " + s + " is not the answer. The answer was " + lastAnswer + ". \n" + Run();
		} else if (!(a == answer)) 
			totalProblems++;
			correctProblems++;
			setUpGame();
			return "Correct, " + s + " is the answer.\n" + Run();
		}
	
	
	public String findPercentage(int c, int t) {
		if (t <= 0) {
			return "Error finding the percent."; 
		} else {
			double r = (double)c / ((double)t+1);
			double y = r * 100;
			return "" + Math.round(y) + "% of the problems were answered correct.";
		}
	}
	
	public String getPrompt() {
		return "Math";
	}

	public String Exit() {
		// TODO Auto-generated method stub
		return "Thanks for doing Math. " + findPercentage(correctProblems, totalProblems);
	}
}
