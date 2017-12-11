package christian.binnland.items;

public class Item {
	
	enum Types {
		WEAPON,
		FOOD,
		CLOTHING, VEHICLE, OBSTACLE
	}
	
	public boolean grabable = true;
	public int DAMAGE;
	
	public String getName() {
		return "default_name";
	};
	
}