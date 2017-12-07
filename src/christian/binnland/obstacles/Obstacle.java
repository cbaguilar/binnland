package christian.binnland.obstacles;

import christian.binnland.Response;

public abstract class Obstacle {

	public Obstacle() {
	}
	
	abstract public String getName();
	
	
	abstract public Response attack(int damage);

}
