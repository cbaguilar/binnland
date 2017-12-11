package christian.binnland.locations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import christian.binnland.IO;
import christian.binnland.Response;
import christian.binnland.items.*;
import christian.binnland.obstacles.*;

public class Binnesota extends Location {

	String NAME = "Binnesota";

	List<Item> cabinItems = new ArrayList<Item>();
	List<Item> insideItems = new ArrayList<Item>();

	public Binnesota(String name, IO io) {
		super(name, io);
		this.addItem(new Axe());
		this.level = 0;
		
		Door cabinDoor = new Door(4,true,true,false);
		
		obsts.put(0, new Ice());
		obsts.put(2, cabinDoor);
		
		io.println("You wake in cold water, under a sheet of ice...");
		io.println("You should probably try breaking out of the ice before you drown!");

		this.descs.put(0, "It is cold and wet");
		this.descs.put(1, "It is cold. You see a cabin in the distance");
		this.descs.put(2,
				"You are in front of a cabin. \n It has a heavy wooden door. It is in front of a frozen lake.");
		this.descs.put(3,"You are inside of a cabin. There is a small door in the back.");

		this.targets.put("lake", 1);

		this.targets.put("cabin", 2);
		this.targets.put("house", 2);

		this.targets.put("door", 3);
		this.targets.put("inside", 3);

		cabinItems.add(new Bike(false));
		cabinItems.add(cabinDoor);

		lItems.put(1, getItems());
		lItems.put(2, cabinItems);

		// TODO: add locations and items.
	}

	public String getName() {
		return NAME;
	}

	public boolean getCompleted() {
		return false;
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
			
			e.printStackTrace();
			return true;
		}
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
							level = targets.get(target);

							return new Response("Moved to "+target, 1);
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
		
		}
		return new Response("Nothing to fight", 0);

	}

}
