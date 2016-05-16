package org.vashonsd.pirateship.minigame.text.speech;

import java.util.HashMap;

public class JockSpeech implements SpeechBehavior {


	public static HashMap<String, String> responsePrompts = new HashMap<String, String>();
	public static HashMap<String, Integer> fLevelChange = new HashMap<String, Integer> ();
	
	public JockSpeech() {
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
		return "Alright, PUNK. Chop chop, rear in gear, lets go.";
	}

	public String getOutro() {
		return "Hey, I know you're a CRIMINAL and stuff, but I can tell,\nyou're MY kind of guy. So I'm gunna...BEND the rules a little bit,\nand let you go. So go on, SKEDDADLE, prisoner!";
	}

	public void setPigSpeech() {
		// "do you like"
		responsePrompts.put("food", "Well, sure. Food keeps me ENERGETIC. It keeps me PUMPED.");	
		fLevelChange.put("food", 1);
		responsePrompts.put("sci fi", "THAT NERDY SISSY STUFF?! NO WAY, MAN. I'm a pig with STANDARDS.");
		fLevelChange.put("sci fi", -2);
		responsePrompts.put("the super bowl", "HELL YEAH! NOTHING BETTER!!");
		fLevelChange.put("the super bowl", 2);
		responsePrompts.put("long graduation speeches", "ARE YOU KIDDING?! Do you like the sound of NAILS on a CHALKBOARD?!\nYEAH, that's what I THOUGHT. Don't ask DUMB questions!");	
		fLevelChange.put("long graduation speeches", -2);
		responsePrompts.put("all things", "NO WAY, man. There are a lot of things in this world that TICK ME OFF.");	
		fLevelChange.put("all things", 0);
		responsePrompts.put("voodoo", "NO WAY. Voodoo is for SISSIES who don't have the GUTS to fight for THEMSELVES!\nYou're not a sissy, ARE YOU?!");	
		fLevelChange.put("voodoo", -2);
		responsePrompts.put("putting people in their place", "YOU BET I DO. When someone annoys me, I give 'em a good PUNCH,\nRIGHT IN THEIR DUMB FACE.");	
		fLevelChange.put("putting people in their place", 2);
		// "do you think"
		responsePrompts.put("i'm pretty", "Yeah, I'd say you're PRETTY SISSY.");	
		fLevelChange.put("i'm pretty", 0);
		responsePrompts.put("you're pretty", "I don't need to be pretty, prisoner. I JUST NEED TO BE TOUGH!!");	
		fLevelChange.put("you're pretty", -1);
		responsePrompts.put("you're cool", "I was BORN TO BE COOL, BABY.");
		fLevelChange.put("you're cool", 2);
		responsePrompts.put("the end is nigh", "The end is only nigh WHEN I SAY IT CAN BE!");	
		fLevelChange.put("the end is nigh", -1);
		responsePrompts.put("we're in the matrix", "DON'T BE A NERD, NERD.");	
		fLevelChange.put("we're in the matrix", -2);
		responsePrompts.put("the government is made of alien lizards", "No, 'cuz I'm NOT AN IDIOT.");	
		fLevelChange.put("the government is made of alien lizards", -2);
		// "do you believe in"
		responsePrompts.put("ghosts", "NUH-UH, the dumb buggers are dead, they should STAY DOWN.");	
		fLevelChange.put("ghosts", -1);
		responsePrompts.put("the force", "The only force I believe in is ME!");	
		fLevelChange.put("the force", -1);
		responsePrompts.put("dumbledore", "Whoever that is, he sounds like a PANSY.");	
		fLevelChange.put("dumbledore", -1);
		responsePrompts.put("believing in things", "YOU BET I DO! Believing brings me PASSION!");	
		fLevelChange.put("believing in things", 1);
		responsePrompts.put("the moon", "I don't look to the skies, PUNK, the only place I look is\nRIGHT IN FRONT OF ME!!");
		fLevelChange.put("the moon", -1);
		responsePrompts.put("honest work", "THAT'S RIGHT I DO! Honest work is the ONLY work!");	
		fLevelChange.put("honest work", 2);
		responsePrompts.put("dumb luck", "DUMB LUCK IS FOR LOSERS!! The only luck I have is the kind I MAKE FOR MYSELF!");	
		fLevelChange.put("dumb luck", -2);
		responsePrompts.put("sleeping in", "NO, because I'm not a PANSY! I'm PUNCTUAL, PUNK!");	
		fLevelChange.put("sleeping in", -2);
		// "can you tell me"
		responsePrompts.put("a joke", "Sure, I got a GREAT one. It's a KNOCK KNOCK joke.\nWHERE THE DOOR IS YOUR FACE!!");	
		fLevelChange.put("a joke", 0);
		responsePrompts.put("a secret", "Secrets are for people who have things to HIDE, and I have NOTHING TO HIDE!");	
		fLevelChange.put("a secret", -1);
		responsePrompts.put("an idea", "Ideas are for IDIOTS who spend too much time PONDERING and too little time ACTING.\nAND I'M AN ACTING KIND OF GUY!!");	
		fLevelChange.put("an idea", -1);
		responsePrompts.put("some gossip", "PLEASE, do I look like some chatty GIRL to you?!\nAlthough I did overhear the other day...");	
		fLevelChange.put("some gossip", 0);
		responsePrompts.put("the meaning of life", "SIMPLE, PUNK! IT'S WINNING! WIN, WIN, WIN!!");	
		fLevelChange.put("the meaning of life", 2);
		responsePrompts.put("something cool", "YOU BET I CAN! I'll tell you my motto in life, that's the COOLEST thing I KNOW.\nWHEN IN DISTRESS, PUNCH!!\nIt's a cool motto, so DON'T STEAL IT!");	
		fLevelChange.put("something cool", 2);
		responsePrompts.put("something weird", "What's weird is you asking me to TELL YOU SOMETHING WEIRD.");	
		fLevelChange.put("something weird", 0);
		responsePrompts.put("something", "YOUR MOM!");	
		fLevelChange.put("something", 0);
		// "can you give me"
		responsePrompts.put("something to eat", "DO I LOOK LIKE AN EFFIN' SNACK BAR?!");	
		fLevelChange.put("something to eat", 0);
		responsePrompts.put("a smile", "Smiles are for WEENIES.");	
		fLevelChange.put("a smile", 0);
		responsePrompts.put("advice", "My advice is SIMPLE. If you don't like it, PUNCH.");	
		fLevelChange.put("advice", 1);
		responsePrompts.put("a sweet hotwheels collection", "I see YOU have an appreciation for the GREATER things in life!\nNOTHIN'S BETTER THAN A SWEET RIDE!");	
		fLevelChange.put("a sweet hotwheels collection", 2);
		responsePrompts.put("your hand in marriage", "NO WAY, I'm a PROUD, SMELLY BACHELOR!!!");	
		fLevelChange.put("your hand in marriage", -1);
		// "can you do"
		responsePrompts.put("a backflip", "YOU BETCHA I CAN! AHYUP-OW!\nI TOTALLY DID IT, STOP LOOKING AT ME LIKE THAT!");	
		fLevelChange.put("a backflip", 2);
		responsePrompts.put("magic", "The only magic here is MY FISTS! AND THEY BE FLYING!!");	
		fLevelChange.put("magic", 0);
		responsePrompts.put("a tumblr", "No, I don't tumble anywhere! BECAUSE GRAVITY HAS NOTHING ON THIS PIG!!");	
		fLevelChange.put("a tumblr", -1);
		responsePrompts.put("pi", "HA, math stuff is for LOSERS! AND I DON'T LOSE!!");
		fLevelChange.put("pi", -2);
		responsePrompts.put("murder", "If someone PISSES me OFF enough, THEN I PUNCH HIM!\nThen, I give him a stern but gentle, 'no', because I'm a forgiving kind of pig.\nGod, I'm not a MONGREL.");	
		fLevelChange.put("murder", -1);
		responsePrompts.put("absolutely nothing", "PLEASE, I don't have TIME to do NOTHING.\nI ONLY HAVE TIME TO DO EVERYTHING!!");	
		fLevelChange.put("absolutely nothing", -2);
		// "would you like to"
		responsePrompts.put("watch tv with me", "SURE, but only if we're watching SPORTS! (Or Desperate Housewives).\nNO WAIT, I DIDN'T SAY THAT! MY WIFE LIKES THAT! SHUT UP!");	
		fLevelChange.put("watch tv with me", 0);
		responsePrompts.put("build a snowman", "Playing in the snow like a little kid? YOU BET! A REAL PIG CAN EMBRACE HIS CHILDISH SIDE!!");	
		fLevelChange.put("build a snowman", 2);
		responsePrompts.put("take over the world", "YEAH, I LIKE IT! I'M IN TO IT!!");	
		fLevelChange.put("take over the world", 2);
		responsePrompts.put("get a life", "HEY, you don't have to be so HURTFUL! PUNK!!");
		fLevelChange.put("get a life", -1);
		responsePrompts.put("go to the bathroom", "Maybe I'll take YOU to the bathroom! AND GIVE YOU A SWIRLY!!");	
		fLevelChange.put("go to the bathroom", 0);
		responsePrompts.put("lay on the ground and feel like trash", "NO, because THIS PIG isn't TRASH!");	
		fLevelChange.put("lay on the ground and feel like trash", -2);
		// "would you go to"
		responsePrompts.put("mars", "Sounds like a place for an AMBITOUS kind of pig! AND I'M JUST THE PIG FOR THE JOB!\nALRIGHT, SEND ME UP!!\nOh, you meant that hypothetically...");	
		fLevelChange.put("mars", 1);
		responsePrompts.put("the caribbean", "Like where PIRATES are? YOU BET I WANT TO FIGHT A PIRATE!");	
		fLevelChange.put("the caribbean", 2);
		responsePrompts.put("narnia", "Hey, I'm an ADVENTUROUS kind of pig! So WHY NOT?!");	
		fLevelChange.put("narnia", 1);
		responsePrompts.put("the internets", "HA, I got no TIME for internet shenanigans! I'M A PIG ABOUT THE HERE AND NOW!\nHold on, that sounded pretty good, I'm going to tweet it.\nPig...about......here..and..now!\nAnd, Tweeted!\n...I'm sorry, were you saying something?");	
		fLevelChange.put("the internets", 0);
		responsePrompts.put("your room", "People who spend all day in their rooms are WEAK WEENIES!");	
		fLevelChange.put("your room", -2);
		responsePrompts.put("my funeral", "Sounds BORING!!");	
		fLevelChange.put("my funeral", -2);
		// "are you good at"
		responsePrompts.put("sports", "YEAH!! I PLAY sports, BREATHE sports, LIVE SPORTS!!\nSome people wonder how I breathe them. And to that, I have two words:\nsmelly socks.");	
		fLevelChange.put("sports", 2);
		responsePrompts.put("the arts", "Like I have TIME for that! Sure, I can SLAP a paintbrush on a paper. BIG WHOOP.");	
		fLevelChange.put("the arts", -2);
		responsePrompts.put("brain stuff", "HA, I'M A MUSCLE KIND OF GUY!!");	
		fLevelChange.put("brain stuff", -1);
		responsePrompts.put("being cool", "When you're as BUFF as me, it's impossible NOT to be COOL!");	
		fLevelChange.put("being cool", 1);
		responsePrompts.put("breathing", "YEAH! I HAVE SO MANY TALENTS!!");	
		fLevelChange.put("breathing", 1);
		responsePrompts.put("procrastinating", "NO WAY! I'm a pig of ACTION!!!");	
		fLevelChange.put("procrastinating", -2);
		responsePrompts.put("over-analyzing", "What's this ANALYZING thing?! My analysis is simple: DO I PUNCH, OR NOT?\nAND THE ANSWER IS ALWAYS PUNCH!!");	
		fLevelChange.put("over-analyzing", -1);
		responsePrompts.put("everything", "NATURALLY!!");	
		fLevelChange.put("everything", 1);
		// "are you scared of"
		responsePrompts.put("idiots", "Hey, WATCH your MOUTH. Most of my FRIENDS are IDIOTS!!");	
		fLevelChange.put("idiots", 0);
		responsePrompts.put("insomnia", "NO, because if I WANNA SLEEP, then gosh darn, I'M GUNNA SLEEP!");	
		fLevelChange.put("insomnia", -1);
		responsePrompts.put("the dark side", "I FACE THE DARKNESS WITH FIRE IN MY HEART! NOTHING INTIMIDATES ME!!");	
		fLevelChange.put("the dark side", -1);
		responsePrompts.put("public speaking", "Listen, you PANSY, I don't DO public speaking!\nI DO PUBLIC YELLING! AAAAAAARRRRGGGHH!!");	
		fLevelChange.put("public speaking", -2);
		responsePrompts.put("people knowing how dead you are inside", "I'm the ALIVE-EST pig I KNOW, GOSH DARNIT!!");	
		fLevelChange.put("people knowing how dead you are inside", -1);
		// "are you actually"
		responsePrompts.put("a zombie", "HA! AS IF!! When the zombie apocolypse finally hits,\nI'M GOING OUT THERE WITH MY BASEBALL BAT AND MY REVOLVER, AND I'M MOWING THOSE SUCKERS DOWN!!");	
		fLevelChange.put("a zombie", -1);
		responsePrompts.put("a unicorn", "If I was, I'd be a REALLY COOL, MUSCLEY UNICORN.");	
		fLevelChange.put("a unicorn", 0);
		responsePrompts.put("a sloth", "Don't laugh, sloths are NATURAL BORN WARRIORS. HAVE YOU SEEN THEIR CLAWS?!");
		fLevelChange.put("a sloth", 1);
		responsePrompts.put("a smartass", "NOT AT ALL! I'm a straight forward kind of pig. I SAY what I mean, and I MEAN what I SAY!!");	
		fLevelChange.put("a smartass", -1);
		responsePrompts.put("a jedi master", "Don't know about that Jedi NONSENSE, BUT I'M CERTAINTLY A MASTER!!");	
		fLevelChange.put("a jedi master", 0);
		responsePrompts.put("the devil himself", "No, BUT I COULD TOTALLY TAKE HIM ON!!");	
		fLevelChange.put("the devil himself", 0);
	}

}
