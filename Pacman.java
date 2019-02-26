import java.util.Scanner;
import java.util.Arrays;

/**
 * pacman
 */
public class Pacman {

	/**
	This method takes in user input and converts it into the correct format to be used in Brain.java
	*/
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

				case "l":
					direction[0] = 1;
					direction[1] = -1;
					break;

				case "r":
					direction[0] = 1;
					direction[1] = 1;
					break;

                default:
                    // no movement aka magnitude 0
                    direction[0] = 0;
                    direction[1] = 0;
				break;
			}

        return direction;
		
		
	}
	
}
