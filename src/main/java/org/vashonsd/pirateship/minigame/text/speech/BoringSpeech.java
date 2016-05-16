package org.vashonsd.pirateship.minigame.text.speech;

import java.util.HashMap;

public class BoringSpeech implements SpeechBehavior {

	public static HashMap<String, String> responsePrompts = new HashMap<String, String>();
	public static HashMap<String, Integer> fLevelChange = new HashMap<String, Integer> ();
	
	public BoringSpeech() {
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
		return "So, uh, I guess it's time for you to die.";
	}

	public String getOutro() {
		return "You know, I came here to take you to get executed.\nBut you're pretty nice, I guess. Maybe I'll let you go.\nYeah...";
	}

	public void setPigSpeech() {
		// "do you like"
		responsePrompts.put("food", "Food? Yeah, food is good. Eating is...good.\nOne of the bare necessities of life.");	
		fLevelChange.put("food", 2);
		responsePrompts.put("sci fi", "Oh, no, I don’t really like sci fi. Too exciting.\nI prefer watching the news or, uh, reading the phone book.");
		fLevelChange.put("sci fi", -1);
		responsePrompts.put("the super bowl", "Um, no, not really. Everything just happens so fast and\nI don’t really know what’s going on.");
		fLevelChange.put("the super bowl", -1);
		responsePrompts.put("long graduation speeches", "Oh yeah, I really like those. Just the right blend of bland and uninspiring.\nIt makes me feel joy in my little piggy heart.");	
		fLevelChange.put("long graduation speeches", 2);
		responsePrompts.put("all things", "Um, I’m not opinionated enough to dislike things, so I guess the answer is yes.");	
		fLevelChange.put("all things", 1);
		responsePrompts.put("voodoo", "Um, that sounds dangerous, and I’m a strong supporter of bland and excessive safety measures, so...");	
		fLevelChange.put("voodoo", -2);
		responsePrompts.put("putting people in their place", "Oh, conflict. I’m not very good with conflict...Um...");
		fLevelChange.put("putting people in their place", -2);
		// "do you think"
		responsePrompts.put("i'm pretty", "Oh no, opinions, I’m not very good at giving opinions…Oh no...");	
		fLevelChange.put("i'm pretty", -1);
		responsePrompts.put("you're pretty", "Me? No, I’m too bland to be pretty...");	
		fLevelChange.put("you're pretty", -1);
		responsePrompts.put("you're cool", "No, no, I’m like the opposite of cool.\nI’m so uncool, cool people see me and run in the opposite direction....");	
		fLevelChange.put("you're cool", -1);
		responsePrompts.put("the end is nigh", "I wouldn’t know about that kind of stuff, I’m always out of the loop...");	
		fLevelChange.put("the end is nigh", -1);
		responsePrompts.put("we're in the matrix", "I’m sorry, I don’t know what this matrix is.\nI’m never in the know with these popular things...");	
		fLevelChange.put("we're in the matrix", -1);
		responsePrompts.put("the government is made of alien lizards", "I, uh, I don’t know what that means. I’m sorry...");	
		fLevelChange.put("the government is made of alien lizards", -1);
		// "do you believe in"
		responsePrompts.put("ghosts", "I don’t think so. I’ve never seen one.\nI mean, not that they’d want to hang out me if they did anyways...");	
		fLevelChange.put("ghosts", 0);
		responsePrompts.put("the force", "What force? I don’t really like using forceful measures, so...");	
		fLevelChange.put("the force", -1);
		responsePrompts.put("dumbledore", "Who’s that? Are they popular? I don’t know about anyone popular nowadays…\nI mean, not that I ever did...");	
		fLevelChange.put("dumbledore", -1);
		responsePrompts.put("believing in things", "Believing in believing in things. You know, that has a nice ring to it.\nIt’s just the right level of dumbly nonspecific for me.");	
		fLevelChange.put("believing in things", 2);
		responsePrompts.put("the moon", "Oh, yes, the moon is nice. It’s...in the sky.");	
		fLevelChange.put("the moon", 1);
		responsePrompts.put("honest work", "Yes, I work honestly every day like every other working pig.");	
		fLevelChange.put("honest work", 1);
		responsePrompts.put("dumb luck", "Oh, I don’t know. I’ve never been lucky before in my life...");	
		fLevelChange.put("dumb luck", -1);
		responsePrompts.put("sleeping in", "Sleeping is good, but I don’t sleep in. I wake up every morning at exactly 6:30 am,\ndo my ears, put on my uniform, and go to work.\nYou want to know my alarm tone?\n...It’s the default alarm tone.");	
		fLevelChange.put("sleeping in", 0);
		// "can you tell me"
		responsePrompts.put("a joke", "Oh no, I don’t think I’m funny enough to tell a good joke, I’m sorry...");	
		fLevelChange.put("a joke", -1);
		responsePrompts.put("a secret", "Um, ok, but you have to promise you won’t tell anyone else, alright?\nSo, uh, the truth is, well....\nSome nights, I go to bed without brushing my teeth.\nUm, that’s it.\nWow, I can’t believe I said that, I’ve never told anyone that before…");	
		fLevelChange.put("a secret", 1);
		responsePrompts.put("an idea", "Wow, you want to hear one of my ideas? No one’s wanted to before…\nWell, alright, if you’re sure, I suppose I could tell you…\n……...……..I, uh, forgot…");	
		fLevelChange.put("an idea", 1);
		responsePrompts.put("some gossip", "Oh, no, I’m never in the loop about anything, I’m sorry...");	
		fLevelChange.put("some gossip", -2);
		responsePrompts.put("the meaning of life", "Oh, I wouldn’t know something like that.\nI’m just a simple pig living a simple pig life....");	
		fLevelChange.put("the meaning of life", 0);
		responsePrompts.put("something cool", "I’m sorry, I think I’m really the wrong pig to be asking that.\nI wouldn’t know cool if it slapped me upside the face…\nAt least, that’s what all my colleagues tell me.");	
		fLevelChange.put("something cool", -2);
		responsePrompts.put("something weird", "Oh gee, I really don’t know what to tell you.\nI could tell you something boring, if you want. I know lots of stuff like that...");	
		fLevelChange.put("something weird", -1);
		responsePrompts.put("something", "Just something? That’s so boringly general…\nIt’s perfect for me. I like it.");	
		fLevelChange.put("something", 2);
		// "can you give me"
		responsePrompts.put("a smile", "No, I don’t think so. Sorry, but my pig face seems to be forever trapped in ‘stony silence’.\nI’m sorry...");	
		fLevelChange.put("a smile", 0);
		responsePrompts.put("advice", "Advice? Are you sure? My advice is pretty boring…\nBut, um, if you want to hear from me, my advice is…\nAlways buckle your seatbelt….Yeah.");	
		fLevelChange.put("advice", 1);
		responsePrompts.put("a sweet hotwheels collection", "Um, I don’t think I have one of those.\nI’m not a believer in needless accessory items.");	
		fLevelChange.put("a sweet hotwheels collection", -1);
		responsePrompts.put("your hand in marriage", "Oh, no, I'm sorry. I mean I appreciate the sentiment\nI'm just not really the romantic type.");	
		fLevelChange.put("your hand in marriage", 0);
		// "can you do"
		responsePrompts.put("a backflip", "No, no, I don’t think I could do that. I’d probably fall and break my neck,\nand broken necks are a serious health hazard I’ve heard.");	
		fLevelChange.put("a backflip", -1);
		responsePrompts.put("magic", "Magic? No, being able to do magic requires being interesting,\nand I’m just not interesting...");	
		fLevelChange.put("magic", -2);
		responsePrompts.put("a tumblr", "Tumbler? Like falling? Because, I mean, I fall down all the time, so I guess so.");	
		fLevelChange.put("a tumblr", 1);
		responsePrompts.put("pi", "Um, 3 point...something, I guess…\nSorry, I was never very good at math...");	
		fLevelChange.put("pi", 0);
		responsePrompts.put("murder", "Oh dear, no, no. I’m an upstanding citizen - I follow the law to the dot.");	
		fLevelChange.put("murder", -2);
		responsePrompts.put("absolutely nothing", "Oh, yes, I can do that. My list of skills may be a small one,\nbut at least I can do that.");	
		fLevelChange.put("absolutely nothing", 2);
		// "would you like to"
		responsePrompts.put("watch tv with me", "Yes, I can do that. I always make sure to dedicate at least 3 hours a day to TV.\nMindless consumers don’t make themselves, after all.");	
		fLevelChange.put("watch tv with me", 2);
		responsePrompts.put("build a snowman", "No, sorry. I’m afraid building a snowman takes creative license,\nand I’m just not creative enough to do it...");	
		fLevelChange.put("build a snowman", -1);
		responsePrompts.put("take over the world", "That’s, uh, not a good idea. Pigs like me aren’t built for positions of leadership.");	
		fLevelChange.put("take over the world", -2);
		responsePrompts.put("get a life", "Oh, yes, that would be very nice. But dreams are just dreams...");	
		fLevelChange.put("get a life", 2);
		responsePrompts.put("go to the bathroom", "I suppose so, yes. Mundane, everyday activities like that fill me with happiness.");	
		fLevelChange.put("go to the bathroom", 2);
		responsePrompts.put("lay on the ground and feel like trash", "Yes, I do that all the time, actually. I’m very good at it, not to brag or anything...");	
		fLevelChange.put("lay on the ground and feel like trash", 2);
		// "would you go to"
		responsePrompts.put("mars", "Barren terrain, as far as the eye can see?\nI suppose, it wouldn’t be much different from my room...");	
		fLevelChange.put("mars", 2);
		responsePrompts.put("the caribbean", "No, I’m not a pig for vacations. I hold a strong belief in the importance boring, ever day routine.");	
		fLevelChange.put("the caribbean", -1);
		responsePrompts.put("narnia", "No, certainly not. Sounds like too much excitement for a solitary pig like me.");	
		fLevelChange.put("narnia", -2);
		responsePrompts.put("the internets", "Um, no, not really. All this newfangled internet stuff goes over my head.");	
		fLevelChange.put("the internets", 0);
		responsePrompts.put("your room", "Oh, yes, I go there every day. How did you know?");	
		fLevelChange.put("your room", 2);
		responsePrompts.put("my funeral", "Uh, I suppose I would, but just to be polite.");	
		fLevelChange.put("my funeral", 0);
		// "are you good at"
		responsePrompts.put("sports", "Uh, no, not really. My little pig hoofs are a little uncoordinated.\nI’m pretty good at watching other people play sports, though.");	
		fLevelChange.put("sports", 0);
		responsePrompts.put("the arts", "No, I have no eye for the arts. I’m like the artists equivalent of tonedeaf.");	
		fLevelChange.put("the arts", 0);
		responsePrompts.put("brain stuff", "Not really. I’m pretty good at the opposite, though, whatever that is.");	
		fLevelChange.put("brain stuff", 0);
		responsePrompts.put("being cool", "Oh, absolutely not. I’m like, the uncoolest pig you’ll ever know.");	
		fLevelChange.put("being cool", -2);
		responsePrompts.put("breathing", "Yes, actually, I’m really good at breathing. I do it every day.");	
		fLevelChange.put("breathing", 2);
		responsePrompts.put("procrastinating", "No, not really. I’ve always been a pig to stick to schedules.\nIt’s all I have in life.");	
		fLevelChange.put("procrastinating", -1);
		responsePrompts.put("over-analyzing", "I prefer not to analyze at all. Turning my brain off has always suited me better.");	
		fLevelChange.put("over-analyzing", -1);
		responsePrompts.put("everything", "No, and I prefer it that way. The background has always been my niche.");	
		fLevelChange.put("everything", -1);
		// "are you scared of"
		responsePrompts.put("idiots", "Why would I be afraid of myself?");	
		fLevelChange.put("idiots", 0);
		responsePrompts.put("insomnia", "I suppose so. Not sleeping at night means deviation from my carefully laid out routine,\nand that’s kind of scary.");	
		fLevelChange.put("insomnia", 1);
		responsePrompts.put("the dark side", "The dark side of what? The moon? The moon is pretty nice.");	
		fLevelChange.put("the dark side", 0);
		responsePrompts.put("public speaking", "No, I suppose not, for a simple reason.\nI don’t do it.");	
		fLevelChange.put("public speaking", 0);
		responsePrompts.put("people knowing how dead you are inside", "I’m confused. How can I only be dead on the inside?\nShouldn’t being dead affect all of me?");	
		fLevelChange.put("people knowing how dead you are inside", 0);
		// "are you actually"
		responsePrompts.put("a zombie", "Sometimes I think I am...");	
		fLevelChange.put("a zombie", 2);
		responsePrompts.put("a unicorn", "No, unicorns are far too colorful and magical for me.");	
		fLevelChange.put("a unicorn", -1);
		responsePrompts.put("a sloth", "I’m a pig.");	
		fLevelChange.put("a sloth", 0);
		responsePrompts.put("a smartass", "Oh heavens, no. That would require me to have a personality.");	
		fLevelChange.put("a smartass", -2);
		responsePrompts.put("a jedi master", "What’s this about a dye master? I prefer all my colors in grayscale, honestly...");	
		fLevelChange.put("a jedi master", -1);
		responsePrompts.put("the devil himself", "Oh no, I’m far too low on the pecking order of life to be him.");	
		fLevelChange.put("the devil himself", -1);

	}

}
