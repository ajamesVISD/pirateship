package org.vashonsd.pirateship.minigame.text;

import java.util.*;

import org.vashonsd.pirateship.interactions.poke.PokeMove;
import org.vashonsd.pirateship.interactions.poke.PokeMoveGenerator;
import org.vashonsd.pirateship.interactions.poke.PokeType;

public class MiniPokemon 
{
	private String name;
	private String description;
	private PokeType type;
	private int hp;
	private int maxHP;
	private double attack;
	private double defense;
	private int speed;
	private ArrayList<PokeMove> moves;
	private ArrayList<PokeMove> learnable;
	private String printOut;
	private int accuracy;
	private PokeMoveGenerator gen;
	private ArrayList<String> head;
	
	public MiniPokemon(String name)
	{
		this.name = name;
		moves = new ArrayList<PokeMove>();
		learnable = new ArrayList<PokeMove>();
		gen = new PokeMoveGenerator();
		head = new ArrayList<String>();
		
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
	public void changeHP(double h) {
		hp += h;
		
		if(hp < 0)
			hp = 0;
		if(hp > maxHP)
			hp = maxHP;
	}
	public int getHP() {
		return hp;
	}
	public void changeAttack(int a) {
		attack += a;
	}
	public double getAttack() {
		return attack;
	}
	public void changeDefense(int d) {
		defense += d;
	}
	public double getDefense() {
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
			toReturn += m.toString() + "\n";
		}
		
		return toReturn;
	}
	public boolean canLearn(PokeMove m) {
		return learnable.contains(m);
	}
	
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
	
	public String printHP() {
		String toReturn = "";
		for(int i=0; i<hp/5; i++) {
			toReturn += "+";
		}
		toReturn += hp;
		
		return toReturn;
	}
	
	public String toString() {
		return name + "\nHP: " + hp + " Attack: " + attack + " Defense: " + defense + " Speed: " + speed + "\n" + description + "\n";
	}
	
	public ArrayList<String> getHead() {
		return head;
	}
	
	public String printHead() {
		String toReturn = "";
		for(String s: head) {
			toReturn += s + "\n";
		}
		return toReturn;
	}
	
	public String battleHUD(MiniPokemon opp) {
		String toReturn = "";
		for(int i=0; i<hp/5; i++) {
			toReturn += "+";
		}
		toReturn += hp;
		for(int i=0; i<head.get(0).length(); i++) {
			toReturn += " ";
		}
		for(int i=0; i<opp.getHP()/5; i++) {
			toReturn += "+";
		}
		toReturn += opp.getHP() + "\n";
		for(int i=0; i<head.size(); i++) {
			toReturn += head.get(i) + "    " + opp.getHead().get(i) + "\n";
		}
		
		return toReturn;
	}
	
	public boolean isDead() {
		return hp <= 0;
	}
	
}
