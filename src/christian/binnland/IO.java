package christian.binnland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import christian.binnland.locations.Location;

public class IO {

	Scanner sn;
	Player player;
	
	
	

	List<String> MODS;
	Map<String,Integer> ACTS;
	

	public IO(Player player) {
		sn = new Scanner(System.in);
		this.player = player;
		
		MODS = new ArrayList<String>();
		
		MODS.add("to");
		MODS.add("with");
		MODS.add("up");
		MODS.add("a");
		
		ACTS = new HashMap<String,Integer>();
			

		ACTS.put("inspect",0); //Inspection/look commands
		ACTS.put("look",0);
		ACTS.put("check", 0);
		
		ACTS.put("fight", 1); //attack and destroy commands
		ACTS.put("break", 1);
		ACTS.put("hit", 1);
		ACTS.put("smash",1);
		ACTS.put("punch", 1);
		
		ACTS.put("pick",2); //Pick up item commands
		ACTS.put("take",2);
		ACTS.put("grab", 2);
		
		ACTS.put("go",3); // Move/walk commands
		ACTS.put("walk",3);
		ACTS.put("move",3);
		ACTS.put("stroll",3);
	}

	/**
	 * 
	 * @return List<String> that contains each individual word in a command-string
	 */
	public List<String> inputCommand(){
		  return  Arrays.asList(sn.nextLine().split(" "));
		}	
		
	
	/**
	 * Pass an object to be printed via System.out
	 * @param e Any object that can be passed to System.out.println().
	 */
	public void println(Object e) {
			System.out.println(e);
		}
	
	/**
	 * Removes non-critical parts of a command, such as "to" and "the"
	 * 
	 * @param cmd Command (in List<String> format) to be cleaned.
	 * @return clean Command List<String> that has had unnecessary words removed.
	 */
	public List<String> cleanCmd(List<String> cmd) {
		List<String> clean = new ArrayList<String>();
		for (String s : cmd) {
			if (!MODS.contains(s)) {
				clean.add(s.toLowerCase());
			}
		}
		return clean;
		
		
	}
	
	public String runCommand(List<String> cmd) {
		  boolean validCmd = false;
		  
		  int primaryCmd = 0;
		  
		  for (String word : cmd){
			  if (ACTS.containsKey(word.toLowerCase())) {
			    validCmd = true;
			    primaryCmd = ACTS.get(word.toLowerCase());
			    break;
			  }
		  }
		  List<String> cleanCmd = cleanCmd(cmd);
		  if (validCmd){
		    switch(primaryCmd){
		      case 0: return player.inspect(player.getLocation());
		      case 1: return player.attack();
		      case 2: 
		    	  if ( cleanCmd.size() > 1){
		    		  return player.pickUp(cleanCmd);
		    	  }
		      case 3:
		    	  if (cleanCmd.size() > 1) {
		    	  return player.move(cleanCmd.get(1));
		    	  }
		      default: return "What are you trying to say?";
		      
		    }
		  }
		  else {
		    return "Invald Command";
		  }
		  		  
		}
	


}
