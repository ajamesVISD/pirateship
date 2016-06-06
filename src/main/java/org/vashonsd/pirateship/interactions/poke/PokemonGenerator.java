package org.vashonsd.pirateship.interactions.poke;

import java.util.*;

public class PokemonGenerator {
	PokeMoveGenerator gen;
	
	public PokemonGenerator() {
		gen = new PokeMoveGenerator();
	}
	
	public Pokemon charmander()
	{
		Pokemon charmander = new Pokemon("Charmander", "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.");
		charmander.setMaxHP(39);
		charmander.setHP(charmander.getMaxHP());
		charmander.setAttack(52);
		charmander.setDefense(43);
		charmander.setSpeed(65);
		charmander.setAccuracy(100);
		charmander.setType(new PokeType("fire"));
		
		ArrayList<PokeMove> learnable = new ArrayList<PokeMove>();
		learnable.add(gen.scratch());
		learnable.add(gen.growl());
		learnable.add(gen.tailWhip());
		learnable.add(gen.ember());
		learnable.add(gen.rage());
		charmander.setLearnable(learnable);
		
		charmander.setPrintOut(
"              _.--\"\"`-..\n" +
"            ,'          `.\n" +
"          ,'          __  `.\n" +
"         /|          \" __   \\" + "\n" +
"        , |           / |.   .\n" +
"        |,'          !_.'|   |\n" +
"      ,'             '   |   |\n" +
"     /              |`--'|   |\n" +
"    |                `---'   |\n" +
"     .   ,                   |                       ,\".\n" +
"      ._     '           _'  |                    , ' \\ `\n" +
"  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|\n" +
"  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\" + "\n" +
"-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .\n" +
"  `,         \"\"\"\"'     `.              ,'         |   |  ',,\n" +
"    `.      '            '            /          '    |'. |/\n" +
"      `.   |              \\       _,-'           |       ''\n" +
"        `._'               \\   '\"\\                .      |\n" +
"           |                '     \\                `._  ,'\n" +
"           |                 '     \\                 .'|\n" +
"           |                 .      \\                | |\n" +
"           |                 |       L              ,' |\n" +
"           `                 |       |             /   '\n" +
"            \\                |       |           ,'   /\n" +
"          ,' \\               |  _.._ ,-..___,..-'    ,'\n" +
"         /     .             .      `!             ,j'\n" +
"        /       `.          /        .           .'/\n" +
"       .          `.       /         |        _.'.'\n" +
"        `.          7`'---'          |------\"'_.'\n" +
"       _,.`,_     _'                ,''-----\"'\n" +
"   _,-_    '       `.     .'      ,\\" + "\n" +
"   -\" /`.         _,'     | _  _  _.|\n" +
"    \"\"--'---\"\"\"\"\"'        `' '! |! /\n" +
"                            `\" \" -' ");

	ArrayList<String> head = new ArrayList<String>();
		head.add("          _.--\"\"`-..       ");
		head.add("        ,'          `.     ");
		head.add("      ,'          __  `.   ");
		head.add("     /|          \" __   \\  ");
		head.add("    , |           / |.   . ");
		head.add("    |,'          !_.'|   | ");
		head.add("  ,'             '   |   | ");
		head.add(" /              |`--'|   | ");
		head.add("|                `---'   | ");
		head.add(" .   ,                   | ");
		head.add("  ._     '           _'  | ");
		head.add("  `.`-...___,...---\"\"  |   ");
		head.add("    `._        _,-,.'   .| ");
		head.add("     `. `-..--_.,.<     /  ");
		head.add("                           ");
		head.add("                           ");
	charmander.setHead(head);
	
	return charmander;
	}
	
	
	public Pokemon squirtle()
	{
		Pokemon squirtle = new Pokemon("Squirtle", "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.");
		squirtle.setMaxHP(44);
		squirtle.setHP(squirtle.getMaxHP());
		squirtle.setAttack(48);
		squirtle.setDefense(65);
		squirtle.setSpeed(43);
		squirtle.setAccuracy(100);
		squirtle.setType(new PokeType("water"));
		
		ArrayList<PokeMove> learnable = new ArrayList<PokeMove>();
		learnable.add(gen.tackle());
		learnable.add(gen.growl());
		learnable.add(gen.tailWhip());
		learnable.add(gen.bubble());
		learnable.add(gen.waterGun());
		learnable.add(gen.withdraw());
		squirtle.setLearnable(learnable);
		
		squirtle.setPrintOut( 
"	                 _,........__\n" +
"	              ,-'            \"`-.\n" +
"	            ,'                   `-.\n" +
"	          ,'                        \\" + "\n" +
"	        ,'                           .\n" +
"	        .'\\               ,\"\".       `\n" +
"	       ._.'|             / |  `       \\" + "\n" +
"	       |   |            `-.'  ||       `.\n" +
"	       |   |            '-._,'||       | \\" + "\n" +
"	       .`.,'             `..,'.'       , |`-.\n" +
"	       l                       .'`.  _/  |   `.\n" +
"	       `-.._'-   ,          _ _'   -\" \\  .     `\n" +
"	  `.\"\"\"\"\"'-.`-...,---------','         `. `....__.\n" +
"	  .'        `\"-..___      __,'\\          \\  \\     \\" + "\n" +
"	  \\_ .          |   `\"\"\"\"'    `.           . \\     \\" + "\n" +
"	    `.          |              `.          |  .     L\n" +
"	      `.        |`--...________.'.        j   |     |\n" +
"	        `._    .'      |          `.     .|   ,     |\n" +
"	           `--,\\       .            `7\"\"' |  ,      |\n" +
"	              ` `      `            /     |  |      |    _,-'\"\"\"`-.\n" +
"	               \\ `.     .          /      |  '      |  ,'          `.\n" +
"	                \\  v.__  .        '       .   \\    /| /              \\" + "\n" +
"	                 \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\n" +
"	                  `        .        `._ ___,j.  `/ .-       ,---.     |\n" +
"	                  ,`-.      \\         .\"     `.  |/        j     `    |\n" +
"	                 /    `.     \\       /         \\ /         |     /    j\n" +
"	                |       `-.   7-.._ .          |\"          '         /\n" +
"	                |          `./_    `|          |            .     _,'\n" +
"	                `.           / `----|          |-............`---'\n" +
"	                  \\          \\      |          |\n" +
"	                 ,'           )     `.         |\n" +
"	                  7____,,..--'      /          |\n" +
"	                                    `---.__,--.' ");
		
	ArrayList<String> head = new ArrayList<String>();
		head.add("           _,........__              ");
		head.add("        ,-'            \"`-.          ");
		head.add("      ,'                   `-.       ");
		head.add("    ,'                        \\      ");
		head.add("  ,'                           .     ");
		head.add("  .'\\               ,\"\".       `     ");
		head.add(" ._.'|             / |  `       \\    ");
		head.add(" |   |            `-.'  ||       `.  ");
		head.add(" |   |            '-._,'||       | \\ ");
		head.add(" .`.,'             `..,'.'       ,   ");
		head.add(" l                       .'`.  _/    ");
		head.add(" `-.._'-   ,          _ _'   -\"      ");
		head.add("     \"'-.`-...,---------','          ");
		head.add("      `\"-..___      __,'             ");
		head.add("                                     ");
		head.add("                                     ");
	squirtle.setHead(head);
	
	return squirtle;
		
	}
	
	public Pokemon bulbasaur()
	{
		Pokemon bulbasaur = new Pokemon("Bulbasaur", "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.");
		bulbasaur.setMaxHP(45);
		bulbasaur.setHP(bulbasaur.getMaxHP());
		bulbasaur.setAttack(49);
		bulbasaur.setDefense(49);
		bulbasaur.setSpeed(45);
		bulbasaur.setAccuracy(100);
		bulbasaur.setType(new PokeType("grass"));
		
		ArrayList<PokeMove> learnable = new ArrayList<PokeMove>();
		learnable.add(gen.tackle());
		learnable.add(gen.growl());
		learnable.add(gen.vineWhip());
		learnable.add(gen.razorLeaf());
		learnable.add(gen.growth());
		bulbasaur.setLearnable(learnable);
		
		bulbasaur.setPrintOut(
				"                        _,.------....___,.' ',.-.\n" +
				"                     ,-'          _,.--\"        |\n" +
				"                   ,'         _.-'              .\n" +
				"                  /   ,     ,'                   `\n" +
				"                 .   /     /                     ``.\n" +
				"                 |  |     .                        \\ " + "\n" +
				"       ____      |___._.  |       __                \\ '." + "\n" +
				"     .'    `---\" \"       ``\"-.--\"'`  \\             \\ " + "\n" +
				"    .  ,            __               `              |   .\n" +
				"    `,'         ,-\"'  .              \\             |    L\n" +
				"   ,'          '    _.'                -._          /    |\n" +
				"  ,`-.    ,\".   `--'                      >.      ,'     |\n" +
				" . .'\'   `-'       __    ,  ,-.         /  `.__.-      ,'\n" +
				" ||:, .           ,'  ;  /  /\\ `        `.    .      .'/\n" +
				" j|:D \\          `--'  ' ,'_  . .         `.__,\\   , /\\" + "\n" +
				"/ L:_  |                 .  \"' :_;                `.'.'\n" +
				".    \"\"'                  \"\"\"\"\"'                    V\n" +
				" `.                                 .    `.   _,..  `\n" +
				"   `,_   .    .                _,-'/    .. `,'   __  `\n" +
				"    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .\n" +
				"   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |\n" +
				"  .   _  `\"\"'--.._____..--\"   ,             '         |\n" +
				"  | .\" `. `-.                /-.           /          ,\n" +
				"  | `._.'    `,_            ;  /         ,'          .\n" +
				" .'          /| `-.        . ,'         ,           ,\n" +
				" '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'\n" +
				" `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--' ");
		
		
	ArrayList<String> head = new ArrayList<String>();
		head.add("       ____                                   ");
		head.add("     .'    `---\" \"       ``\"-.--\"'`           ");
		head.add("    .  ,            __               `        ");
		head.add("    `,'         ,-\"'  .              \\        ");
		head.add("   ,'          '    _.'                -._    ");
		head.add("  ,`-.    ,\".   `--'                      >.  ");
		head.add(" . .'\'   `-'       __    ,  ,-.         /     ");
		head.add(" ||:, .           ,'  ;  /  /\\ `        `.    ");
		head.add(" j|:D \\          `--'  ' ,'_  . .         `.  ");
		head.add("/ L:_  |                 .  \"' :_;         /  ");
		head.add(".    \"\"'                  \"\"\"\"\"'    /         ");
		head.add(" `.                                 .    `.   ");
		head.add("   `,_   .    .                _,-'/    .. \\  ");
		head.add("    ) \\`._        ___....----\"'  ,'   .'  \\   ");
		head.add("   /   `. \"`-.--\"'         _,' ,'     `---'  ");
		head.add("  .   _  `\"\"'--.._____..--\"   ,          |    ");
	bulbasaur.setHead(head);
	
	return bulbasaur;
	
	}
	
}
