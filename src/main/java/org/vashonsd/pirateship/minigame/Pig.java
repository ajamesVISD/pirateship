package org.vashonsd.pirateship.minigame;

import java.util.*;

import org.vashonsd.pirateship.minigame.speech.*;

public class Pig {
	// The warden's graphic and name
	private String pigPrint;
		
	// This stores the level of friendliness you have with the warden
	// Choices in-game can make this go up or down
	private int fLevel = 0;
	public static int MAXLEVEL = 10;
	public static int LOWLEVEL = -10;
	
	private int question;
	public static int MAXQUES = 20;
	
	// Current pigs response prompts
	private SpeechBehavior speech;
	
	public static ArrayList<SpeechBehavior> pigSpeeches = new ArrayList<SpeechBehavior> ();
	
	static {
		pigSpeeches.add(new SassSpeech());
		pigSpeeches.add(new LazySpeech());
		pigSpeeches.add(new BoringSpeech());
		pigSpeeches.add(new CrazySpeech());
		pigSpeeches.add(new JockSpeech());
		pigSpeeches.add(new NerdSpeech());
		pigSpeeches.add(new ShySpeech());
	}
	
	public Pig() {
		Random ran = new Random();
		int x = ran.nextInt(pigSpeeches.size());
		speech = pigSpeeches.get(x);
	}
	
	// Provides reaction to any question asked
	public String React(String s) {
		fLevel += speech.getFLevelChange(s);
		speech.voidFLevel(s);
		
		String response = "PIG: ";
		response += "\"" +  speech.getResponse(s) + "\"";
		
		return response;
	}
	
	public String getBeginningSpeech() {
		String intro = "";
		intro += pigPrint + "\n";
		intro += "PIG: \"" + speech.getIntro() + "\"";
		return intro;
	}
	
	public String getEndSpeech() {
		String outro = "";
		outro += pigPrint + "\n" + "PIG: \"";
		if (fLevel >= MAXLEVEL) {
			outro += speech.getOutro();
		}
		else if (question >= MAXQUES || fLevel <= LOWLEVEL) {
			outro += "Whoops, your questions are up. Time to die.";
		}
		outro += "\"\n\n\n";
		return outro;
	}
	
	/*
	 * Changes pig orientation if needed
	 */
	public String changeOrientation() {
		String response = "";
		if (fLevel <= -5 && pigPrint.equals(getPigPrintFront())) {
			setPigPrintBack();
			response += "\n\n" + pigPrint + "\n";
			response += "PIG is so disgusted with you, he can't even look at you.\n";
		}
		else if (fLevel >= 0 && pigPrint.equals(getPigPrintBack())) {
			setPigPrintFront();
			response += "\n\n" + pigPrint + "\n";
			response += "PIG is willing to look at you again.\n";
		}
		return response;
	}
	
	/*
	 * Sets/gets different graphics for the warden
	 */
	public void setPigPrintFront() {
		pigPrint = "";
		pigPrint += "\n  __   __\n";
		pigPrint += "  \\/---\\/\n";
		pigPrint += "   ). .(\n";
		pigPrint += "  ( (\") )\n";
		pigPrint += "   )   (\n";
		pigPrint += "  /     \\\n";
		pigPrint += " (       )\n";
		pigPrint += "( \\ /-\\ / )\n";
		pigPrint += " w'W   W'w";
	}
	
	public void setPigPrintBack() {
		pigPrint = "";
		pigPrint += "\n  __   __\n";
		pigPrint += "  \\_/-\\_/\n";
		pigPrint += "   )   (\n";
		pigPrint += "  (     )\n";
		pigPrint += "   )   (\n";
		pigPrint += "  /     \\\n";
		pigPrint += " (   9   )\n";
		pigPrint += "(_\\_____/_)";
	}
	
	private String getPigPrintFront() {
		String pigPrint = "";
		pigPrint += "\n  __   __\n";
		pigPrint += "  \\/---\\/\n";
		pigPrint += "   ). .(\n";
		pigPrint += "  ( (\") )\n";
		pigPrint += "   )   (\n";
		pigPrint += "  /     \\\n";
		pigPrint += " (       )\n";
		pigPrint += "( \\ /-\\ / )\n";
		pigPrint += " w'W   W'w";
		return pigPrint;
	}
	
	private String getPigPrintBack() {
		String pigPrint = "";
		pigPrint += "\n  __   __\n";
		pigPrint += "  \\_/-\\_/\n";
		pigPrint += "   )   (\n";
		pigPrint += "  (     )\n";
		pigPrint += "   )   (\n";
		pigPrint += "  /     \\\n";
		pigPrint += " (   9   )\n";
		pigPrint += "(_\\_____/_)";
		return pigPrint;
	}
	
	/*
	 * Setter methods
	 */
	public void changeFLevel(int x) {
		fLevel += x;
	}
	
	public void addQuestion() {
		question++;
	}
	
	/*
	 * Getter methods
	 */
	public String getPigPrint() {
		return pigPrint;
	}
	
	public int getFLevel() {
		return fLevel;
	}
	
	public int getQuestion() {
		return question;
	}
	
	public boolean hasResponse(String s) {
		if (speech.getPrompts().containsKey(s)) {
			return true;
		}
		return false;
	}
	
	public void resetPig() {
		fLevel = 0;
		question = 0;
		setPigPrintFront();
		speech.setPigSpeech();
		Random ran = new Random();
		int x = ran.nextInt(pigSpeeches.size());
		speech = pigSpeeches.get(x);
	}
}
