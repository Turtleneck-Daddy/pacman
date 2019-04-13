
package pacmanlogic;

/**
 * pacman
 */
public class Pacman extends Entity{
	
	//Instance varaibles
	private int score = 0;
	private int lives = 3;
	public int[] prevMove = new int[] {0, -1};
	private int[] position;

	//constructor
	public Pacman(int[] initialPosition){
        setPosition(initialPosition);
	}

	public Pacman(){

	}
	
	/**
	This method takes in user input and converts it into the correct format to be used in Brain.java
	*/
    public int[] move(String input){
        System.out.println(input);
		int[] direction;
			
		System.out.println(prevMove[0] + "  " + prevMove[1]);
		switch(input) { 
			case "w":
				direction = new int[] {0, -1};
				break;

			case "s":
				direction = new int[] {0, 1};
				break;

			case "a":
				direction = new int[] {1, -1};
				break;

			case "d":
				direction = new int[] {1, 1};
				break;

            default:
				// previous move
                return prevMove;
		}
		this.prevMove = direction;

        return direction;
		
	}

    /**
     * Returns the character value of Pacman, "P" that is used in the arrays 
     */
	@Override
	public String getCharacter() {
		return "P";
	}

	/**
     * Returns the character value of the enemy Ghost, "G", that is used in the arrays
     */
	@Override
	public String getEnemyCharacter() {
		return "G";
	}

	/**
	 * Sets position of Pacman
	 */
	public void setPosition(int[] position){
		this.position = position;
	}

	/**
	 * returns position
	 */
	public int[] getPosition(){
		return position;
	}

	/**
	 * @return number of lives
	 */
	public int getLives(){
		return lives;
	}

	/**
	 * @return the score
	 */
	public int getScore(){
		return score;
	}

	/**
	 * decreases the lives by 1
	 */
	public void loseLife(){
		lives--;
	}
	
	/**
	 * adds to the score
	 * @param aScore
	 */
	public void addScore(int aScore){
		score += aScore;
	}
}
