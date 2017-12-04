package christian.binnland;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Location {
	
	String[] ACTS = new String[] {
	  "inspect"
	};
	String[] MODIFIERS = new String[] {
	  "north","south","east","west","up","down"
	};
	
	List<Item> items = new ArrayList();
	
	Location(String name, int time){
		System.out.println("Entering " + name );
		//items = new List();
		
	}
	
	public void addItem(Item i) {
		this.items.add(i);
	}
	
	public String runCommand(String[] cmd) {
	  boolean validCmd = false;
	  
	  int primaryCmd = 0;
	  
	  for (String word : cmd){
	  
	  if (Arrays.asList(ACTS).contains(word.toLowerCase())) {
	    validCmd = true;
	    break;
	  }
	  primaryCmd++;
	  }
	  if (validCmd){
	    switch(primaryCmd){
	      case 0: return inspect();
	    }
	  }
	  else {
	    return "Invald Command";
	  }
	  
	  return "Invalid Command";
	  
	}
	
	private String inspect(){
	  String response = "You look around \n"+
			  			"You see: ";
	  for (Item i : items) {
		  response += (" a "+ i.NAME);
	  }
	  
	  return response;
	}
	
	public boolean getCompleted(){
	  return false;
	}
}
	


