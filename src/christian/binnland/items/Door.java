package christian.binnland.items;

import christian.binnland.Response;

public class Door extends Item implements Fightable {
	public static String INFO = "A big thingin uour path";
	static String NAME = "door";
	public static Object TYPE = Types.WEAPON;
	static int DAMAGE = 2;
	static int WEIGHT = 2;
	static int HEALTH = 10;
	
	int levelProtecting;
	
	boolean locked;
	boolean passable;
	boolean breakable;
	
	public Door(int level,boolean locked,boolean breakable, boolean passable) {
		this.levelProtecting = level;
		this.locked = locked;
		this.passable = passable;
		this.breakable = breakable;
		grabable = false;
	}
	
	@Override
	public	String getName() {
		return NAME;
	}

	public boolean passable() {
		return passable;
	}
	
	public Response open() {
		if (health < 0) {
			passable = true;
			return new Response("The door is destroyed..",0);
		}
		if ((!locked)) {
		passable = true;
		return new Response("The door was opened",0);
		}
		else {
			return new Response("The door is locked",0);
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public Response attack(int damage) {
		if (damage < WEIGHT) {
			return new Response("Your weak efforts do little to the heavy door. \nThe weight of the door hurts you.",1);
		}
		else {
			HEALTH -= damage;
			Response resp = new Response("You hit the door, and it is damaged, but still up.",0);
			if (HEALTH < 0) {
				resp = new Response("The door splinters into many pieces, revealing a room inside",0);
				this.passable = true;
			}
			return resp;
		}
		
		
	}
}