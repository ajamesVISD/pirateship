package org.vashonsd.pirateship.minigame.speech;

import java.util.HashMap;

public class LazySpeech implements SpeechBehavior {

	public static HashMap<String, String> responsePrompts = new HashMap<String, String>();
	public static HashMap<String, Integer> fLevelChange = new HashMap<String, Integer> ();
	
	public LazySpeech() {
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
		return "Execution days here, buddy.";
	}

	public String getOutro() {
		return "Eh, you know what? Think I'm kind of fond of you.\nI was too lazy to take you to the chair anyways.\nSo, your free. Ciao.";
	}

	public void setPigSpeech() {
		// "do you like"
		responsePrompts.put("food", "Sure, I suppose. Chewings kind of a pain, though.");	
		fLevelChange.put("food", 0);
		responsePrompts.put("sci fi", "Sci fi? Nah, not really a fan.\nThey always seem to have all these fancy terms to keep track of\nand that's a lot of work.");
		fLevelChange.put("sci fi", -1);
		responsePrompts.put("the super bowl", "Hey, you know I'm down for anything that involves\nsitting like a slug in front of the TV.");
		fLevelChange.put("the super bowl", 1);
		responsePrompts.put("long graduation speeches", "Oh, sure. I conk out right away.");	
		fLevelChange.put("long graduation speeches", 1);
		responsePrompts.put("all things", "Kind of a pain to DISLIKE things.\nSo yeah.");	
		fLevelChange.put("all things", 1);
		responsePrompts.put("voodoo", "Voodoo? Geez dude, that's kinda dark.\nBesides, making the doll, collecting the hair...\nAh, so much work...");	
		fLevelChange.put("voodoo", -1);
		responsePrompts.put("putting people in their place", "No, no, I like to consider myself a pretty chill guy.\nNone of that for me.");	
		fLevelChange.put("putting people in their place", -2);
		// "do you think"
		responsePrompts.put("i'm pretty", "Eh, no opinion.");	
		fLevelChange.put("i'm pretty", 0);
		responsePrompts.put("you're pretty", "Eh, no opinion.");
		fLevelChange.put("you're pretty", 0);
		responsePrompts.put("you're cool", "Cool? Well, I suppose I am a rather chill fellow.\nSo, uh, yes.");
		fLevelChange.put("you're cool", 1);
		responsePrompts.put("the end is nigh", "If it is, then I'm taking a nice, long nap.");	
		fLevelChange.put("the end is nigh", 0);
		responsePrompts.put("we're in the matrix", "Eh, I'd be doing the same thing there as I am here,\nso I suppose it doesn't really matter.");
		fLevelChange.put("we're in the matrix", 0);
		responsePrompts.put("the government is made of alien lizards", "Who knows? I'd rather not ponder, honestly.");	
		fLevelChange.put("the government is made of alien lizards", 0);
		// "do you believe in"
		responsePrompts.put("ghosts", "Um...dunno, mate.");	
		fLevelChange.put("ghosts", 0);
		responsePrompts.put("the force", "Man, I wish.\nI'd never half to walk again, I could just levitate myself everywhere.\nHmm...But would constant use of the force also be tiring?\nThis IS a dilemam.");	
		fLevelChange.put("the force", 1);
		responsePrompts.put("dumbledore", "Dunno, never seen the guy.\nIf you see him around, tell me, I'm a little curious now.");	
		fLevelChange.put("dumbledore", 0);
		responsePrompts.put("believing in things", "I, uh, dunno what you mean by that.\nSo I'm just gunna say yes, because thinking any harder about it\nwould be detrimental to my health.");	
		fLevelChange.put("believing in things", 0);
		responsePrompts.put("the moon", "...Probably.\nI haven't been out and about a lot lately, to tell the truth.\nBut it's probably still there, right?");	
		fLevelChange.put("the moon", 0);
		responsePrompts.put("honest work", "Haha, funny joke bro.\nYou really tickle my funny bone.");	
		fLevelChange.put("honest work", 0);
		responsePrompts.put("dumb luck", "Hey, how do you think I got as far in life as I did?\nYou're talking to the reinging KING of dumb luck.");	
		fLevelChange.put("dumb luck", 2);
		responsePrompts.put("sleeping in", "Buddy, sleeping in is my LIFE.\nI'm so good, I can do it with my eyes closed.");	
		fLevelChange.put("sleeping in", 2);
		// "can you tell me"
		responsePrompts.put("a joke", "Oh, sure, um...\nOk, I got one.\nWhat did the pig say in the desert?\n\n...'I'm bacon out here!'\n...Listen, buddy, they can't all be winners.");	
		fLevelChange.put("a joke", 1);
		responsePrompts.put("a secret", "Pal, I'm an open book. Ain't got nothing to tell.");	
		fLevelChange.put("a secret", 0);
		responsePrompts.put("an idea", "Um, I'm not really an IDEA guy. More of a...Snooze guy.");	
		fLevelChange.put("an idea", -1);
		responsePrompts.put("some gossip", "Oh, I'm not really into gossip.\nJust kind of let all that drama pass over my head.");	
		fLevelChange.put("some gossip", -2);
		responsePrompts.put("the meaning of life", "Sure thing, bud.\nMy motto of life is, 'no situation is so bad it can't be remedied by a good nap'.\nYou're welcome.");	
		fLevelChange.put("the meaning of life", 1);
		responsePrompts.put("something cool", "A popsicle.\nSee what I did there?");	
		fLevelChange.put("something cool", 1);
		responsePrompts.put("something weird", "What baffles me is people who do REAL work.\nI know, crazy, right?");	
		fLevelChange.put("something weird", 0);
		responsePrompts.put("something", "Something.");	
		fLevelChange.put("something", 0);
		// "can you give me"
		responsePrompts.put("something to eat", "I'd love to, buddy, I really woud.\nBut then I'd have to go and GET it.\nAnd, to be honest, I don't wanna.\nSo no dice.");	
		fLevelChange.put("something to eat", -1);
		responsePrompts.put("a smile", "A smile? That's a bit more effort than I'm willing to expend.\nLopsided grin? Well, maybe I can manage.");	
		fLevelChange.put("a smile", 0);
		responsePrompts.put("advice", "Me? Give advice? No, I don't think I'm ready for that kind of responsibility.");	
		fLevelChange.put("advice", -1);
		responsePrompts.put("a sweet hotwheels collection", "I'm gunna have to give you a gentle but firm 'no'.\nSorry, buckaroo.");	
		fLevelChange.put("a sweet hotwheels collection", -1);
		responsePrompts.put("your hand in marriage", "Um...No. I'm not really one for that kind of commitment.");	
		fLevelChange.put("your hand in marriage", -2);
		// "can you do"
		responsePrompts.put("a backflip", "Hohoho, buddy. BUDDY. Ain't that a joke.\nNo, all that physical stuff isn't really my cup of tea.");	
		fLevelChange.put("a backflip", -2);
		responsePrompts.put("magic", "Hold on, let me check.\nAlakazam.\nNah, doesn't look like it.");	
		fLevelChange.put("magic", 0);
		responsePrompts.put("a tumblr", "You mean can I scroll through internet pages?\nBecause the answer is yes.");	
		fLevelChange.put("a tumblr", 1);
		responsePrompts.put("pi", "Buddy, pal, you're talking about memorization now.\nDo I even remotely strike you as the kind of pig to memorize ANYTHING?\n'Cuz I shouldn't.");	
		fLevelChange.put("pi", -1);
		responsePrompts.put("murder", "Ugh, sounds like trouble.\nI mean, first you gotta DO it. Then hide the body...Hide the evidence...\nUgh, just thinking about all that effort makes me cringe.");	
		fLevelChange.put("murder", -2);
		responsePrompts.put("absolutely nothing", "Buddy ol' pal ol' friend, now you are TALKING my LANGUAGE.\nDoing nothing is literally my life.\nI thought I felt a connection when I first met you.");	
		fLevelChange.put("absolutely nothing", 2);
		// "would you like to"
		responsePrompts.put("watch tv with me", "Hey, I am the master of zoning out to the TV.\nCount me in any day.");	
		fLevelChange.put("watch tv with me", 2);
		responsePrompts.put("build a snowman", "How about YOU build the snowman, and I'LL watch?\nI'm not really down with...cold...moving...work...");	
		fLevelChange.put("build a snowman", -1);
		responsePrompts.put("take over the world", "Um, that sounds like a big undertaking.\nI could get you a globe and you could PRETEND.\nOh wait, I don't want to get the globe...");	
		fLevelChange.put("take over the world", -1);
		responsePrompts.put("get a life", "Nah, I'm pretty content without a life, thank you.");
		fLevelChange.put("get a life", 0);
		responsePrompts.put("go to the bathroom", "Actually, yeah, I've kinda gotta go. But I'm lazy.\nI know, will you go for me?");	
		fLevelChange.put("go to the bathroom", 0);
		responsePrompts.put("lay on the ground and feel like trash", "Hey, I'm down for anything that involves lying around,\ntrash or otherwise. I'd love to.");	
		fLevelChange.put("lay on the ground and feel like trash", 2);
		// "would you go to"
		responsePrompts.put("mars", "I dunno, do they have TV and potato chips on Mars?\nNo? Then I'll pass.");	
		fLevelChange.put("mars", 0);
		responsePrompts.put("the caribbean", "The Caribbean? Sounds like sunshine, sleep, and...Something else that starts with an s.\nSign me up.");	
		fLevelChange.put("the caribbean", 2);
		responsePrompts.put("narnia", "Um, I think I'd rather just hang out in the wardrobe.\nAll those coats would make it like a snuggly, fuzzy hug.");	
		fLevelChange.put("narnia", 0);
		responsePrompts.put("the internets", "Hey, you know me. I'm all about staring at screens until my brain leaks out my ears.");	
		fLevelChange.put("the internets", 1);
		responsePrompts.put("your room", "Oh sure, where else would I do my serious napping?");	
		fLevelChange.put("your room", 1);
		responsePrompts.put("my funeral", "Sure, if your funeral is held in my room and I'm allowed to sleep through it.");	
		fLevelChange.put("my funeral", 0);
		// "are you good at"
		responsePrompts.put("sports", "Oh man, you crack me up, buddy.");	
		fLevelChange.put("sports", 0);
		responsePrompts.put("the arts", "Um, I'm really good at staring at the blank page...\nThen falling asleep on the blank page...");	
		fLevelChange.put("the arts", 0);
		responsePrompts.put("brain stuff", "Brain stuff? Um, how about lack of brain stuff? I'm really good at that.");	
		fLevelChange.put("brain stuff", 0);
		responsePrompts.put("being cool", "Well, it does take a certain amount of talent to be as laid back and chill as me.");	
		fLevelChange.put("being cool", 1);
		responsePrompts.put("breathing", "Oh yeah, I'm a master at all types of breathing. I can do snoring, um...Snoring.");	
		fLevelChange.put("breathing", 1);
		responsePrompts.put("procrastinating", "Baby, I put the PRO in procrastination. You're talking to the master here.");	
		fLevelChange.put("procrastinating", 2);
		responsePrompts.put("over-analyzing", "Nah, analyzing isn't really my thing. Prefer not to disturb the good ol' gray matter up there, you know?");	
		fLevelChange.put("over-analyzing", -1);
		responsePrompts.put("everything", "If I was good at everything I'd have to actually DO stuff, and that's, well, kind of a pain.");	
		fLevelChange.put("everything", 0);
		// "are you scared of"
		responsePrompts.put("idiots", "No, then I'd be scared of ME.");	
		fLevelChange.put("idiots", 0);
		responsePrompts.put("insomnia", "DUDE, insomnia is like, my worst nightmare.\nIronic to have nightmares about not sleeping, but I digress...");	
		fLevelChange.put("insomnia", 2);
		responsePrompts.put("the dark side", "Nah, dude, nighttime is when I sleep.\nWait, you were talking about something else?");	
		fLevelChange.put("the dark side", 0);
		responsePrompts.put("public speaking", "That's assuming I actually go out in public in the first place.");	
		fLevelChange.put("public speaking", 0);
		responsePrompts.put("people knowing how dead you are inside", "Not at all. Heck, that's practically how I introduce myself.\n'Hi, my name is Pig, and I'm dead on the inside. You?'");	
		fLevelChange.put("people knowing how dead you are inside", 0);
		// "are you actually"
		responsePrompts.put("a zombie", "When I'm tired, I'm like a zombie. Which is all the time, so...\nWait, does that mean I'm actually a zombie? Huh, now I'm craving brains.");	
		fLevelChange.put("a zombie", 1);
		responsePrompts.put("a unicorn", "I don't, uh, really know how to answer that.\nSo I'm just not gunna.");	
		fLevelChange.put("a unicorn", 0);
		responsePrompts.put("a sloth", "Wow, bud, sloths are like, my spirit animal. How could you tell?");	
		fLevelChange.put("a sloth", 2);
		responsePrompts.put("a smartass", "Nah, I'd say my ass is pretty average.");	
		fLevelChange.put("a smartass", -1);
		responsePrompts.put("a jedi master", "With all the jumping and swinging lightsabers around they do?\nOh honey, no.");	
		fLevelChange.put("a jedi master", -1);
		responsePrompts.put("the devil himself", "The devil? Nah, he seems like he'd be a pretty busy guy, and I'm anything but.");	
		fLevelChange.put("the devil himself", 0);
	}
}
