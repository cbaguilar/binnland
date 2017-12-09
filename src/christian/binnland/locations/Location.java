package christian.binnland.locations;

import java.util.List;
import java.util.Map;

import christian.binnland.IO;
import christian.binnland.Response;
import christian.binnland.items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Location {
	
	
	
	List<Item> items = new ArrayList<Item>();
	Map<Integer,String> descs = new HashMap<Integer,String>();
	Map<String,Integer> targets = new HashMap<String,Integer>();
	int level;
	
	
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
	
	public String getDesc() {
		return descs.get(1);
		
	}
	

	
	public boolean getCompleted(){
	  return false;
	}
	
	public Response attackObstacle(int damage) {
		// TODO Auto-generated method stub
		return new Response("Nothing to attack...",0);
	}

	public Item takeItem(String itemName) throws Exception{
		
		try {
			int index = getItemIndex(itemName);
			Item i = items.get(index);
			items.remove(index);
			return i;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public int getItemIndex(String string) throws Exception{
		for (Item i : items) {
			System.out.println(i.getName());
			if (i.getName().toLowerCase().equals(string)) {
				return items.indexOf(i);
			}
		}
		throw new Exception();
	}
	
	public Response move(String target) {
		if (targets.containsKey(target)) {
			level = targets.get(target);
			return new Response("Moved to "+target,1);
		}
		else {
			return new Response("Could not find "+target,0);
		}
	
		
	}
}
	


