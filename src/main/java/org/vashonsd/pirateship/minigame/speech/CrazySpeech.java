package org.vashonsd.pirateship.minigame.speech;

import java.util.HashMap;

public class CrazySpeech implements SpeechBehavior {

	public static HashMap<String, String> responsePrompts = new HashMap<String, String>();
	public static HashMap<String, Integer> fLevelChange = new HashMap<String, Integer> ();
	
	public CrazySpeech() {
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
		return "Alrighty, foul criminal! Prepare to meet your maker.";
	}

	public String getOutro() {
		return "Hey, you know what? I think I kind of like you, criminal.\nOh, but I guess I was supposed to kill you?\nEh, I'm not really into that kind of thing anyways.\nGo free!";
	}

	public void setPigSpeech() {
		// "do you like"
		responsePrompts.put("food", "Well, sure! Food gives me STRENGTH to go on!!");	
		fLevelChange.put("food", 1);
		responsePrompts.put("sci fi", "Sci fi? No, I’m not into make believe. Only in seeking the TRUTH!");
		fLevelChange.put("sci fi", -1);
		responsePrompts.put("the super bowl", "Please, a pig as inspired and busy as I has no time to watch the SUPER BOWL.");
		fLevelChange.put("the super bowl", -1);
		responsePrompts.put("long graduation speeches", "Speeches are fine. But I like my speeches SHORT, SWEET, and PASSIONATE!");	
		fLevelChange.put("long graduation speeches", -1);
		responsePrompts.put("all things", "NATURALLY, I am a lover of ALL THINGS!");	
		fLevelChange.put("all things", 2);
		responsePrompts.put("voodoo", "Yeesh, that's DARK. I would NEVER stoop so low, I am a defender of JUSTICE.");	
		fLevelChange.put("voodoo", -1);
		responsePrompts.put("putting people in their place", "Of course! Using the iron fist of JUSTICE!");	
		fLevelChange.put("putting people in their place", 1);
		// "do you think"
		responsePrompts.put("i'm pretty", "Honey, you're GORGEOUS.\n....Just on the inside, you know? Everyone is!");
		fLevelChange.put("i'm pretty", 1);
		responsePrompts.put("you're pretty", "HAH! Of course I am! And this is all natural, baby.");	
		fLevelChange.put("you're pretty", 2);
		responsePrompts.put("you're cool", "Well of course! Self confidence is the mark of a cool pig,\nand I'm the most confident of the confident.");	
		fLevelChange.put("you're cool", 2);
		responsePrompts.put("the end is nigh", "Aha, so you know about that too?! The world might not have neded in 2012, I concede,\nbut it's coming! Mark my words, mortal.");	
		fLevelChange.put("the end is nigh", 2);
		responsePrompts.put("we're in the matrix", "Well, I won't discount it as a possible theory.");	
		fLevelChange.put("we're in the matrix", 1);
		responsePrompts.put("the government is made of alien lizards", "YOU THINK SO TOO?! They try to hide it, but they can't hide\nANYTHING from the prying eyes of THIS PIG.");	
		fLevelChange.put("the government is made of alien lizards", 2);
		// "do you believe in"
		responsePrompts.put("ghosts", "Most definitely. I'm almost certain my house is currently haunted by a poltergeist.\nI came home yesterday to find that someone had consumed my entire stash of chocolate.\nWorst of all, they tried to frame me by putting chocolate smear all over my mouth!\nHey, don't look at me like that; it wasn't me, ok?!");	
		fLevelChange.put("ghosts", 2);
		responsePrompts.put("the force", "If it DID exist, don't you think I would have figured out how to use it by now?!");	
		fLevelChange.put("the force", 0);
		responsePrompts.put("dumbledore", "Absolutely! Dumbledore is my bae.");	
		fLevelChange.put("dumbledore", 2);
		responsePrompts.put("believing in things", "I AM A MOST AVID BELIEVER IN BELIEVING IN THINGS!\nAfter all, if you don't believe in that, what is there left to believe in?\nWow, I'm deep...");	
		fLevelChange.put("believing in things", 2);
		responsePrompts.put("the moon", "Oho! So you've noticed to!\nI have a theory, you see, that the moon is actually just a hologram projected by the government.\nClearly they're hiding something...\nI'm glad I'm not the only one who's realized.\n...That is why you asked, right?");	
		fLevelChange.put("the moon", 2);
		responsePrompts.put("honest work", "Well of course! All the work I do is honest!");	
		fLevelChange.put("honest work", 1);
		responsePrompts.put("dumb luck", "Everyone knows there's no such thing as luck. Everything that happens is preordained by our lord and savior,\nthe flying spaghetti monster.");	
		fLevelChange.put("dumb luck", -2);
		responsePrompts.put("sleeping in", "Absolutely not, I'm a morning pig. I'm too hyperactive to sleep in anyways.\nAt least, that's what my mommy pig tells me.");	
		fLevelChange.put("sleeping in", -1);
		// "can you tell me"
		responsePrompts.put("a joke", "Oh man, I've got a great one! Ok, so a pig walks into a bar and blah blah\nblahblah blah BLAH blah blah blaaaah\nAnd then he says, blah BLAH blah blahBLAH blah,\n and he's like BLAHBLAH blaaaaah blah,\nand so the bartender says, 'A nickle? More like a PICKLE!'\nWhy aren't you laughing?");
		fLevelChange.put("a joke", 2);
		responsePrompts.put("a secret", "HAH! This pig is a believer in honesty. I don't keep secrets!\nMostly because I'm really bad at keeping my mouth shut!\nOh, shoot, I wasn't supposed to tell you that...");	
		fLevelChange.put("a secret", -1);
		responsePrompts.put("an idea", "Oh, man, do I have ideas gallore! Prime example: I'm pretty sure the moon landing was completely faked using a green screen.\nThey thought they could fool me, but Im to smrat four em!");	
		fLevelChange.put("an idea", 2);
		responsePrompts.put("some gossip", "This pig does not resort to such underhanded treachery! Begone with you, gossiper!");
		fLevelChange.put("some gossip", -2);
		responsePrompts.put("the meaning of life", "The meaning of life is LIVING! You should be glad such an expert on the subject is here to answer you!");	
		fLevelChange.put("the meaning of life", 2);
		responsePrompts.put("something cool", "The coolest thing I know of? Easy. Socks and sandles.\nThe ladies will be jumping all over you if you adhere to MY cool fashion trends.");	
		fLevelChange.put("something cool", 1);
		responsePrompts.put("somethign weird", "What's weird to me is that people haven't caught on to the fact that\nthe ILLUMINATI IS REAL, there is CLEAR, SCIENTIFIC PROOF and\nwe need to STAND UP AGAINST THEM before it's TOO LATE.");	
		fLevelChange.put("something weird", 1);
		responsePrompts.put("something", "Like...anything?\nOh no, so many choices on what to say, my tiny brain can't comprehend the possibilities!");	
		fLevelChange.put("something", -2);
		// "can you give me"
		responsePrompts.put("something to eat", "Certainly! I am always a pig ready and willing to help!\nLucky for you, I have some pig gruel on hand. Looks like a mix of...orange peels, some leftover ravioli, and...whatever...that is...\nHey, what's with that face? You don't want it anymore?");	
		fLevelChange.put("something to eat", 1);
		responsePrompts.put("a smile", "Friend, you're talking to the smiling champion here!\nLast time I smiled, people went blind from the sheer beauty of it!");	
		fLevelChange.put("a smile", 2);
		responsePrompts.put("advice", "My advice? Don't put metal in the microwave, no matter how tempting it might be.\nN-not that I'm speaking from experience or anything, mind you.");	
		fLevelChange.put("advice", 1);
		responsePrompts.put("a sweet hotwheels collection", "Sure! You can borrow mine. 210 cars, all in mint condition.");	
		fLevelChange.put("a sweet hotwheels collection", 1);
		responsePrompts.put("your hand in marriage", "Oh my! How bold! Well, I accept!\nI'm thinking a Spring wedding...");	
		fLevelChange.put("your hand in marriage", 2);
		// "can you do"
		responsePrompts.put("a backflip", "Naturally, I am a master at backflips!\nJust yesterday, I almost did half of one, and I didn't even sprain anything!\nYou have my permission to applaud.");
		fLevelChange.put("a backflip", 1);
		responsePrompts.put("magic", "ALAKAZAM! ABRA KADABRA! ZING! KAPOW! WHOOSH!\n...I think that should answer your question.");	
		fLevelChange.put("magic", 2);
		responsePrompts.put("a tumblr", "Oh sure, I fall down hills all the time. On purpose, of course.\nJust checking if gravity is still working,\nfor the greater good of the general populous.");	
		fLevelChange.put("a tumblr", 0);
		responsePrompts.put("pi", "Pie? I love pie!");
		fLevelChange.put("pi", 1);
		responsePrompts.put("murder", "Never! I am a defender of justice!");	
		fLevelChange.put("murder", -2);
		responsePrompts.put("absolutely nothing", "I actually have a condition where it is physically impossible\nfor me to sit still for longer than two minutes.");	
		fLevelChange.put("absolutely nothing", -1);
		// "would you like to"
		responsePrompts.put("watch tv with me", "I don't watch TV shows. I LIVE THEM.");	
		fLevelChange.put("watch tv with me", -1);
		responsePrompts.put("build a snowman", "OOH, that sounds FUN. The lack of snow is a little discouraging,\nbut I've got some icecubes in my freezer at home, so I'm sure we can make it work.");
		fLevelChange.put("build a snowman", 2);
		responsePrompts.put("take over the world", "No, no, that would make us not better than the Illuminati.");	
		fLevelChange.put("take over the world", -2);
		responsePrompts.put("get a life", "Sure, I'd be more than happy to help you get a life!\nBut really, you shouldn't be so down on yourself, it's not healthy.");	
		fLevelChange.put("get a life", 1);
		responsePrompts.put("go to the bathroom", "I appreciate your being conciencious about my bladder and all, but I'm fine.");	
		fLevelChange.put("go to the bathroom", 0);
		responsePrompts.put("lay on the ground and feel like trash", "I'll pass. Lying on the ground is bad for your back, and I need to stay in PEEK condition!");	
		fLevelChange.put("lay on the ground and feel like trash", -1);
		// "would you go to"
		responsePrompts.put("mars", "Certainly! This pig is more than ready to search the FAR REACHES OF SPACE!!");
		fLevelChange.put("mars", 1);
		responsePrompts.put("the caribbean", "Never, I don't have time for relaxing vacations! My life is DEDICATED to the PEOPLE!");
		fLevelChange.put("the caribbean", -1);
		responsePrompts.put("narnia", "Would I ever?! Taking a selfie with Aslan is like, my DREAM.");
		fLevelChange.put("narnia", 2);
		responsePrompts.put("the internets", "Well yes, I'm a frequenter of these things called 'blogs'.\nThey're where I get all of my very accurate and factual information!");	
		fLevelChange.put("the internets", 1);
		responsePrompts.put("your room", "Why would I go there? It's not even bedtime! (Which is 8:00, by the way. I know, Mom let's me stay up so late.)");
		fLevelChange.put("your room", -1);
		responsePrompts.put("my funeral", "Sure, and I'll even give a heartfelt goodbye speech about you, err...Whatever your name is.");	
		fLevelChange.put("my funeral", 0);
		// "are you good at"
		responsePrompts.put("sports", "No, I'm more of a solo guy, like the superheroes of old. None of that team nonsense.");	
		fLevelChange.put("sports", -1);
		responsePrompts.put("the arts", "Um, I mean, I can draw...lines...squiggles...lumpy circles...");
		fLevelChange.put("the arts", -1);
		responsePrompts.put("brain stuff", "Shure, Im graet at brane stuff. Im kinda liek einstien, relly.");	
		fLevelChange.put("brain stuff", 1);
		responsePrompts.put("being cool", "All superheroes are cool, and I'm like a real world superhero, so naturally, that means I'm SUPRE COOL.");	
		fLevelChange.put("being cool", 1);
		responsePrompts.put("breathing", "Oh yeah, I've got the art of breathing down to a science.\nTook my years of intensive study to learn. You can be impressed.");	
		fLevelChange.put("breathing", 1);
		responsePrompts.put("procrastinating", "When things need to get done, I DO THEM. Don't even USE that word around me.");
		fLevelChange.put("procrastinating", -2);
		responsePrompts.put("over-analyzing", "Oh man, you don't even KNOW, friend, how good I am at that.\nIt's like, how can someone be so good? That's what people say.");
		fLevelChange.put("over-analyzing", 2);
		responsePrompts.put("everything", "OH YEAH. Don't feel too bad, though. Pigs like me only come once every million years.");	
		fLevelChange.put("everything", 2);
		// "are you scared of"
		responsePrompts.put("idiots", "Certainly not. I don't fault them for being dumb. After all, it's hard to be as great as I am.");	
		fLevelChange.put("idiots", -1);
		responsePrompts.put("insomnia", "I've never had trouble sleeping, so no. Mom tells me I sleep like an angel.");	
		fLevelChange.put("insomnia", 0);
		responsePrompts.put("the dark side", "EVIL doesn't scare me! I SNEER in the face of EVIL.\nAnd maybe pee a little! But it's NOT pee of fear, it's pee of PASSION.");	
		fLevelChange.put("the dark side", 0);
		responsePrompts.put("public speaking", "Why would I fear public speaking when people practically BEG to hear my voice?");	
		fLevelChange.put("public speaking", -2);
		responsePrompts.put("people knowing how dead you are inside", "What are you talking about? I'm so alive, I, uh...\nWell, I don't have a good metaphor, but you get the idea!!");	
		fLevelChange.put("people knowing how dead you are inside", -2);
		// "are you actually"
		responsePrompts.put("a zombie", "Please, a pig as vibrant and lively as me could never be a zombie!");
		fLevelChange.put("a zombie", -2);
		responsePrompts.put("a unicorn", "OH NO! YOU'VE DISCOVERED MY SECRET!\nI will now use my unicorn powers to make you forget! Memories, BEGONE!\n...You've forgotten now.");	
		fLevelChange.put("a unicorn", 2);
		responsePrompts.put("a sloth", "Sloth? SLOTH?! NEVER!");
		fLevelChange.put("a sloth", -2);
		responsePrompts.put("a smartass", "HEY, WATCH YOUR LANGUAGE!");
		fLevelChange.put("a smartass", -2);
		responsePrompts.put("a jedi master", "Naturally, I am a master at everything, so the answer automatically defaults to yes.");	
		fLevelChange.put("a jedi master", 0);
		responsePrompts.put("the devil himself", "HAH, as if! I am the devils number one ADVERSARY! The devil QUAKES in fear when he hears my name!!");	
		fLevelChange.put("the devil himself", 0);
	}

}
