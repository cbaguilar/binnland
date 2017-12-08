package christian.binnland;

import java.util.List;

import java.util.Scanner;

import christian.binnland.items.Axe;
import christian.binnland.locations.*;
class Game {
  
  static Scanner sn = new Scanner(System.in);
  
	public static void main(String[] args) {
		Player player = new Player("Binns",100);
		IO io = new IO(player);
		
		println("You hear but you do not see yet.");
		println("Say something!");
		inputCommand();
		Axe a = new Axe();
		
		player.goTo(new Binnesota("Binnesota",io));
		
		while (false == false){
		 println(io.runCommand(inputCommand()));
		}	
	}
	
	private void intro() {
		println("/t/tBINLAND");
		println("Wake up");
	}
	
	public static String[] inputCommand(){
	  return sn.nextLine().split(" ");
	}
	
	
	
	static void println(Object e) {
		System.out.println(e);
	}
}

