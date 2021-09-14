import java.util.Scanner;
import java.util.Calendar;

public class Game {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int stateId = 0;		
		String nameTag; //Declare String variable to hold text display on screen
		nameTag = "Jerry's Advanture\n";
		nameTag = nameTag + "by: Tantus Choomphupan";
		System.out.println(nameTag); //Print Game's title

		//Ask for user name and greeting user
		System.out.print("What is your name?: "); 
		String userName = scn.nextLine();
		printUserName(userName);
		
		//Ask for user birth year and calculate user age
		System.out.print("When were you born?: ");
		int userYear = scn.nextInt();
		printUserAge(calculateAge(userYear));
		scn.nextLine();
		
		//Tell user about the game scenario
		System.out.println("You are standing in an abandoned university office.There are neither students nor teachers around you. There’s a table in front of you with various papers, pens, a small puzzle toy, and a calculator.\nA large window shows an empty office building; thereare no Zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather havea craving for justice.");
		//ASk user for action and playback as confirmation
		//Loop Start Here
		do {
		String Action = getInput(scn);
		stateId = takeAction(Action, stateId);
		printState(stateId);
		} while (stateId != 666);
		
		scn.close();
	}
	
	//to print user name
	public static void printUserName(String userName){
		System.out.println("Hi " + userName + "!");
	}
	//to print user age
	public static void printUserAge(int userAge){
		System.out.println("You are " + userAge + " years old.");
	}
	//to calculate user age from year of birth
	public static int calculateAge(int userYear) {
		Calendar cld = Calendar.getInstance();
		int thisYear = cld.get(Calendar.YEAR);
		int userAge = thisYear - userYear; 
		return userAge;
	}

	public static String getInput(Scanner scn) {
		boolean x = true;
		String userString;
		String lowerString;

		do {
			System.out.print("What would you like to do?: ");
			userString = scn.nextLine();
			lowerString = userString.toLowerCase();

			switch(lowerString){
				case "open the door": 
				case "go north": 
				case "go east" :
				case "go south" :
				case "go west":
				case "take item" :
				case "drop item" :
				case "use item" :
				case "quit" :
					System.out.println(userString); x = false; break;
				default: 					
					System.out.println("Invalid input"); break;
			}

		} while(x == true);
		return lowerString;
	}

	public static int takeAction(String action, int currentState) {
		int newState = currentState;

			if (action.equals("quit")) {
				newState = 666;
				return newState;
			}

			if(currentState == 0) {
				if (action.equals("open the door")){
					newState = 1;	
				}
				else if (action.equals("take item")) {
					newState = 2;
				}
			} else if (currentState == 1) {
				 if(action.equals("go east")){
					 newState = 3;						
				}
			}
		return newState;
	}

	public static void printState(int newState) {
		switch(newState) {
			case 1: 
				System.out.println("You are in a long hallway. There’s a man wearing glasse sat the end of it, he looks harmless. West is a wall, east is the man, to the north is nothing but empty offices, a desperate sight. The carpeting in the hallway feels soft, you hear the clicking of a mouse in the distance. Your office is south (behind you).");
				break;
			case 2:
				System.out.println("You take the calculator from your desk. It’s a CasioFX-85gt Plus. The display shows the number 0.1134. You turn it upside down;now the Casio greets you with a friendly \"hello\", nice. You hold the calculator in your hand.");
				break;
			case 3:
				System.out.println("The man greets you and starts endlessly talking to you about his children and his holiday to Benidorm. You die of boredom.");
				break;
			default: 

		}
	}
}