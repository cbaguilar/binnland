package christian.binnland;

import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

import christian.binnland.items.Axe;
import christian.binnland.locations.*;
class Game {
  
  static Scanner sn = new Scanner(System.in);
  
	public static void main(String[] args) {
		stupidGame();
		Player player = new Player("Binns",100);
		IO io = new IO(player);
		
		println("You hear but you do not see yet.");
		println("Say something!");
		inputCommand();
		Axe a = new Axe();
		
		Binnesota binny = new Binnesota("Binnesota", io);
		player.goTo(binny);
		
		while (!binny.getCompleted()){
		 println(io.runCommand(inputCommand()));
		}	
		
		
		
	}
	
	static boolean blind = false;
	
	static void stupidGame() {
		println("Congradulations! You've reached the point where the developer ran out of time");
		println("to make an open world game!");
		if (question("Would you like to [e]at the zombie, or [p]oke it with a stick?","e","p")) {
			println("you get sick!");
		}
		else {
			println("It twitches but doesn't move much more than that...");
			
		}
		if (question("Would you like to keep going into the closet? It looks kinda deep? [y/n]","y","n")) {
			println("It seems to lead into a forest...");
			question("press anything..","","");
			outside();
		}
		else {
			println("Okay, you go back into the cabin. It's dark.");
			if (question("Would you like to [r]ead the trig textbook in here, or take it [o]utside?","r","o")) {
				println("You strain your eyes in the dark! You're blind!");
				blind = true;
				println("Since you can't read this, we might as well put you outside...");
				outside();
			
			}
			else {
				outside();
			}
			
				
		}
		
		
	};
	
	static private boolean question(String prompt, String t, String f) {
		println(prompt);
		String test = sn.nextLine().toLowerCase();
		if ((test.equals(t) || test.equals(f))) {
			return test.equals(t);
		}
		else {
			return question("Please enter a valid answer, "+t+" or " +f,t,f);
		}
		
	}
	
	private void intro() {
		println("/t/tBINLAND");
		println("Wake up");
	}
	
	public static List<String> inputCommand(){
	  return Arrays.asList(sn.nextLine().split(" "));
	}
	
	
	static void outside() {
		println("You are now outside.");
		println("It seems to you that an ice age is probably going to kill everyone in Binnesota");
		if (question("Would you like to try to [e]scape or [s]urvive here?","e","s")) {
			escape();
		}
		else {
			println("That'll sure be tough..");
			println("You need to first pick something to eat");
			println("Would you like to eat some [s]now or your ")
		}
	};
	
	static void println(Object e) {
		Object line = e;
		if ((e instanceof String)&&blind) {
			String s = (String) e;
			line = "";
			for (int i = 0; i < (s.length()); i++) {
				line += String.valueOf((s.charAt(i)+1));
			}
		}
		System.out.println(line);
	}
}

