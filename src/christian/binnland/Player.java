package christian.binnland;

import java.util.ArrayList;
import java.util.List;

import christian.binnland.items.Item;
import christian.binnland.locations.Location;

public class Player {

	
	List<Item> inventory;
	int health = 100;
	
	Location curLocation;
	
	
	Player(String name, int health){
		inventory = new ArrayList<Item>();
		this.health = 100;
	}
	
	public List<Item> getInven(){
		return inventory;
	}
	
	public void addItem(Item i) {
		inventory.add(i);
	}
	
	String inspect(Location l){
		  String response = "You look around \n"+
				  			"You see: ";
		  List<Item> items = l.getItems();
		  for (Item i : items) {
			  response += (" a "+ i.getName()+"\n");
		  }
		  
		  return response;
		}

	public Location getLocation() {	 
		return curLocation;
	}
	
	public void goTo(Location l) {
		curLocation = l;
	}

	public String attack() {
		return getLocation().attackObstacle();
	}
	
}
