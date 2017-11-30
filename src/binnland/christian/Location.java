package binnland.christian;

import java.util.List;

public class Location {
	
	
	List<Item> items;
	
	Location(String name, int time){
		System.out.println("Entering " + name );
		items = new List();
		
	}
	
	public void addItem(Item i) {
		this.items.add(i);
	}
	
	
	


}
