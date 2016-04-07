package org.vashonsd.pirateship.minigame.speech;

import java.util.HashMap;

public class NerdSpeech implements SpeechBehavior {

	public static HashMap<String, String> responsePrompts = new HashMap<String, String>();
	public static HashMap<String, Integer> fLevelChange = new HashMap<String, Integer> ();
	
	public NerdSpeech() {
		setPigSpeech();
	}
	
	public String getResponse(String s) {
		return responsePrompts.get(s);
	}

	public int getFLevelChange(String s) {
		return fLevelChange.get(s);
	}

	public void voidFLevel(String s) {
		fLevelChange.put(s, 0);
	}
	
	public HashMap<String, String> getPrompts() {
		return responsePrompts;
	}

	public String getIntro() {
		return "Up. I'm taking you to the chair, prisoner.";
	}

	public String getOutro() {
		return "You know, prisoner, you're not too bad. Logically speaking, I should be taking you\nto die right about now, but...\nI'm thinking maybe I won't. So, you're free to leave.";
	}

	public void setPigSpeech() {
		responsePrompts.put("food", "As much as the next guy, I suppose.\nI don’t think I understand the relevancy of your question.");	
		fLevelChange.put("food", 0);
		responsePrompts.put("sci fi", "Oh, absolutely. I’m a die hard sci fi FANATIC.\nI must just exude that presence, for you to have noticed so easily.");
		fLevelChange.put("sci fi", 2);
		responsePrompts.put("the super bowl", "Hardly. I’ve never been one for sports.\nBesides, do you know how many injuries players sustain while out on the field?\nIt’s ridiculous, if you ask me.");
		fLevelChange.put("the super bowl", -2);
		responsePrompts.put("long graduation speeches", "Hmm. Depends. Am I giving the speech?\nThere’s nothing I like more than giving a good speech, you know.");	
		fLevelChange.put("long graduation speeches", 1);
		responsePrompts.put("all things", "Oh, I daresay not. Too many annoying things in this world for THAT to happen.");	
		fLevelChange.put("all things", 0);
		responsePrompts.put("voodoo", "Voodoo is in all shapes and forms unscientific and ludicrous.\nTo even consider liking it would be shameful.");	
		fLevelChange.put("voodoo", -2);
		responsePrompts.put("putting people in their place", "Well, I have been know to bump a few people down a few pegs\nwith my earth-shattering truths. So yes, I suppose so.");	
		fLevelChange.put("putting people in their place", 1);
		// "do you think"
		responsePrompts.put("i'm pretty", "Objectively speaking………..No.");	
		fLevelChange.put("i'm pretty", 0);
		responsePrompts.put("you're pretty", "Well, when considered scientifically, after crunching the numbers…\n...The answers yes.");	
		fLevelChange.put("you're pretty", 1);
		responsePrompts.put("you're cool", "I consider myself more of a proud nerd, honestly.");	
		fLevelChange.put("you're cool", -1);
		responsePrompts.put("the end is nigh", "Certainly not, the idea that the world could suddenly END all willy-nilly is just absurd.");	
		fLevelChange.put("the end is nigh", -1);
		responsePrompts.put("we're in the matrix", "Oh man, now wouldn’t that be cool. That’s one of my favorite movies.\nDidn’t know I had a fellow fan here.");	
		fLevelChange.put("we're in the matrix", 2);
		responsePrompts.put("the government is made of alien lizards", "It boggles my mind how anyone could think that would make even a LICK of sense.");	
		fLevelChange.put("the government is made of alien lizards", -2);
		// "do you believe in"
		responsePrompts.put("ghosts", "I am a pig grounded in reality. So no, no I do not.");	
		fLevelChange.put("ghosts", -1);
		responsePrompts.put("the force", "Don’t I wish! Though do have some theories on how it would work if it were real....");
		fLevelChange.put("the force", 2);
		responsePrompts.put("dumbledore", "No. The books are entertaining, I suppose, but simply that: novelty.");	
		fLevelChange.put("dumbledore", 0);
		responsePrompts.put("believing in things", "I’m sorry, you’re going to need to clarify your question.");	
		fLevelChange.put("believing in things", -2);
		responsePrompts.put("the moon", "Well, what a ridiculous thing to ask!\nClearly the moon is RIGHT THERE, in the sky, and seeing is believing, you know.");	
		fLevelChange.put("the moon", -1);
		responsePrompts.put("honest work", "Not only do I believe in it, but I actively advocate for it!\nHonest work is the only work.");	
		fLevelChange.put("honest work", 2);
		responsePrompts.put("dumb luck", "Please, luck doesn't exist. Only cause and effect.");	
		fLevelChange.put("dumb luck", -1);
		responsePrompts.put("sleeping in", "Certainly not! I wake up at the crack of dawn every day, as all pigs should.");
		fLevelChange.put("sleeping in", -1);
		// "can you tell me"
		responsePrompts.put("a joke", "Alright, I’ve got a good one.\nWhat do you get when you put a root beer in a square glass?\n….Beer.\nOh, I’m so clever.");	
		fLevelChange.put("a joke", 1);
		responsePrompts.put("a secret", "No, a genius never shares the secrets.\nThat’s how the saying goes, right?");	
		fLevelChange.put("a secret", 0);
		responsePrompts.put("an idea", "Why, certainly! Just yesterday, I was contemplating blah blah blah\nblah blah blah blahblah BLAH blah blah blaaah blah\nblah BLAHblah BLAH blah blahblaaah blah BLAH blah...\nAnd THEN I realized blah blah blaaaaah blah\nHEY, are you listening?!");	
		fLevelChange.put("an idea", 2);
		responsePrompts.put("some gossip", "Gossip? Please, gossip is for chatty teenage women,\nnot dignified pigs such as myself.");	
		fLevelChange.put("some gossip", -2);
		responsePrompts.put("the meaning of life", "Certainly. The meaning of life is SCIENCE!\nAnd Star Trek.");	
		fLevelChange.put("the meaning of life", 2);
		responsePrompts.put("something cool", "I don’t believe in ‘cool’ things. I believe in objective truths.");	
		fLevelChange.put("something cool", -1);
		responsePrompts.put("something weird", "Hmm...Ok, here’s a fun fact!\nDid you know that the second person to survive falling down Niagara Falls\nLater died slipping on an orange peel?\nVery interesting...");	
		fLevelChange.put("something weird", 2);
		responsePrompts.put("something", "You’re going to need to be a little more specific than that.");	
		fLevelChange.put("something", -1);
		// "can you give me"
		responsePrompts.put("a smile", "I CAN, that doesn’t mean I WILL. Grammar, prisoner, grammar.");	
		fLevelChange.put("a smile", 0);
		responsePrompts.put("advice", "My advice? Objectivity is key!\nAlso, Star Wars prequels can die.");	
		fLevelChange.put("advice", 2);
		responsePrompts.put("a sweet hotwheels collection", "No, I’m sorry, I can’t, because I am not 8.");	
		fLevelChange.put("a sweet hotwheels collection", 0);
		responsePrompts.put("your hand in marriage", "Sorry, I'm already dedicated. To science.");	
		fLevelChange.put("your hand in marriage", 0);
		// "can you do"
		responsePrompts.put("a backflip", "No. I understand the science behind it.\nBut can I do it?\n...No.");	
		fLevelChange.put("a backflip", 0);
		responsePrompts.put("magic", "Magic is just a child’s fantasy. Cute, but not real.\nSo the answer is ‘no’.");	
		fLevelChange.put("magic", -2);
		responsePrompts.put("a tumblr", "Please. The petty allure of the internet has no hold on me.\nBesides, I’m a canon or nothing kind of pig. No fanfic for me, thank you VERY much.");	
		fLevelChange.put("a tumblr", -1);
		responsePrompts.put("pi", "Naturally. 3.14159265358979323846264338327950288419716939937510582...");	
		fLevelChange.put("pi", 2);
		responsePrompts.put("murder", "Technically speaking, it would be within my ability.\nI’d have to devise a plan prior...Be ready to dispose of the body…\nMake sure there are no witnesses…\nNot that I would, of course, but the strategy of it is a wee bit interesting.");
		fLevelChange.put("murder", 1);
		responsePrompts.put("absolutely nothing", "No, sir, I’m afraid that is just not one of my talents.\nUnlike some people, I live my life to the fullest.");	
		fLevelChange.put("absolutely nothing", -1);
		// "would you like to"
		responsePrompts.put("watch tv with me", "Depends on what we’re watching. I’m a high class kind of pig who only watches the finest shows.\nLike the X-Files.");	
		fLevelChange.put("watch tv with me", 0);
		responsePrompts.put("build a snowman", "That kind of child’s activity isn’t really in my scope. Sorry.");	
		fLevelChange.put("build a snowman", 0);
		responsePrompts.put("take over the world", "Now there’s an idea! It would take extensive planning, clever planning…\nBut nothing my genius couldn’t handle, I’m sure!\nAnd what does the world need more than a genius such as I at their helm?");	
		fLevelChange.put("take over the world", 2);
		responsePrompts.put("get a life", "Your attempts to insult me are cute, but fruitless, for I am above your drabble.");	
		fLevelChange.put("get a life", -1);
		responsePrompts.put("go to the bathroom", "My bodily functions are none of your business.");	
		fLevelChange.put("go to the bathroom", 0);
		responsePrompts.put("lay on the ground and feel like trash", "No, time is money and money is fame so I won’t be wasting any of it!");	
		fLevelChange.put("lay on the ground and feel like trash", 0);
		// "would you go to"
		responsePrompts.put("mars", "Oh, absolutely! I would love to. Astronomy just FASCINATES me.");	
		fLevelChange.put("mars", 2);
		responsePrompts.put("the caribbean", "In all honesty that sounds like a waste of time and money.\nSo no.");	
		fLevelChange.put("the caribbean", -1);
		responsePrompts.put("narnia", "I’m sorry to burst your bubble of stupidity, but such a place doesn’t EXIST.\nAnd how am I to go to a place that doesn’t exist?");	
		fLevelChange.put("narnia", -2);
		responsePrompts.put("the internets", "Of course, the internet is a wealth of knowledge!\n...And illegal movie streaming websites that I may or may not use...");	
		fLevelChange.put("the internets", 1);
		responsePrompts.put("your room", "My room is for sleeping and nothing more. I see no reason to go there NOW.");	
		fLevelChange.put("your room", 0);
		responsePrompts.put("my funeral", "No.");	
		fLevelChange.put("my funeral", 0);
		// "are you good at"
		responsePrompts.put("sports", "The only sports I’M interesting are the competitive gaming types.");	
		fLevelChange.put("sports", 0);
		responsePrompts.put("the arts", "A supercomputer, computing for a thousand years, could not even come CLOSE\nto reaching the amount of eff’s I don’t give about the arts.");	
		fLevelChange.put("the arts", -1);
		responsePrompts.put("brain stuff", "As dumb as you make it sound, yes, I am quite good at ‘brain stuff’. I am a genius, after all.");	
		fLevelChange.put("brain stuff", 2);
		responsePrompts.put("being cool", "Hardly even. I have always done my own thing, and that is that.");	
		fLevelChange.put("being cool", -1);
		responsePrompts.put("breathing", "Breathing is one of our most basic pig processes. If I were not good at it, I’d probably be dead.\nI find your question rather stupid, honestly.");	
		fLevelChange.put("breathing", -2);
		responsePrompts.put("procrastinating", "Absolutely not! I plan out every minute of my day.\n6:30, wake up. 6:35, get changed. 6:40, brush teeth...");	
		fLevelChange.put("procrastinating", -2);
		responsePrompts.put("over-analyzing", "Please, I don't just over-analyze. I over-analyze my over-analysis.");	
		fLevelChange.put("over-analyzing", 2);
		responsePrompts.put("everything", "I'm fairly certain that's humanly (or pigly) impossible.");	
		fLevelChange.put("everything", 0);
		// "are you scared of
		responsePrompts.put("idiots", "I rather like idiots, actually. There's no type of person more easy to manipulate.");
		fLevelChange.put("idiots", 0);
		responsePrompts.put("insomnia", "What do you think sleeping pills are for?");
		fLevelChange.put("insomnia", 0);
		responsePrompts.put("the dark side", "I own the dark side.");
		fLevelChange.put("the dark side", 2);
		responsePrompts.put("public speaking", "Well, I won't pretend I'm partial to it, but when you have plans to\novertake the world there are certain things you just have to accept.");
		fLevelChange.put("public speaking", 0);
		responsePrompts.put("people knowing how dead you are inside", "I'd say I'm perfectly alive on the inside - my organs are still functioning and whatnot.");	
		fLevelChange.put("people knowing how dead you are inside", 0);
		// "are you actually"
		responsePrompts.put("a zombie", "Psh. The zombie franchise holds no interest to me. I mean, they're so slow.\nJust POWER WALK AWAY FROM THEM YOU IDIO-I'm sorry, I got a little heated there.");	
		fLevelChange.put("a zombie", -1);
		responsePrompts.put("a unicorn", "Do I look like a floofy, horned horse who rides rainbows and poops butterflies?");	
		fLevelChange.put("a unicorn", -1);
		responsePrompts.put("a sloth", "Certanly not. Did you know sloths only pee once a week? Disgusting.");	
		fLevelChange.put("a sloth", -2);
		responsePrompts.put("a smartass", "I take offense to that.");	
		fLevelChange.put("a smartass", -1);
		responsePrompts.put("a jedi master", "Well, I won't deny attempting to use the force now and then.\nAh, but dreams are only dreams...");	
		fLevelChange.put("a jedi master", 2);
		responsePrompts.put("the devil himself", "When my plans for the world come to realization, I will certanily be comparative to him, yes.");	
		fLevelChange.put("the devil himself", 1);

	}

}
