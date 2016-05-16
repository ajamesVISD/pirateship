package org.vashonsd.pirateship.minigame.text.speech;

import java.util.HashMap;

public class ShySpeech implements SpeechBehavior {

	public static HashMap<String, String> responsePrompts = new HashMap<String, String>();
	public static HashMap<String, Integer> fLevelChange = new HashMap<String, Integer> ();
	
	public ShySpeech() {
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
		return "Um, h-hi. Oh, this is so awkward. I'm here to, uh, take you to die?";
	}

	public String getOutro() {
		return "You know, I was, uh, s-super nervous about all this, but you turned out to be really nice...\nI don't know, taking you to die after all this just wouldn't feel right.\nSo, uh, I guess I'm letting you go?";
	}

	public void setPigSpeech() {
		// "do you like"
		responsePrompts.put("food", "Um, I mean, I guess? Why are you asking? I-is it weird to like food?");	
		fLevelChange.put("food", 0);
		responsePrompts.put("sci fi", "Oh, I mean, I don't hate it, but...");
		fLevelChange.put("sci fi", 0);
		responsePrompts.put("the super bowl", "N-no, not really...Sorry...");
		fLevelChange.put("the super bowl", -1);
		responsePrompts.put("long graduation speeches", "J-just so long as it's not me up there, I guess they're fine...");	
		fLevelChange.put("long graduation speeches", 0);
		responsePrompts.put("all things", "Um...No...My hatred for things is a vast, deep black sea...");
		fLevelChange.put("all things", -1);
		responsePrompts.put("voodoo", "Oh, um, voodoo is one of my h-hobbies, actually...\nI have a c-collection of voodoo dolls, actually, one for e-every enemy.");	
		fLevelChange.put("voodoo", 2);
		responsePrompts.put("putting people in their place", "O-oh, n-no, I-I could hardly do that! T-that's just not me, you know?");	
		fLevelChange.put("putting people in their place", -2);
		// "do you think"
		responsePrompts.put("i'm pretty", "Oh, well, yeah, I s-suppose you're not too bad...\nWow, this is kind of embarrasing.");	
		fLevelChange.put("i'm pretty", 0);
		responsePrompts.put("you're pretty", "W-what? No, I mean, I'm probably just average at best...Oh geez...");	
		fLevelChange.put("you're pretty", -2);
		responsePrompts.put("you're cool", "M-me? C-cool? N-no way, I'm like, the uncoolest pig ever!\nWow, this is awkward.");	
		fLevelChange.put("you're cool", -2);
		responsePrompts.put("the end is nigh", "Oh, yes, I-I am a avid believer in the e-end of all times.\nSometimes, it's the only thing that k-keeps me going through the days...");	
		fLevelChange.put("the end is nigh", 2);
		responsePrompts.put("we're in the matrix", "O-oh, sorry, I don't really know a lot about that movie...\nUm, b-blue pills or something like that...");	
		fLevelChange.put("we're in the matrix", 0);
		responsePrompts.put("the government is made of alien lizards", "W-wow, that sounds kinda scary. I hope not.");	
		fLevelChange.put("the government is made of alien lizards", 0);
		// "do you believe in"
		responsePrompts.put("ghosts", "Oh, of c-course, ghosts are real. They t-talk to me sometimes.\nS-speaking of which, hi, Freddy.");
		fLevelChange.put("ghosts", 2);
		responsePrompts.put("the force", "I, uh, I suppose? Um, do you?");	
		fLevelChange.put("the force", 0);
		responsePrompts.put("dumbledore", "I-I guess? I mean, he seems nice and stuff, so...");	
		fLevelChange.put("dumbledore", 0);
		responsePrompts.put("believing in things", "No, n-not really. Believing only leads to disappointment...");	
		fLevelChange.put("believing in things", -1);
		responsePrompts.put("the moon", "Um, yes? W-wait, why are you asking? Are you l-leading up to something?\nA-am I wrong?");
		fLevelChange.put("the moon", 0);
		responsePrompts.put("honest work", "Um, I adm-mire people who can do honest work...");
		fLevelChange.put("honest work", 1);
		responsePrompts.put("dumb luck", "W-well, sure, I j-just don't think it happens to m-me.");	
		fLevelChange.put("dumb luck", 0);
		responsePrompts.put("sleeping in", "Well, y-yes, I mean, you n-need to sleep in when you stay up as late as I do.");	
		fLevelChange.put("sleeping in", 1);
		// "can you tell me"
		responsePrompts.put("a joke", "A j-joke? Oh no, I s-so bad with humor. Ok, um...\nS-so, what's the best thing about dead piglet jokes?........They never get old.\n...Y-you put me on the spot, ok?! I'm not good at being put on the spot!!");	
		fLevelChange.put("a joke", -1);
		responsePrompts.put("a secret", "A-a secret? Y-you really want to know? Wow, I've n-never had someone to share secrets with...\nGee, I don't know what to tell you now.");	
		fLevelChange.put("a secret", 2);
		responsePrompts.put("an idea", "O-oh, my ideas aren't that int-tresting...");
		fLevelChange.put("an idea", -1);
		responsePrompts.put("some gossip", "O-oh, I didn't know you were into t-that kind of thing.\nI-I'm not re-really one to g-gossip, sorry.");	
		fLevelChange.put("some gossip", -2);
		responsePrompts.put("the meaning of life", "Um, ok. So, we all live....and then we die.\nT-that's it.");	
		fLevelChange.put("the meaning of life", 0);
		responsePrompts.put("something cool", "Oh, I w-wouldn't know anything like that. Cool people avoid me like the p-plague...");	
		fLevelChange.put("something cool", -2);
		responsePrompts.put("something weird", "Oh, s-sure. So, did you know that your liver can regro with as little as 25% of it left?\nN-not that I know that for any particular reason, I wasn't planning on taking peoples livers or anything, I swear!");
		fLevelChange.put("something weird", 1);
		responsePrompts.put("something", "U-um.....Hi? W-was that ok?");	
		fLevelChange.put("something", 1);
		// "can you give me"
		responsePrompts.put("something to eat", "Oh, um, I'm not supp-posed to, but I guess if it'd make you happy...");
		fLevelChange.put("something to eat", 1);
		responsePrompts.put("a smile", "I'm, um, I'm not very good at those, but...I-if you really want me to...I guess I could??");
		fLevelChange.put("a smile", 1);
		responsePrompts.put("advice", "Oh, y-you don’t want my advice, I’m really bad with that kind of thing...");	
		fLevelChange.put("advice", -1);
		responsePrompts.put("a sweet hotwheels collection", "Um, so I respect you and all your life decisions, I really do, but...");	
		fLevelChange.put("a sweet hotwheels collection", -1);
		responsePrompts.put("your hand in marriage", "O-oh my! Th-that’s so forward, I-I don’t know what to say.\nG-geez, you’re making me blush...");	
		fLevelChange.put("your hand in marriage", 1);
		// "can you do"
		responsePrompts.put("a backflip", "Oh, oh geez, no! I’m h-hardly that coordinated.");	
		fLevelChange.put("a backflip", -1);
		responsePrompts.put("magic", "No. N-not that I’ve tried or anything, well maybe a little but...");	
		fLevelChange.put("magic", 0);
		responsePrompts.put("a tumblr", "Oh, sure, I spend a l-lot of time on tumblr.\nMy handle is DarkPigPrince96 if you ever wanted to, uh, to look me up…\nN-not like I’m making you or anything!");	
		fLevelChange.put("a tumblr", 2);
		responsePrompts.put("pi", "Um, like, 3.14? Or the food, or…? Oh no, I don’t understand what you’re asking, I’m sorry...");	
		fLevelChange.put("pi", 0);
		responsePrompts.put("murder", "I mean, I may or may not have fantasized about the taste of my enemies blood…\nN-not to say I actually w-would do it or anything, mind you.");	
		fLevelChange.put("murder", 2);
		responsePrompts.put("absolutely nothing", "Oh, well, sure. When the weight of the world really starts getting me down, that’s exactly what I do.");	
		fLevelChange.put("absolutely nothing", 1);
		// "would you like to"
		responsePrompts.put("watch tv with me", "Oh, sure, I mean, I’m ok with anything really if y-you’re ok with it.");	
		fLevelChange.put("watch tv with me", 1);
		responsePrompts.put("build a snowman", "I mean, i-if you’re sure you’d want to do it with m-me, I guess that’d be fun.");	
		fLevelChange.put("build a snowman", 2);
		responsePrompts.put("take over the world", "I, uh, I don’t know about that. I’m n-not really ruler material.\nB-besides, I think I’d be more of a ‘rule-from-the-shadows’ kind of pig,\nlike a man-nipulative consultant or something.");	
		fLevelChange.put("take over the world", 1);
		responsePrompts.put("get a life", "Haha, that’s what I think every day...");
		fLevelChange.put("get a life", 1);
		responsePrompts.put("go to the bathroom", "N-no, I’m good.");	
		fLevelChange.put("go to the bathroom", 0);
		responsePrompts.put("lay on the ground and feel like trash", "Oh, I d-do that all the time. It lets me slow down and obsess over the inevitability of death.\nY-you do that too? I’m glad I’m not the only one.");
		fLevelChange.put("lay on the ground and feel like trash", 2);
		// "would you go to"
		responsePrompts.put("mars", "Gee, being abandoned up in space? T-that sounds kinda scary...");	
		fLevelChange.put("mars", -1);
		responsePrompts.put("the caribbean", "I’m, um, I’m pretty content just at home, so...");	
		fLevelChange.put("the caribbean", -1);
		responsePrompts.put("narnia", "Oh gee, I don’t think I’m r-really up to that kind of adventure. I prefer just to observe...");
		fLevelChange.put("narnia", -1);
		responsePrompts.put("the internets", "Y-yeah, I spend a lot of time on the internet, actually! It’s where all my friends are.\nAnd my enemies...");	
		fLevelChange.put("the internets", 2);
		responsePrompts.put("your room", "That’s, uh, that’s where I spend most of my time anyways, so...Yeah...");	
		fLevelChange.put("your room", 1);
		responsePrompts.put("my funeral", "Oh, yes, of course. I’ve always enjoyed funerals, so if you really don’t mind me being there...");
		fLevelChange.put("my funeral", 2);
		// "are you good at"
		responsePrompts.put("sports", "Um, all that comp-petitive stuff and t-team stuff isn’t really me...");	
		fLevelChange.put("sports", -2);
		responsePrompts.put("the arts", "Y-yeah, I really like drawing, actually! I mean, I’m probably not t-that good, but I’m pretty ok, I guess...");	
		fLevelChange.put("the arts", 2);
		responsePrompts.put("brain stuff", "Oh, I don’t know about that. I’ve n-never been that smart or anything...");	
		fLevelChange.put("brain stuff", -1);
		responsePrompts.put("being cool", "Oh, heavens no, I’m so uncool it’s a joke.");	
		fLevelChange.put("being cool", -2);
		responsePrompts.put("breathing", "Um, not really, actually.");	
		fLevelChange.put("breathing", 0);
		responsePrompts.put("procrastinating", "Y-yeah, I guess I am pretty good at that. N-not that it’s anything to be p-proud of, but at least it’s a skill, right?");	
		fLevelChange.put("procrastinating", 1);
		responsePrompts.put("over-analyzing", "N-not really. Sometimes, I think I don’t think about things at all.");	
		fLevelChange.put("over-analyzing", 0);
		responsePrompts.put("everything", "H-haha, nice joke.");	
		fLevelChange.put("everything", 0);
		// "are you scared of"
		responsePrompts.put("idiots", "Oh, n-no, I mean, they can’t help it, right?");
		fLevelChange.put("idiots", 0);
		responsePrompts.put("insomnia", "Um, I don’t really s-sleep anyways, so...I stay up all night and stare at my computer screen, haha...");	
		fLevelChange.put("insomnia", 0);
		responsePrompts.put("the dark side", "I-I think I might have joined that years ago...");	
		fLevelChange.put("the dark side", 0);
		responsePrompts.put("public speaking", "Oh, y-yes! I’m terrified of it, actually, haha...B-but I guess that’s kind of obvious, huh?");	
		fLevelChange.put("public speaking", 2);
		responsePrompts.put("people knowing how dead you are inside", "Oh, so you noticed, huh...Well, it was probably pretty obvious, so...");
		fLevelChange.put("people knowing how dead you are inside", 2);
		// "are you actually"
		responsePrompts.put("a zombie", "N-no, but I mean, what’s the difference, right?");
		fLevelChange.put("a zombie", 0);
		responsePrompts.put("a unicorn", "Oh gee, you really think so? I mean, the answers no, but...");
		fLevelChange.put("a unicorn", 1);
		responsePrompts.put("a sloth", "Oh, uh, I thought I was a pig.");	
		fLevelChange.put("a sloth", 0);
		responsePrompts.put("a smartass", "Oh, n-no, I could n-never. I d-don’t have the guts.");
		fLevelChange.put("a smartass", -2);
		responsePrompts.put("a jedi master", "Haha, jedi masters are a b-bit too tough for me to be one, you know?");	
		fLevelChange.put("a jedi master", -1);
		responsePrompts.put("the devil himself", "Oh, I’m no devil. One of his devoted followers, maybe, but not the devil himself...");	
		fLevelChange.put("the devil himself", 2);
	}

}
