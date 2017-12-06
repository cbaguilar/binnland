package christian.binnland.obstacles;

public abstract class Obstacle {

	public Obstacle() {
	}
	
	abstract public String getName();

	abstract public String[] attack(int damage);

}
