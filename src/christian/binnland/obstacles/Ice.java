package christian.binnland.obstacles;

import christian.binnland.Response;
import christian.binnland.items.Fightable;
import christian.binnland.items.Item;

public class Ice extends Item implements Fightable {

	
	private final String NAME ="LAKE ICE";
	
	public Ice() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return NAME;
	}


	@Override
	public Response attack(int damage) {
		return new Response("You emerged from the ice!\n Try looking around to see what you have to your disposal...",0);
	}


	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}


}
