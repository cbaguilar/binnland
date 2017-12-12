package christian.binnland.locations;

import java.util.ArrayList;
import java.util.List;

import christian.binnland.IO;
import christian.binnland.Response;
import christian.binnland.items.*;
import christian.binnland.obstacles.*;

public class Binnesota extends Location {

	String NAME = "Binnesota";

	List<Item> cabinItems = new ArrayList<Item>();
	List<Item> insideItems = new ArrayList<Item>();
	List<Item> closetItems = new ArrayList<Item>();
	
	boolean completed = false;

	public Binnesota(String name, IO io) {
		super(name, io);
		this.addItem(new Axe());
		this.level = 0;
		
		Door cabinDoor = new Door(4,true,true,false);
		Door closetDoor = new Door(5,false,true,false);
		
		Zombie fred = new Zombie();
		
		obsts.put(0, new Ice());
		obsts.put(2, cabinDoor);
		obsts.put(3, closetDoor);
		obsts.put(4, fred);
		
		io.println("You wake in cold water, under a sheet of ice...");
		io.println("You should probably try breaking out of the ice before you drown!");

		this.descs.put(0, "It is cold and wet");
		this.descs.put(1, "It is cold. You see a cabin in the distance");
		this.descs.put(2,
				"You are in front of a cabin. \n It has a heavy wooden door. It is in front of a frozen lake.");
		this.descs.put(3,"You are inside of a cabin. There is a small closet door in the back.");
		this.descs.put(4,"You are inside a sort of tunnel. It leads to a forest");

		this.targets.put("lake", 1);

		this.targets.put("cabin", 2);
		this.targets.put("house", 2);
		
		this.targets.put("in", 3);
		this.targets.put("door", 3);
		this.targets.put("inside", 3);
		
		this.targets.put("hall", 4);
		this.targets.put("closet",4);

		cabinItems.add(new Bike(false));
		cabinItems.add(cabinDoor);
		
		insideItems.add(closetDoor);
		insideItems.add(new TrigBook());
		
		closetItems.add(fred);

		lItems.put(1, getItems());
		lItems.put(2, cabinItems);
		lItems.put(3, insideItems);
		lItems.put(4,closetItems);

		// TODO: add locations and items.
	}

	public String getName() {
		return NAME;
	}

	public boolean getCompleted() {
		return completed;
	}

	public String getDesc() {
		return descs.get(this.level);

	}

	public Object tryAction() {
		switch (this.level) {
		case 0:

		}
		return new Object();
	}

	boolean checkDoorPassable() {
		int i;
		try {
			i = getItemIndex("door");
			Door d = (Door) getItems().get(i);
			return d.passable();
		
		}
		catch (Exception e) {
			
			//e.printStackTrace();
			return true;
		}
	}
	
	public boolean containsMonster() {
		List<Item> list = getItems();
		for (Item i : list) {
			if (i instanceof Zombie) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Response move(String target) {

		if (targets.containsKey(target)) {

			int dist = targets.get(target) - level;
			if ((dist > -2 && dist < 2)) {
				switch (target) {
					case "inside":
					case "in":
						if (checkDoorPassable()) {
							level ++;
							String m = "";
							if (containsMonster()) {
								m = "\nThere is a monster!";
							}
							return new Response("Moved to "+target+m, 1);
						}
						else {
							return new Response("A door blocks your way", 0);
						}
					case "closet":
						if (checkDoorPassable()) {
							level = targets.get(target);
							String m = "";
							if (containsMonster()) {
								m = "\nThere is a monster!";
							}
							return new Response("Moved to "+target+m, 1);
						}
						else {
							return new Response("A door blocks your way", 0);
						}
						
				default:
					level = targets.get(target);
					return new Response("Moved to " + target, 1);
				}
			} else {
				return new Response("You are too far away from " + target, 1);
			}
		} else {
			return new Response("Could not find " + target, 0);
		}

	}

	@Override
	public Response attackObstacle(int damage) {

		switch (this.level) {
		case 0:
			
			Response reps = getCurObst().attack(damage);
			level ++;
			return reps;
		case 2:
			return getCurObst().attack(damage);
		case 4:
			if (getCurObst().getHealth() > 1) {
				
				this.completed = true;
				return getCurObst().attack(damage);
				
				
			}
			return getCurObst().attack(damage);
			
		
		}
		return new Response("Nothing to fight", 0);

	}

}
