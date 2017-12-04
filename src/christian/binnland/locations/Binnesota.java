package christian.binnland.locations;

import java.util.ArrayList;
import java.util.List;

import christian.binnland.Axe;
import christian.binnland.Item;

public class Binnesota extends Location {

	List<Item> items = new ArrayList<Item>();

	
	public Binnesota(String name, int time) {
		super("ma","nib".length());
		this.addItem(new Axe());
		this.addItem(new Axe());
	}

}
