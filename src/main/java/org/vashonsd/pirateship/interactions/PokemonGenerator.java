package org.vashonsd.pirateship.interactions;

import org.vashonsd.pirateship.minigame.text.PokeMoveGenerator;
import org.vashonsd.pirateship.minigame.text.PokeType;

public class PokemonGenerator {
	
	public PokemonGenerator() {}
	
	public Pokemon charmander() {
		Pokemon charmander = new Pokemon("Charmander", "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.");
		
		return charmander;
	}
	
	/*
	public void charmander()
	{
		name = "Charmander";
		maxHP = 39;
		hp = maxHP;
		attack = 52;
		defense = 43;
		speed = 65;
		accuracy = 100;
		type = new PokeType("fire");
		description = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.";
		learnable.add(gen.scratch());
		learnable.add(gen.growl());
		learnable.add(gen.tailWhip());
		learnable.add(gen.ember());
		learnable.add(gen.rage());
		
		printOut =
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
"                            `\" \" -' ";

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

	}
	
	public void squirtle()
	{
		name = "Squirtle";
		maxHP = 44;
		hp = maxHP;
		attack = 48;
		defense = 65;
		speed = 43;
		accuracy = 100;
		type = new PokeType("water");
		description = "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.";
		learnable.add(gen.tackle());
		learnable.add(gen.growl());
		learnable.add(gen.tailWhip());
		learnable.add(gen.bubble());
		learnable.add(gen.waterGun());
		learnable.add(gen.withdraw());
		
		printOut = 
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
"	                                    `---.__,--.' ";
		
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
		
	}
	
	public void bulbasaur()
	{
		name = "Bulbasaur";
		maxHP = 45;
		hp = maxHP;
		attack = 49;
		defense = 49;
		speed = 45;
		accuracy = 100;
		type = new PokeType("grass");
		description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this PokÃ©mon.";
		learnable.add(gen.tackle());
		learnable.add(gen.growl());
		learnable.add(gen.vineWhip());
		learnable.add(gen.razorLeaf());
		learnable.add(gen.growth());
		
		printOut =
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
				" `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--' ";
		
		
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
		
	}
	 */
}
