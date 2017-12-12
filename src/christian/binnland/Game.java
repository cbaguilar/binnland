package christian.binnland;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import christian.binnland.items.Axe;
import christian.binnland.locations.*;

class Game {

	static Scanner sn = new Scanner(System.in);
	
	static Player player = new Player("Binns", 100);

	public static void main(String[] args) {
		//stupidGame();
		IO io = new IO(player);

		println("You hear but you do not see yet.");
		println("Say something!");
		inputCommand();

		Binnesota binny = new Binnesota("Binnesota", io);
		player.goTo(binny);

		while (!binny.getCompleted()) {
			println(io.runCommand(inputCommand()));

		}
		stupidGame();
		println("You are probably dead");

	}

	static boolean blind = false;

	static void stupidGame() {
		println("Congradulations! You've reached the point where the developer ran out of time");
		println("to make an open world game!");
		if (question("Would you like to [e]at the zombie, or [p]oke it with a stick?", "e", "p")) {
			println("you get sick!");
		} else {
			println("It twitches but doesn't move much more than that...");

		}
		if (question("Would you like to keep going into the closet? It looks kinda deep? [y/n]", "y", "n")) {
			println("It seems to lead into a forest...");
			println("press anything..");
			sn.nextLine();
			outside();
		} else {
			println("Okay, you go back into the cabin. It's dark.");
			if (question("Would you like to [r]ead the trig textbook in here, or take it [o]utside?", "r", "o")) {
				println("You strain your eyes in the dark! You're blind!");
				blind = true;
				println("Since you can't read this, we might as well put you outside...");
				sn.nextLine();
				outside();

			} else {
				outside();
			}

		}

	};

	static private boolean question(String prompt, String t, String f) {
		println(prompt);
		String test = sn.nextLine().toLowerCase();
		if ((test.equals(t) || test.equals(f))) {
			return test.equals(t);
		} else {
			return question("Please enter a valid answer, " + t + " or " + f, t, f);
		}

	}

	private void intro() {
		println("/t/tBINLAND");
		println("Wake up");
	}

	public static List<String> inputCommand() {
		return Arrays.asList(sn.nextLine().split(" "));
	}

	static boolean trig = false;

	static void outside() {
		clr();
		println("You are now outside.");
		println("It seems to you that an ice age is probably going to kill everyone in Binnesota");
		if (question("Would you like to try to [e]scape or [s]urvive here?", "e", "s")) {
			escape();
			println("You can now survive in the binland empire!");
			survive("Binland Empire");
		} else {
			println("That'll sure be tough..");
			survive("Binnesota");

		}
	};
	
	static boolean rand(int bound) {
		Random rad = new Random();
		return (rad.nextInt(bound)==0);
	}
	
	
	
	static int hunt() {
		clr();
		println("You go into the woods on your bike...");
		pause();
		if (!rand(4)) {
			println("You see a critter! Tasty!");
			println("Will you try catching up with it and [t]ackling\t(dangerous, requires bike skill)");
			println("Or will you try thr[o]wing a weapon at it\t(requires weapon skill)");
			if (question("","t","o")) {
				double skillLevel = ((double)day/2)/bikeSkill;
				println(skillLevel);
				double fail = Math.random()*3;
				println(fail*skillLevel);
				if ((fail*skillLevel) < 1) {
					println("You fell!");
					int dam = new Random().nextInt(10);
					player.takeDamage(dam);
					println("Your health went down to " +player.getHealth());
					println("No meat for you!");
					pause();
				}
				else {
					println("You caught a critter!");
					pause();
					return new Random().nextInt(7)+3;
				}
				
			}
			else {
				if ((weaponLevel*5)/(day*Math.random())>1) {
					println("You got a critter! ");
					int crit = (new Random().nextInt(5)+1);
					println("You have "+crit+"bits of meat.");
					pause();
					return crit;
					
				}
				else {
					println("You missed...");
					pause();
					return 0;
				}
					
				
			
			}
		}
		println("No critters were found today!");
		pause();
		return 0;
		
	}
	
	
	
	int money = 0;
	static int day = 0;
	static void survive(String location) {
		int food = 0;
		while (!dead) {
			food = 0;
			clr();
			println(location+" survival day "+day);
			pause();
			switch (day) {
				case 0:
					println("You need to first pick something to eat");
					if (question("Would you like to eat some [s]now or your [t]extbook?", "s", "t")) {
						println("It's a bit chilly, but satisfying nonetheless!");
					} else {
						println("You now have the power of trigonometry!");
						trig = true;
						weaponLevel +=2;
						println("With the power of trigonometry, you can more easily survive!");
						println("Your weapon level increased!");
					}
					pause();
					break;
				default:
					
					if (question("Will you food source for today be [h]unting, or [f]oraging?","h","f")) {
						food +=hunt();
					}
					else {
						int ber = new Random().nextInt(2);
						println("You find "+ber+" nuts and berries..");
						food += ber;
					}
			}
			practice();
			pause();
			if (day%10 ==0) {
				println("It's market day!");
				println("You have "+food+ " food units that you can sell.");
				println("Would you like to [b]uy a new throwing weapon? (Costs 3 food)");
				println("Or would you like to [p]ass?");
				if(question("","b","p")&& (food > 2)) {
					food -=3;
					weaponLevel++;
					println("Your weapon level is now "+ weaponLevel);
				}
				else {
					if (food < 3) {
						println("You don't have enough food to sell!");
					}
				}
			}
			if (food-2< 0) {
				println("You go home hungry today..");}
			player.takeDamage(-(food-2));
			println("Your health is now "+player.getHealth());
			day++;
			pause();
			if (player.getHealth() < 0) {
				dead = true;
			}
			

			
		}

	}

	static boolean dead = false;

	private static void escape() {
		println("If you are to escape, you need some kind of vehicle.");
		println("You see a bike, but you don't know how to ride it...");
		if (question("Would you like to learn via [t]rial and error, or from a [m]aster?", "t", "m")) {
			trial();
			master();
		} else {
			master();
		}
		if (dead) {
			return;
		}

	}

	static double bikeSkill = 0;
	
	static String y = "y";
	static String n = "n";

	static double weaponLevel = 3;
	
	private static void practice() {
		println("You are going to practice your bike skills...");
		if (!question("Are you sure you don't wanna back out? [y/n]", "y", "n")) {
			return;
		} else {
			println("Sounds good. You try to ride...");
			while (true) {
				if (Math.random() < 0.4) {
					player.takeDamage(new Random().nextInt(30));
					println("You slipped and hurt yourself!");
					println("Your health is now "+player.getHealth());
					if (player.getHealth() < 0) { dead = true; }
					return;
				}
				else {
					bikeSkill += Math.random()*2;
					println("You manage not to die! Your bike skill increases to "+bikeSkill);
				}
				if (!question("Would you like to keep practicing? [y/n]","y","n")) {
					return;
				}

			}

		}
	}
	
	private static void trial() {
		println("There is a good chance that you may die...");
		if (!question("Are you sure you don't wanna back out? [y/n]", "y", "n")) {
			master();
			return;
		} else {
			println("Sounds good. You try to ride...");
			while (true) {
				if (Math.random() < 0.2) {
					println("You slipped and broke you head open! No soup for you! You are now dead.");
					dead = true;
					return;
				}
				else {
					bikeSkill += Math.random()*2;
					println("You manage not to die! Your bike skill increases to "+bikeSkill);
				}
				if (!question("Would you like to keep practicing? [y/n]","y","n")) {
					return;
				}

			}

		}
	}

	private static void clr() {
		for (int i = 0; i < 40; i++) {
			println("");
		}
	}
	
	private static boolean wits() {
		Random rad = new Random();
		int val = rad.nextInt(5);
		switch (val) {
			case 0:
				clr();
				if (inputInt("How many holes are in a polo?") == 4) {
					println("Correct!");
					return true;
				}
				else 
				{
					println("WRONG!");
					return false;
				}
			case 1:
				if (question("Choose food:\n[a] rock\n[b] teeth","b","a")) {
					println("Yes! Teeth chew food!");
					return true;
				}
				else {
					println("WRONG!");
					return false;
				}
			case 2:
				if(inputInt("In what year was the U.S. Constitution written?")==1787) {
					return true;
				}
				break;
				
			case 3:
				if(input("What was the first planet to be discovered using Telescope (1781)?").toLowerCase().equals("uranus")) {
					println("We've got a smart one!");
					return true;
				}
				else {
					return false;
				}
			case 4:
				if(input("Valletta is the capital of which Mediterranian country? ").equals("malta")) {
					return true;
				}
				break;
			default:
				println("Dummy");
				return false;
				
				
				
		}
		return false;
		
	}
	
	private static String input(String ques) {
		println(ques);
		return sn.nextLine().toLowerCase();
	}
	
	private static int inputInt(String ques) {
		println(ques);
		return sn.nextInt();
	}
	
	private static boolean roulette() {
		Random rad = new Random();
		Random val = new Random();
		if (rad.nextInt(7)==val.nextInt(7)) {
			return true;
		};
		return false;
	}
	
	private static void buildShelter() {
		clr();

	}
	
	private static void master() {
		clr();
		println("The bikemster is known as Juan Pelota. ");
		println("He lives in a weird stoner land known as Washington...");
		if (question("Would you like to [h]ike or [s]wim the Missouri river?","h","s")){
			println("Smart choice.");
			println("Surprise! A bear greets you!");
			if (question("Would you like to challenge the bear to a game of [l]uck or [w]its?","l","w")) {
				println("Dunkaf! You are mauled to death!");
				dead = true;
				return;
			}
			else {
				if (wits()) {
					println("You defeat the bear! You may pass...");
				}
				else {
					println("Stoooopid idiot! The bear eats you out of pity!");
					dead = true;
					return;
				}
				
				sn.nextLine();
				println("You reach Juan Pelota.\n"
						+ "He is sitting atop a mountain of bicycles and crumpled up sponsorship deals."
						+ "....");
				sn.nextLine();
				println("He speaks to you. 'Hello stranger!' Would you like an autograph,\n"
						+ "or would you like to learn the origin of my name?'");
				if(question("You remember that you are on a quest to learn how to ride a bike.\n"
						+ "Will you [a]ttack directly or [e]ase your way into a deadly conversation?","a","e")) {
					deathByJuan();
					return;
				}
				else {
					println("You casually ask him: 'What is the origin of your name, Mr. Juan Pelota?'");
					pause();
					println("Two words: Testicular cancer");
					pause();
					if (question("Now is the time to attack! Will you use your [a]xe as a weapon, \nor the U.S. Anti [d]oping League? 0","a","d")) {
						deathByJuan();
						return;
					}
					else {
						clr();
						println("You unleash the full force of sportsmanship upon Juan!");
						println("His 7 Tour de France titles wither away!");
						bikeSkill += 5;
						println("Your bike skills have increased to "+bikeSkill);
						return;
					}
					
				}
			}
			
		}
		else {
			println("Stupid Idiot! You freeze to death!");
			dead = true;
			return;
		}
	}
	
	static void deathByJuan() {
		clr();
		println("Juan gives a roaring laugh...");
		pause();
		println("You try to swing your axe at him, but he is too fast!");
		pause();
		println("He proceeds to crush your skull in-between his thiccc biker thighs");
		println("You are dead.");
		dead = true;
		return;
	}

	static void pause() {
		sn.nextLine();
	}
	static void println(Object e) {
		Object line = e;
		if ((e instanceof String) && blind) {
			String s = (String) e;
			line = "";
			for (int i = 0; i < (s.length()); i++) {
				char c = s.charAt(i);
				c++;
				line += String.valueOf(c);
			}
		}
		System.out.println(line);
	}
}
