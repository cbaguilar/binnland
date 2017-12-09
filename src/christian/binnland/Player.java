package christian.binnland;

import java.util.ArrayList;
import java.util.List;

import christian.binnland.items.Item;
import christian.binnland.locations.Location;

public class Player {

	
	ArrayList<String> vowels;
	
	List<Item> inventory;
	int health = 100;
	
	Location curLocation;
	
	
	Player(String name, int health){
		inventory = new ArrayList<Item>();
		this.health = 100;
	
		//vowels = (ArrayList<String>) Arrays.asList(new String[] {"a","e","i","o","u"});
	
	}
	
	public List<Item> getInven(){
		return inventory;
	}
	
	public void addItem(Item i) {
		inventory.add(i);
	}
	
	String inspect(Location l){
		  List<Item> items = l.getItems();
		  
		  
		  String response = "You look around. \n"+
				  			"You see: ";
		
		  for (Item i : items) {
			  response += (" a "+ i.getName()+"\n");
		  }
		  
		  response+= l.getDesc();
		  return response;
		}

	public Location getLocation() {	 
		return curLocation;
	}
	
	public void goTo(Location l) {
		curLocation = l;
	}
	
	public String move(String s) {
		return curLocation.move(s).RESPONSE;
	}
	
	public void isVowel(String s) {
		
	}
	

	
	public String attack() {
		Response resp = getLocation().attackObstacle(1);
		
		if (resp.VALUE > 0) { takeDamage(resp.VALUE); }
		
		return resp.RESPONSE;
	}

	private void takeDamage(int dam) {
		this.health-=dam;
		
	}

	public String pickUp(List<String> cleanCmd) {
		Item i;
		String itemName = cleanCmd.get(1);
		try {
		i = curLocation.takeItem(itemName);
		this.addItem(i);
		return "Picked up " + i.getName();
		}
		catch (Exception e) {
			return "Couldn't find " +itemName;
		}
	}
	
}
