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
}
	


