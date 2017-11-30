package binnland.christian;

public interface Item {
	
	enum Types {
		WEAPON,
		FOOD,
		CLOTHING
	}
	
	public final String INFO = "Default info";
	
	public final String name = "item";
	
	public String getInfo();
		//return INFO;
	
}
