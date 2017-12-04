package christian.binnland.locations;

import java.util.List;

import christian.binnland.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Location {
	
	
	
	List<Item> items = new ArrayList();
	
	public Location(String name, int time){
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
}
	


