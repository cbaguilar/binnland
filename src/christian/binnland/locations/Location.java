package christian.binnland.locations;

import java.util.List;

import christian.binnland.IO;
import christian.binnland.items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Location {
	
	
	
	List<Item> items = new ArrayList<Item>();
	
	public Location(String name, IO io){
		System.out.println("Entering " + name );
		//items = new List();
		
	}
	
	public void addItem(Item i) {
		this.items.add(i);
	}
	
	public List<Item> getItems(){
		return items;
	}
	

	
	public boolean getCompleted(){
	  return false;
	}

	public String attackObstacle() {
		// TODO Auto-generated method stub
		return "Nothing to attack..";
	}
}
	


