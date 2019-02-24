import java.util.Scanner;


/**
 * pacman
 */
public class Pacman {

    public static int[] move(){
		Scanner keyboard = new Scanner(System.in);
		
		String input = keyboard.nextLine();
		int[] direction = new int[2];
		
		switch(input) {
			case "u":
				direction[0] = 0;
				direction[1] = -1;
				break;
				
			case "d":
				direction[0] = 0;
				direction[1] = 1;
				break;
			
			case "r":
				direction[0] = 1;
				direction[1] = -1;
				break;
			
			case "l":
				direction[0] = 1;
				direction[1] = 1;
				break;
		}
		
		return direction;
		
		
	}
	
}