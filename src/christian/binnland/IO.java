package christian.binnland;

import java.util.ArrayList;
import java.util.Arrays;

import christian.binnland.locations.Location;

public class IO {

	String[] ACTS = new String[] {
			  "inspect"
			};
			String[] MODIFIERS = new String[] {
			  "north","south","east","west","up","down"
			};
	
	public IO() {
		// TODO Auto-generated constructor stub
	}
	
	Player player;

	public IO(Player player) {
		this.player = player;
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
		      case 0: return player.inspect(player.getLocation());
		    }
		  }
		  else {
		    return "Invald Command";
		  }
		  
		  return "Invalid Command";
		  
		}
	


}
