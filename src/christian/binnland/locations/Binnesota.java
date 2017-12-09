package christian.binnland.locations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import christian.binnland.IO;
import christian.binnland.Response;
import christian.binnland.items.*;
import christian.binnland.obstacles.*;

public class Binnesota extends Location {

	List<Item> items = new ArrayList<Item>();
	
	String NAME = "Binnesota";
	
	Obstacle curObst;
	
	

	public Binnesota(String name, IO io) {
		super(name,io);
		this.addItem(new Axe());
		this.level = 0;
		curObst = new Ice();
		io.println("You wake in cold water, under a sheet of ice...");
		io.println("You should probably try breaking out of the ice before you drown!");
		
		this.descs.put(0, "It is cold and wet");
		this.descs.put(1, "It is cold. You see a cabin in the distance");
		
		this.targets.put("cabin", 1);
		this.targets.put("house", 1);
		//TODO: add locations and items.
	}
	
	public String getName() {
		return NAME;
	}

	public boolean getCompleted(){
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
	
	@Override
	public Response attackObstacle(int damage) {
		
		switch(this.level) {
		case 0:
			level++;
			return  curObst.attack(damage);
		
		
		}
		return new Response("Nothing to fight", 0);
		
	}
	

}
