package christian.binnland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import christian.binnland.locations.Location;

public class IO {

	Scanner sn;
	Player player;
	
	
	

			
	Map<String,Integer> ACTS;
	

	public IO(Player player) {
		sn = new Scanner(System.in);
		this.player = player;
		
		 ACTS = new HashMap<String,Integer>();
			
			System.out.println("nothign");
			ACTS.put("inspect",0);
			ACTS.put("look",0);
			
			ACTS.put("fight", 1);
			ACTS.put("break", 1);
			ACTS.put("hit", 1);
			ACTS.put("smash",1);
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
		  
		  if (ACTS.containsKey(word.toLowerCase())) {
		    validCmd = true;
		    primaryCmd = ACTS.get(word.toLowerCase());
		    break;
		  }
		 
		  }
		  if (validCmd){
		    switch(primaryCmd){
		      case 0: return player.inspect(player.getLocation());
		      case 1: return player.attack();
		      
		    }
		  }
		  else {
		    return "Invald Command";
		  }
		  
		  return "Invalid Command";
		  
		}
	


}
