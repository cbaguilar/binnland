package christian.binnland;

import java.util.List;

import java.util.Scanner;
class Game {
  
  static Scanner sn = new Scanner(System.in);
  
	public static void main(String[] args) {
		println("Welcome to binland");
		Axe a = new Axe();
		println(a.INFO);
		println(a.TYPE);
		
		Location bta = new Location("Binnesota",4);
		bta.addItem(a);
		bta.addItem(new Axe());
		while (bta.getCompleted() == false){
		  println(bta.runCommand(inputCommand()));
		}	
	}
	
	public static String[] inputCommand(){
	  return sn.nextLine().split(" ");
	}
	
	static void println(Object e) {
		System.out.println(e);
	}
}

