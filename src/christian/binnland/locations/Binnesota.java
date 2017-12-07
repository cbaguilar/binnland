package christian.binnland.locations;

import java.util.ArrayList;
import java.util.List;

import christian.binnland.IO;
import christian.binnland.Response;
import christian.binnland.items.*;
import christian.binnland.obstacles.*;

public class Binnesota extends Location {

	List<Item> items = new ArrayList<Item>();
	
	String NAME = "Binnesota";
	
	int level = 0;
	
	Obstacle curObst;
	
	
	public Binnesota(String name, IO io) {
		super(name,io);
		this.addItem(new Axe());
		this.addItem(new Bike());
		curObst = new Ice();
		io.println("You wake in cold water, under a sheet of ice...");
		io.println("You should probably try breaking out of the ice before you drown!");
		
		
		
	}
	
	public String getName() {
		return NAME;
	}

	public boolean getCompleted(){
		  return false;
	}
	
	public Object tryAction() {
		switch (level) {
		case 0:
			
		}
		return new Object();
	}
	
	@Override
	public Response attackObstacle(int damage) {
		
		switch(level) {
		case 0:
			level++;
			return  curObst.attack(damage);
		
		
		}
		return new Response("Nothing to fight", 0);
		
	}
	

}
