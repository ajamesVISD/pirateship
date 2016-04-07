package org.vashonsd.pirateship.minigame.speech;

import java.util.HashMap;

public class SassSpeech implements SpeechBehavior {
	
	public static HashMap<String, String> responsePrompts = new HashMap<String, String>();
	public static HashMap<String, Integer> fLevelChange = new HashMap<String, Integer> ();
	
	public SassSpeech() {
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
		return "Alright, Sleeping Ugly, get up. It's execution time.";
	}

	public String getOutro() {
		return "You know what, you're not half bad.\nAnd that's saying A LOT coming from me.\nSo I'm gunna let you go. Out of the kindness of my littly piggy heart.\nCheers!";
	}
	
	public void setPigSpeech() {
		// "do you like"
		responsePrompts.put("food", "No, I prefer starving to death.\nYES I like food.");	
		fLevelChange.put("food", -1);
		responsePrompts.put("sci fi", "That nerdy stuff? No, I'm not really down.\nI'm more a fan of the classics.");
		fLevelChange.put("sci fi", 0);
		responsePrompts.put("the superbowl", "HA! Watching big, sweaty men run around and slam into other big, sweaty men?\nThanks but no thanks.");
		fLevelChange.put("the superbowl", -1);
		responsePrompts.put("long graduation speeches", "Yeah! I'm also a fan of shaving with rusty razors and watching paint dry!\n...That was sarcasm. The answer is 'no'.");	
		fLevelChange.put("long graduation speeches", -1);
		responsePrompts.put("all things", "I would love to say yes, but then I look at you, and...");	
		fLevelChange.put("all things", 1);
		responsePrompts.put("voodoo", "Voodoo? As pleasing as causing my enemies to suffer sounds, I'm just not a believer.");	
		fLevelChange.put("voodoo", 0);
		responsePrompts.put("putting people in their place", "Oh, that's my favorite thing.\nPeople need to be told when they're being stupid, and I'm not afraid to do it.\nThe world needs more people like me.");	
		fLevelChange.put("putting people in their place", 2);
		// "do you think"
		responsePrompts.put("i'm pretty", "You're pretty? HA! Man, you crack me up.");	
		fLevelChange.put("i'm pretty", 1);
		responsePrompts.put("you're pretty", "Well, I'm no KNOCKOUT but I'd give myself a solid 7.");	
		fLevelChange.put("you're pretty", 1);
		responsePrompts.put("you're cool", "Need you even ask? I would think the answer obvious just by looking.");	
		fLevelChange.put("you're cool", 2);
		responsePrompts.put("the end is nigh", "It's about to be.\n...FOR YOU! Get it? 'Cuz you're going to die?\nMan, I am TOO good.");	
		fLevelChange.put("the end is nigh", 1);
		responsePrompts.put("we're in the matrix", "Sure, and let me guess, you're the chosen one?\nTHAT'LL be the day.");	
		fLevelChange.put("we're in the matrix", 0);
		responsePrompts.put("the government is made of alien lizards", "Oh, you're one of THOSE people, are you?\nMy respect for you just dropped a mile. Congradulations.");	
		fLevelChange.put("the government is made of alien lizards",-2);
		// "do you believe in"
		responsePrompts.put("ghosts", "Ghosts? No.\nIf they WERE real, I'd certaintly have a lot more people haunting me than I do right now.");	
		fLevelChange.put("ghosts", 0);
		responsePrompts.put("the force", "If I did, I'd be trying to choke you, Darth Vader style.\nYou should count yourself lucky I don't.");	
		fLevelChange.put("the force", 0);
		responsePrompts.put("dumbledore", "Does it matter? Even if I did, he's dead.\nOh yeah, spoilers.");	
		fLevelChange.put("dumbledore", 0);
		responsePrompts.put("believing in things", "What is this, Disney? You going to break out into song next?");	
		fLevelChange.put("believing in things", -1);
		responsePrompts.put("the moon", "Are you trying to dumb?\nBecause I find it hard to believe that anyone can be as dumb as you,\nif not on purpose.");	
		fLevelChange.put("the moon", -2);
		responsePrompts.put("honest work", "Work? Yes. Honest work? Well...");	
		fLevelChange.put("honest work", 0);
		responsePrompts.put("dumb luck", "Well, I wouldn't, but...\nThen I look at you.");	
		fLevelChange.put("dumb luck", 1);
		responsePrompts.put("sleeping in", "Sleeping in? Please, like I have time to sleep in.\nEvery day, I get up bright and early. Then, I practice my sassy quips in the mirror.\nHave to be prepared for the day.");	
		fLevelChange.put("sleeping in", 0);
		// "can you tell me"
		responsePrompts.put("a joke", "Yeah, I got a great one.\nYour face.\nBoom, roasted.");	
		fLevelChange.put("a joke", 2);
		responsePrompts.put("a secret", "Don't you just wish. I've got lots of secret - big, juicy ones, woowoo.\nBut none for you.");	
		fLevelChange.put("a secret", -1);
		responsePrompts.put("an idea", "Here's an idea - maybe you stop asking dumb questions and resign to your fate already?");	
		fLevelChange.put("an idea", -1);
		responsePrompts.put("some gossip", "Gossip? Don't see why not. Naturally, I'm the reigning gossip QUEEN.\nIn fact, I heard this crazy tidbit about a prisoner\nwho was trying to convince his warden to let him out by sweetalking him.\nCRAZY, huh? What's the world coming to.");	
		fLevelChange.put("some gossip", 2);
		responsePrompts.put("the meaning of life", "You were right to come to me with this question. It's simple, really.\nGet paid, get laid, Gatorade. Next question.");	
		fLevelChange.put("the meaning of life", 2);
		responsePrompts.put("something cool", "Me. I'm something cool.\nGood talk, next question.");	
		fLevelChange.put("something cool", 2);
		responsePrompts.put("something weird", "I'm looking at it.\nGet it? It's you. You're the weird thing.");	
		fLevelChange.put("something weird", 1);
		responsePrompts.put("something", "You're going to need to be a little bit more specific than that, bucko.\nWhat do I look like, a word-of-the-day generator?");	
		fLevelChange.put("something", -2);
		// "can you give me"
		responsePrompts.put("something to eat", "You already had your last meal, buddy. I'm not a vending machine.");	
		fLevelChange.put("something to eat", -1);
		responsePrompts.put("a smile", "I ain't no service counter, bub, you gotta EARN your smiles.");	
		fLevelChange.put("a smile", -2);
		responsePrompts.put("advice", "Well, you've come to the RIGHT place. I've got advice up the wazoo.\nAdvice number uno: be cool. Like me!\n...That's it.");	
		fLevelChange.put("advice", 2);
		responsePrompts.put("a sweet hotwheels collection", "I am no officially concerned for your sanity.");	
		fLevelChange.put("a sweet hotwheels collection", -1);
		responsePrompts.put("your hand in marriage", "Woah, there, bub. Don't you think we're moving this along a little fast?\nYou haven't even taken me out to dinner yet.");	
		fLevelChange.put("your hand in marriage", -1);
		// "can you do"
		responsePrompts.put("a backflip", "Yeah, do I LOOK like I can do a backflip to you?\nI'd rather NOT throw out my back today, thank yo very much.");	
		fLevelChange.put("a backflip", -1);
		responsePrompts.put("magic", "Some would say my sass is so great it's almost like magic.\nBut the sparkly, abracadabra stuff?\nNo, unfortunately for you, I'm not 5 years old.");	
		fLevelChange.put("magic", -1);
		responsePrompts.put("a tumblr", "HA. No, I'm not a repressed teenager.");	
		fLevelChange.put("a tumblr", -1);
		responsePrompts.put("pi", "Yeah, can you do a GRAMMAR?");	
		fLevelChange.put("pi", -1);
		responsePrompts.put("murder", "Don't tempt me.");	
		fLevelChange.put("murder", 0);
		responsePrompts.put("absolutely nothing", "Sure, I think that's within anyones capabilities.\nCan you NOT do nothing?");	
		fLevelChange.put("absolutely nothing", 0);
		// "would you like to"
		responsePrompts.put("watch tv with me", "No, because I am a sophisticated kind of fellow.");	
		fLevelChange.put("watch tv with me", -1);
		responsePrompts.put("build a snowman", "Did you just make a reference? You didn't even say it right.\nShame, shame.");	
		fLevelChange.put("build a snowman", -2);
		responsePrompts.put("take over the world", "Yes, just like we do every day, Pinky.\nYeah, I made a reference. Sue me.");	
		fLevelChange.put("take over the world", 1);
		responsePrompts.put("get a life", "Yeah, what's that saying about the kettle and the pot again?");	
		fLevelChange.put("get a life", -1);
		responsePrompts.put("go to the bathroom", "Are you trying to trick me into leaving?\nBecause that's, like, the oldest trick in the book.\nPoints docked for lack of creativity.");	
		fLevelChange.put("go to the bathroom", -1);
		responsePrompts.put("lay on the ground and feel like trash", "Nah, I'm perfectly capable of doing that while standing up.");	
		fLevelChange.put("lay on the ground and feel like trash", 0);
		// "would you go to"
		responsePrompts.put("mars", "Oh SURE, I hear the scenery there is gorgeos.\nRock.\nRock.\nMaybe more rock...");	
		fLevelChange.put("mars", 0);
		responsePrompts.put("the caribbean", "Like, on a relaxing summer cruise?\nBecause you know mama is ALL about their relaxing summer cruises.");	
		fLevelChange.put("the caribbean", 1);
		responsePrompts.put("narnia", "Yeah, right after I make a stop by Neverland, give good ol' Tinkerbell a visit.\n...In case you couldn't figure, that was sarcastic.");	
		fLevelChange.put("narnia", -1);
		responsePrompts.put("the internets", "Could you maybe attempt to make proper grammatical sentences?\nOr is that just beyond you?");	
		fLevelChange.put("the internets", -1);
		responsePrompts.put("your room", "What are you, my momma pig?");	
		fLevelChange.put("your room", -2);
		responsePrompts.put("my funeral", "Hmm....\n.............No.");	
		fLevelChange.put("my funeral", 0);
		// "are you good at"
		responsePrompts.put("sports", "Puh-LEASE. Do I look like a sporty pig to you?");	
		fLevelChange.put("sports", 0);
		responsePrompts.put("the arts", "Do stick figures count?\nIf so, then yes, I'm an art master.");	
		fLevelChange.put("the arts", 0);
		responsePrompts.put("brain stuff", "Well, I have a brain, so I suppose that yes, I am good at this...\n....'brain stuff'.");	
		fLevelChange.put("brain stuff", 1);
		responsePrompts.put("being cool", "Naturally, I'm the coolest at being cool. You shouldn't even have to ask.");	
		fLevelChange.put("being cool", 2);
		responsePrompts.put("breathing", "Hold on, let me check.\n...Yes. Yes, I can breathe.\nLittle shocked you can, though.");	
		fLevelChange.put("breathing", -2);
		responsePrompts.put("procrastinating", "Absolutely not! Why, I am the most punctual pig I know!\nDesist your silly questions.");	
		fLevelChange.put("procrastinating", -1);
		responsePrompts.put("over-analyzing", "Are you implying something? Because I don't appreciate it.");	
		fLevelChange.put("over-analyzing", -1);
		responsePrompts.put("everything", "Well, duh. Just look at me.");	
		fLevelChange.put("everything", 2);
		// "are you scared of"
		responsePrompts.put("idiots", "Oh my Pig, YES. I can feel my IQ dropping every moment I spend around them.\nI'm glad SOMEONE finally understands.");	
		fLevelChange.put("idiots", 2);
		responsePrompts.put("insomnia", "Insomnia? PUH-lease.\nAs if any force in the world could keep me from my beauty sleep.");	
		fLevelChange.put("insomnia", 0);
		responsePrompts.put("the dark side", "Baby, I practically CREATED the dark side.");	
		fLevelChange.put("the dark side", 0);
		responsePrompts.put("public speaking", "Uh, what do you think?\n...That was rhetorical. The answer is no, it should be obvious.");	
		fLevelChange.put("public speaking", 0);
		responsePrompts.put("people knowing how dead you are inside", "Oh please, like that's any secret.");	
		fLevelChange.put("people knowing how dead you are inside", 0);
		// "are you actually"
		responsePrompts.put("a zombie", "If I was, I certainly wouldn't want YOUR brain.\nZing.");	
		fLevelChange.put("a zombie", 1);
		responsePrompts.put("a unicorn", "I don't NEED to be, I'm already fabulous.");	
		fLevelChange.put("a unicorn", 1);
		responsePrompts.put("a sloth", "Um, excuse me? Do I look like I have algae growin in my fur?\nI'm a proud pig through and through, thank you VERY much.");	
		fLevelChange.put("a sloth", -1);
		responsePrompts.put("a smartass", "My butt is rather smart, thank you for noticing.\nIt's a full time job, but it's one I'm willing to shoulder.");	
		fLevelChange.put("a smartass", 2);
		responsePrompts.put("a jedi master", "I may be little, but I'm a pig, not a cooky green troll.\nJedi master, I am not.");	
		fLevelChange.put("a jedi master", 0);
		responsePrompts.put("the devil himself", "Funny you ask, that's what my last girlfriend called me.\nSo yes, I suppose I am.");	
		fLevelChange.put("the devil himself", 1);
	}
}
