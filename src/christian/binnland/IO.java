package christian.binnland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import christian.binnland.locations.Location;

public class IO {

	Scanner sn;
	Player player;
	
	String[] ACTS = new String[] {
			  "inspect"
			};
			String[] MODIFIERS = new String[] {
			  "north","south","east","west","up","down"
			};
	
	public IO() {
		sn = new Scanner(System.in);
	}
	
	public IO(Player player) {
		this.player = player;
	}

	public String[] inputCommand(){
		  return sn.nextLine().split(" ");
		}	
		
	void println(Object e) {
			System.out.println(e);
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
