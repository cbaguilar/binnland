package christian.binnland.locations;

import java.util.ArrayList;
import java.util.List;

import christian.binnland.IO;
import christian.binnland.items.*;
import christian.binnland.obstacles.*;

public class Binnesota extends Location {

	List<Item> items = new ArrayList<Item>();
	
	String NAME = "Binnesota";
	
	int level = 0;
	
	Obstacle curObst;
	
	
	public Binnesota(String name, IO output) {
		super(name,output);
		this.addItem(new Axe());
		this.addItem(new Bike());
		curObst = new Ice();
		
		
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
	
	public String[] attackObstacle(int damage) {
		return   curObst.attack(damage);
		
		
	}
	

}
