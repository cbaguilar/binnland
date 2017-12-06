package christian.binnland.obstacles;

public class Ice extends Obstacle {

	
	private final String NAME ="LAKE ICE";
	
	public Ice() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return NAME;
	}


	@Override
	public String[] attack(int damage) {
		return "The cold ice shatters";
	}


}
