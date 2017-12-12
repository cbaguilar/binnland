package christian.binnland.items;


public class Bike extends Item {

	String INFO = "A two wheely rolly seat"; //Bikes do 4 damage,
	static String NAME = "Bike";  			//axes do 5...
	static Object TYPE = Types.VEHICLE;
	static int WEIGHT = 2;
	boolean broken = false;
	
	public Bike(boolean broken) {
		this.DAMAGE = 4;
		if (broken) {
			this.broken = broken;
			this.INFO = "It is broken.";
		}
	}
	
	public Bike() {
		
	}

	@Override
	public	String getName() {
		return NAME;
	}

	
}
