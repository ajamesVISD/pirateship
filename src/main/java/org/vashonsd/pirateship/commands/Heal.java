package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.*;


	public class Heal extends Command {

		public Heal() {
			super();
			addKeyword("heal");
		}

		@Override
		public Response execute(Actor obj, Player player) {
			Response r = new Response();
			String text = "";
			if(player.hasByTypeName("bandage"))
			{
				if (obj.isAlive() && obj.getHealth() < obj.getMaxHealth()) {
					obj.changeHealth(4);
					text += "You have healed " + obj.getName() + " for 4 points. ";
					player.removeFromInventory(player.getByTypeName("bandage"));

				}
				if (obj.isAlive()) {
					text += obj.getDescription();
				} else if(obj.getHealth() >= obj.getMaxHealth()) {
					text += obj.getName() + " is at full health! ";
				}
				else{
					text += obj.getName() + " You cant bring something back from the dead!";
				}
				r.setText(text);
			}
			else {
				text += "You have nothing to heal with!";
				r.setText(text);
			}
			return r;
		}
	}
