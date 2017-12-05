package christian.binnland.items;

import christian.binnland.items.Item.Types;

public class Axe extends Item {
	public static String INFO = "A shiny metal skull-crusher";
	static String NAME = "Axe";
	public static Object TYPE = Types.WEAPON;
	static int DAMAGE = 2;
	static int WEIGHT = 2;
	
	@Override
public	String getName() {
		return NAME;
	}

}

