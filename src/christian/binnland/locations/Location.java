package christian.binnland.locations;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import christian.binnland.IO;
import christian.binnland.Response;
import christian.binnland.items.Fightable;
import christian.binnland.items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
	
	
	Map<Integer,Fightable> obsts= new HashMap<Integer,Fightable>();
	List<Item> items = new ArrayList<Item>();
	Map<Integer,String> descs = new HashMap<Integer,String>();
	Map<String,Integer> targets = new HashMap<String,Integer>();
	int level;
	

	Map<Integer,List<Item>> lItems = new HashMap<Integer,List<Item>>();

	
	
	public Location(String name, IO io){
		System.out.println("Entering " + name );
		//items = new List();
		
	}
	
	public Fightable getCurObst() throws NoSuchElementException{
		return obsts.get(level);
	}
	public void addItem(Item i) {
		try {
		  getItems().add(i);
		}
		catch (NullPointerException npe) {
			lItems.put(level,new ArrayList<Item>());
			getItems().add(i);
		}
	}
	
	public List<Item> getItems(){
		List<Item> retValue;
		try {
			retValue = lItems.get(level);
			if (retValue.equals(null)) {
				lItems.put(level, new ArrayList<Item>());
			}
			return retValue;
		}
		catch (NullPointerException npe) {
			lItems.put(level,new ArrayList<Item>());
			return lItems.get(level);
		}
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
			Item i = getItems().get(index);
			if (i.grabable) {
			getItems().remove(index);
			return i;
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public Item getItemByIndex(String name) throws NoSuchElementException {
		int index = getItemIndex(name);
		return getItems().get(index);
	}
	
	public int getItemIndex(String string) throws NoSuchElementException{
		for (Item i : getItems()) {
			//System.out.println(i.getName());
			if (i.getName().toLowerCase().equals(string.toLowerCase())) {
				return getItems().indexOf(i);
			}
		}
		throw new NoSuchElementException();
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
	


