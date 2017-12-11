package christian.binnland;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import christian.binnland.items.Door;
import christian.binnland.items.Item;
import christian.binnland.locations.Location;

public class Player {

	
	ArrayList<String> vowels;
	
	List<Item> inventory;
	int health = 100;
	
	Location curLocation;
	
	Item equipped;
	Player(String name, int health){
		inventory = new ArrayList<Item>();
		this.health = 100;
	
		//
	
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
		  for (Item i : l.getItems()) {
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
	

	

	
	public String attack() {
		String attackMod = "Hand";
		int damage = 1;
		if (!(equipped==(null))) {
			damage=equipped.DAMAGE;
			attackMod = equipped.getName();
		}
		Response resp = getLocation().attackObstacle(damage);
		
		if (resp.VALUE > 0) { takeDamage(resp.VALUE); }
		
		return "You attacked with your "+ attackMod+"\n"+resp.RESPONSE;
	}

	public String stats() {
		int pwr = 1;
		if (!(equipped==null)) {
			pwr = equipped.DAMAGE;
		}
		return "Your attack power: "+pwr;
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
	
	public String equipItem(String name) {
		try {
			equipped = getItemByIndex(name);
			return "Equipped "+name;
		}
		catch (NoSuchElementException nsee) {
			return "Couldn't find " + name + " in your inventory.";
		}
	}

	public Item getItemByIndex(String name) throws NoSuchElementException {
		int index = getItemIndex(name);
		return getInven().get(index);
	}
	
	public int getItemIndex(String string) throws NoSuchElementException{
		for (Item i : getInven()) {
			//System.out.println(i.getName());
			if (i.getName().toLowerCase().equals(string.toLowerCase())) {
				return getInven().indexOf(i);
			}
		}
		throw new NoSuchElementException();
	}
	
	public String openDoor() {
		try {
			Door door = (Door)curLocation.getItemByIndex("door");
			Response resp = door.open();
			return resp.RESPONSE;
		}
		catch (NoSuchElementException enfe) {
			return "Could not find a door";
		}
	
	}
	
}
