package christian.binnland.items;

import christian.binnland.items.Item.Types;

public class Axe extends Item {
	public static String INFO = "A shiny metal skull-crusher";
	static String NAME = "Axe";
	public static Object TYPE = Types.WEAPON;
	
	static int WEIGHT = 2;
	
	public Axe() {
		this.DAMAGE = 5;
	}
	
	@Override
public	String getName() {
		return NAME;
	}

}

