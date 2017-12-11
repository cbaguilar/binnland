/**
 * 
 */
package christian.binnland.items;

import christian.binnland.Response;

/**
 * @author christian
 *
 */
public class Zombie extends Item implements Fightable {

	/* (non-Javadoc)
	 * @see christian.binnland.items.Fightable#attack(int)
	 */
	
	public Zombie(){
		grabable= false;
		health = 20;
		DAMAGE = 3;
	}
	
	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public Response attack(int damage) {
		health -=damage;
		double damageFact = Math.random();
		String s = " The Canadian art major zombie is hit, but he hits you back with lame philisophical questions!";
		if (health < 1) {
			s= "The canadian art major zombie iz dead!";
		}
		return new Response(s,(int)damageFact*this.DAMAGE);
	}
	
	@Override
	public String getName() {
		return "A canadian art-major zombie";
	}

}
