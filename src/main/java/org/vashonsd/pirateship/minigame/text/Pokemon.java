package org.vashonsd.pirateship.minigame.text;

import java.util.*;

public class Pokemon 
{
	private String name;
	private String description;
	private PokeType type;
	private int hp;
	private int attack;
	private int defense;
	private int speed;
	private ArrayList<PokeMove> moves;
	private ArrayList<PokeMove> learnable;
	private String printOut;
	private int accuracy;
	private PokeMoveGenerator gen;
	
	public Pokemon(String name)
	{
		this.name = name;
		moves = new ArrayList<PokeMove>();
		learnable = new ArrayList<PokeMove>();
		gen = new PokeMoveGenerator();
		
		if(name.equalsIgnoreCase("charmander"))
			charmander();
		else if(name.equalsIgnoreCase("squirtle"))
			squirtle();
		else if(name.equalsIgnoreCase("bulbasaur"))
			bulbasaur();
	}
	
	public void addMove(PokeMove m) {
		moves.add(m);
	}
	public boolean knowsMove(PokeMove m) {
		return moves.contains(m);
	}
	public PokeMove getMove(String s) {
		for(PokeMove m: moves) {
			if(m.getName().equals(s))
				return m;
		}
		
		return null;
	}
	
	public String getName() {
		return name;
	}
	public PokeType getType() {
		return type;
	}
	public String getTypeName() {
		return type.getType();
	}
	public String getDescription() {
		return description;
	}
	public void changeHP(int h) {
		hp += h;
	}
	public int getHP() {
		return hp;
	}
	public void changeAttack(int a) {
		attack += a;
	}
	public int getAttack() {
		return attack;
	}
	public void changeDefense(int d) {
		defense += d;
	}
	public int getDefense() {
		return defense;
	}
	public void changeSpeed(int s) {
		speed += s;
	}
	public int getSpeed() {
		return speed;
	}
	public void changeAccuracy(int a) {
		accuracy += a;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public String printOut() {
		return printOut;
	}
	public ArrayList<PokeMove> getLearnable() {
		return learnable;
	}
	public ArrayList<PokeMove> getMoves() {
		return moves;
	}
	public String printMoves() {
		String toReturn = "";
		
		for(PokeMove m: moves) {
			toReturn += m.getName() + ". Type: " + m.getTypeName() + ". Power: " + m.getPower() + "\n";
		}
		
		return toReturn;
	}
	public boolean canLearn(PokeMove m) {
		return learnable.contains(m);
	}
	
	public void charmander()
	{
		name = "Charmander";
		hp = 39;
		attack = 52;
		defense = 43;
		speed = 65;
		accuracy = 100;
		type = new PokeType("fire");
		description = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.";
		
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

	}
	
	public void squirtle()
	{
		name = "Squirtle";
		hp = 44;
		attack = 48;
		defense = 65;
		speed = 43;
		accuracy = 100;
		type = new PokeType("water");
		description = "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.";
		
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
	}
	
	public void bulbasaur()
	{
		name = "Bulbasaur";
		hp = 45;
		attack = 49;
		defense = 49;
		speed = 45;
		accuracy = 100;
		type = new PokeType("grass");
		description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.";
		
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
		
		learnable.add(gen.tackle());
	}
	
	public String printHP() {
		String toReturn = "";
		for(int i=0; i<hp/5; i++) {
			toReturn += "+";
		}
		toReturn += hp;
		
		return toReturn;
	}
	
	public String toString() {
		return name + ". HP: " + hp + ". Attack: " + attack + ". Defense: " + defense + ". Speed: " + speed + "\n" + description;
	}
}
