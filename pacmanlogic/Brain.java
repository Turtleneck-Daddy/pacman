package pacmanlogic;

import java.util.Arrays;


/**
 * Logic class Brain. Takes classes Ghost, Pacman and World together and runs the gameplay.
 * Is used to run Text and Gui versions.
 */

public class Brain {

    public String[][] initialArray = {
        {"C", "C", "C", "C", "C", "C", "C", "C", "W", "C", "C", "C", "C", "C", "C", "C", "C"},

        {"O", "W", "W", "C", "W", "W", "W", "C", "W", "C", "W", "W", "W", "C", "W", "W", "O"},

        {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"},

        {"C", "W", "W", "C", "W", "C", "W", "W", "W", "W", "W", "C", "W", "C", "W", "W", "C"},

        {"C", "C", "C", "C", "W", "C", "C", "C", "W", "C", "C", "C", "W", "C", "C", "C", "C"},

        {"W", "W", "W", "C", "W", "W", "W", " ", "W", " ", "W", "W", "W", "C", "W", "W", "W"},

        {"W", "W", "W", "C", "W", " ", " ", " ", " ", " ", " ", " ", "W", "C", "W", "W", "W"},

        {"W", "W", "W", "C", "W", " ", "W", " ", " ", " ", "W", " ", "W", "C", "W", "W", "W"},

        {"W", "W", "W", "C", " ", " ", "W", " ", " ", " ", "W", " ", " ", "C", "W", "W", "W"},

        {"W", "W", "W", "C", "W", " ", "W", "W", "W", "W", "W", " ", "W", "C", "W", "W", "W"},

        {"W", "W", "W", "C", "W", " ", " ", " ", " ", " ", " ", " ", "W", "C", "W", "W", "W"},

        {"W", "W", "W", "C", "W", " ", "W", "W", "W", "W", "W", " ", "W", "C", "W", "W", "W"},

        {"C", "C", "C", "C", "C", "C", "C", "C", "W", "C", "C", "C", "C", "C", "C", "C", "C"},

        {"C", "W", "W", "C", "W", "W", "W", "C", "W", "C", "W", "W", "W", "C", "W", "W", "C"},

        {"O", "C", "W", "C", "C", "C", "C", "C", " ", "C", "C", "C", "C", "C", "W", "C", "O"},

        {"W", "C", "W", "C", "W", "C", "W", "W", "W", "W", "W", "C", "W", "C", "W", "C", "W"},

        {"C", "C", "C", "C", "W", "C", "C", "C", "W", "C", "C", "C", "W", "C", "C", "C", "C"},

        {"C", "W", "W", "W", "W", "W", "W", "C", "W", "C", "W", "W", "W", "W", "W", "W", "C"},        

        {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C"},        

    };

    //Instance variables
    private int width = initialArray.length;
    private int height = initialArray[0].length;

    // -1: wall -2: ghost
    public double[][] diffusedArray = {
        {0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0},

        {0, -1, -1, 0, -1, -1, -1, 0, -1, 0, -1, -1, -1, 0, -1, -1, 0},

        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

        {0, -1, -1, 0, -1, 0, -1, -1, -1, -1, -1, 0, -1, 0, -1, -1, 0},

        {0, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, 0},

        {-1, -1, -1, 0, -1, -1, -1, 0, -1, 0, -1, -1, -1, 0, -1, -1, -1},

        {-1, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, -1},

        {-1, -1, -1, 0, -1, 0, -1, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1},

        {-1, -1, -1, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, -1, -1, -1},

        {-1, -1, -1, 0, -1, 0, -1, -1, -1, -1, -1, 0, -1, 0, -1, -1, -1},

        {-1, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, -1},

        {-1, -1, -1, 0, -1, 0, -1, -1, -1, -1, -1, 0, -1, 0, -1, -1, -1},

        {0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0},

        {0, -1, -1, 0, -1, -1, -1, 0, -1, 0, -1, -1, -1, 0, -1, -1, 0},

        {0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0},

        {-1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1},

        {0, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, 0},

        {0, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, 0},        

        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},        

    };

    //Instance Variables
    public int amountOfCoins = 0;
    private final int[] initialPlayerPosition = {14, 8};
    private final int[] initialGhost1Position = {6, 8}; 
    private final int[] initialGhost2Position = {8, 7}; 
    private final int[] initialGhost3Position = {8, 8}; 
    private final int[] initialGhost4Position = {8, 9}; 

    private Pacman player = new Pacman(initialPlayerPosition);
    private Ghost ghost1 = new Ghost(initialGhost1Position, diffusedArray);
    private Ghost ghost2 = new Ghost(initialGhost2Position, diffusedArray);
    private Ghost ghost3 = new Ghost(initialGhost3Position, diffusedArray);
    private Ghost ghost4 = new Ghost(initialGhost4Position, diffusedArray);
    private Ghost[] ghostArray = {ghost1, ghost2, ghost3, ghost4};
    private World gameWorld = new World(initialArray, player.getPosition(), ghost1.getPosition());
    
    //Getters

    /**
     * @return the width of array
     */
    public int getWidth(){
        return width;
    }

    /**
     * @return the height of the array
     */
    public int getHeight(){
        return height;
    }

    /**
     * @return the player of type Pacman
     */
    public Pacman getPlayer(){
        return player;
    }

    /**
     * @param number
     * @return the specified ghost of type Ghost
     */
    public Ghost getGhost(int number){
        switch(number){
            case 1:
                return ghost1;
            case 2:
                return ghost2;
            case 3:
                return ghost3;
        }
        return ghost4;
    }

    /**
     * @return the gameworld
     */
    public World getGameWorld(){
        return gameWorld;
    }

    /**
     * @return the amount of coins remaining on map
     */
    public int getAmountOfCoins(){
        return amountOfCoins;
    }

    /**
     * @return initial player position
     */
    public int[] getInitialPlayerPosition(){
        return new int[] {initialPlayerPosition[0], initialPlayerPosition[1]};
    }

    /**
     * @param number
     * @return the initial position of ghost specified by number
     */
    public int[] getInitialGhostPosition(int number){
        switch(number){
            case 1:
                return new int[] {initialGhost1Position[0], initialGhost1Position[1]};
            case 2:
                return new int[] {initialGhost2Position[0], initialGhost2Position[1]};
            case 3:
            return new int[] {initialGhost3Position[0], initialGhost3Position[1]};
        }
        return new int[] {initialGhost4Position[0], initialGhost4Position[1]};
    }

    /**
     * @return the ghostArray
     */
    public Ghost[] getGhostArray() {
        return ghostArray;
    }


    public void updateDiffArr() {
        for (int row = 0; row < diffusedArray.length; row++) {
            for (int col = 0; col < diffusedArray[0].length; col++) {
                if (diffusedArray[row][col] == -2 || diffusedArray[row][col] == 1) diffusedArray[row][col] = 0;
            }
        }
        diffusedArray[player.getPosition()[0]][player.getPosition()[1]] = 1;
        for (Ghost ghost : ghostArray) {
            diffusedArray[ghost.getPosition()[0]][ghost.getPosition()[1]] = -2;
        }
    }

    public void diffuse() {
        for (int row = 0; row < diffusedArray.length; row++) {
            for (int col = 0; col < diffusedArray[row].length; col++) {
                if (diffusedArray[row][col] < 0) {
                    continue;
                } else if (diffusedArray[row][col] == 1) {
                    continue;
                }

                double sumOfAdjacents = 0;
                int tilesUsed = 0;
                int[][] toGet = {{row - 1, col}, {row, col - 1}, {row, col + 1}, {row + 1, col}};
                
                for (int[] coord : toGet) {
                    if (coord[0] >= 0 && coord[0] <= diffusedArray.length-1 && coord[1] >= 0 && coord[1] <= diffusedArray[0].length-1 && diffusedArray[coord[0]][coord[1]] >= 0) {
                        sumOfAdjacents += diffusedArray[coord[0]][coord[1]];
                        tilesUsed++;
                    }
                }

                if (tilesUsed > 0) diffusedArray[row][col] = sumOfAdjacents/tilesUsed;
                else diffusedArray[row][col] = sumOfAdjacents/1;

            }
        }

    }

    public void diffuseFully() {
        for (int row = 0; row < diffusedArray.length; row++) {
            for (int col = 0; col < diffusedArray[0].length; col++) {
                if (diffusedArray[row][col] == 0.0) {
                    diffuse();
                }
            }
        }
    }


   /**
    * checks if desiered move applied to the mover is within bounds. If appropriate then the mover Entity is moved
    * move is in the format [a,b] where a (0 or 1) that represents vertical or horizonal and b (1, or -1) represents forward or backwards
    * @param mover
    * @param move
    */
    public void validateMove(Entity mover, int[] move) {
        int[] position =  mover.getPosition();
        int toCheck = position[move[0]] + move[1];
        int ceiling;
        int w = position[0];
        int h = position[1];
        if (move[0] == 0){
            ceiling = width;
            w += move[1];
        } else {
            ceiling = height;
            h += move[1];
        }

        if (toCheck < 0 || toCheck >= ceiling || gameWorld.getCoinArr()[w][h] == "W"){
            System.out.println("Couldn't move, Did nothing." + mover.getCharacter() + " Tried to move" + move[0] + " " + move[1]);
        } else {
            move(mover, move);
        }

    }

    /**
     * Updates position of movable object, mover
     * Resets the position if ghost and pacman intersect, depending on the ghost status (edible up or not)
     * @param mover
     * @param move
     */
    public void move(Entity mover, int[] move) {
        
        int[] position = mover.getPosition();
        boolean munched = false;
        int number = 1;
        for (Ghost ghost : ghostArray) {
            if (player.getPosition()[0] == ghost.getPosition()[0] && player.getPosition()[1] == ghost.getPosition()[1]) {
                munched = true;
                System.out.println("MUNCH");
                resetPosition(ghost, number);
                break;
            }
            number++;
        }
        
		if (! munched) {
			String[][] newArr = gameWorld.copyArr(gameWorld.getMovingArr());
            String character = newArr[position[0]][position[1]];
                        
            newArr[position[0]][position[1]] = " ";
            position[move[0]] = position[move[0]] + move[1]; 
            int[] newLocation = position;

            mover.setPosition(newLocation);

			newArr[position[0]][position[1]] = character;

			gameWorld.setMovingArr(newArr);
        }
        
        updateDiffArr();
        diffuseFully();
    }

    /**
     * Checks if pacman obtained a power pellet or coin	and updates score accordingly
    */
    public void checkCoins() {
        String[][] coins = gameWorld.getCoinArr();
        String[][] newCoins = gameWorld.copyArr(coins);
        int[] playerPosition = player.getPosition();
						
        if (coins[playerPosition[0]][playerPosition[1]] != " "){
            if (coins[playerPosition[0]][playerPosition[1]] == "C") {
                player.addScore(100);
                if(checkWin()== true){
                    
                    System.out.println("YOU WON");
                }
            } else if (coins[playerPosition[0]][playerPosition[1]] == "O"){
                player.addScore(250);
				newCoins[playerPosition[0]][playerPosition[1]] = " ";
				gameWorld.setCoinArr(newCoins);
				System.out.println("Collected PowerPellet!");
                activatePowerUp();
                if(checkWin() == true){
                    System.out.println("YOU WON");
                }
            }
            newCoins[playerPosition[0]][playerPosition[1]] = " ";
            gameWorld.setCoinArr(newCoins);
            System.out.println("Collected!");
        }
        
    }

    /**
     * @return true if all coins has been collected
     */
    public boolean checkWin() {
        amountOfCoins = 0;
        for (int x= 0; x < getDisplayArr().length; x++){
            for (int y= 0; y < getDisplayArr()[0].length; y++) {
                
                if (getDisplayArr()[x][y] == "C" ) {
                    amountOfCoins ++;
                }
            }
        }
        if( amountOfCoins == 0){
            return true;
        }
        else {
            System.out.println("this is amount of coins: " + amountOfCoins);
            return false;
        }
    }
 
	/**
     * Checks lives of player or ghost and resets the position if necessary
	*/
	public void checkLives(){
        int number = 1;
        for (Ghost ghost : ghostArray) {
            if (player.getPosition()[0] == ghost.getPosition()[0] && player.getPosition()[1] == ghost.getPosition()[1]) {

                if (player.getLives() > 0 && !ghost.getPowerStatus()) {
                    player.loseLife();
                    System.out.println("You lost a life!");
                }
                resetPosition(ghost, number);

                break;
            }
            number++;
        }

	}
	
	/**
     * returns the game board to be used in displayBoard
	*/
    public String[][] getDisplayArr() {
        String[][] moving = gameWorld.getMovingArr();
        String[][] coins = gameWorld.getCoinArr();
        String[][] board = new String[moving.length][moving[0].length];
        
        for(int i =0; i< moving.length;i++){
            for (int j =0;j < moving[0].length; j++) {
                if (moving[i][j] != " ") {
                    board[i][j] = moving[i][j];
                } else if (coins[i][j] != " ") {
                    board[i][j] = coins[i][j];
                } else {
                    board[i][j] = " ";
                }
            }
        }
        return board;
    }    
	
	/**
     * Allows pacman to eat the ghosts after obtaining a power pellet 
	*/
	public void activatePowerUp(){
        for (Ghost ghost : ghostArray) {
            ghost.setPowerStatus(true);
        }
		gameWorld.setPowerUpArr();
    }
    
    /**
     * resets the power status of the ghost once it has been eaten
     * @param ghost
     */
    public void deactivatePowerUp(Ghost ghost){
		ghost.setPowerStatus(false); 
		gameWorld.resetFromPowerUpArr();  
    }
	
	/**
     * resets movable object to initial positions in consumbed by an enemy
	*/
	public void resetPosition(Ghost ghost, int number) {
		
        String[][] newMoveArr = gameWorld.copyArr(gameWorld.getMovingArr());
        Entity eaten;
		
		if (!ghost.getPowerStatus()){
            eaten = player;
		}
		else {
            eaten = ghost;
            ghost.setPowerStatus(false);
			
        }
        
        int[] eatenPosition = eaten.getPosition();
        
        newMoveArr[eatenPosition[0]][eatenPosition[1]] = eaten.getEnemyCharacter();
        
        if (eaten.getCharacter().equals("P")) {
            eaten.setPosition(new int[] {14,8});
            newMoveArr[0][0] = eaten.getCharacter();
        } else if(number == 1) {
            eaten.setPosition(new int[] {6,8});
		    newMoveArr[2][4] = eaten.getCharacter();
        }else if(number == 2) {
            eaten.setPosition(new int[] {8,7});
		    newMoveArr[2][4] = eaten.getCharacter();
        }else if(number == 3) {
            eaten.setPosition(new int[] {8,8});
		    newMoveArr[2][4] = eaten.getCharacter();
        }else if(number == 4) {
            eaten.setPosition(new int[] {8,9});
		    newMoveArr[2][4] = eaten.getCharacter();
        }

        gameWorld.setMovingArr(newMoveArr);
	}
	
 
	/**
     * games over when lives have run out
	*/
    public boolean checkGameOver() {
        
        return player.getLives() == 0;
    }

    /**
     * For displaying the array in matrix form
     * @param display
     */
	public void display(String display[][]){
		for(int i =0; i< display.length;i++){
            System.out.print("| ");
				for (int j = 0; j < display[0].length; j++){
					System.out.print(display[i][j] + " ");
                }
            System.out.print("|");
            System.out.println();
        }
		System.out.println();        
    }
    
    /**
     * To display actual game board in text based version
     */
    public void displayBoard() {
        String[][] moving = gameWorld.getMovingArr();
        String[][] coins = gameWorld.getCoinArr();

        for(int i =0; i< moving.length;i++){
            System.out.print("|");
				for (int j =0;j < moving[0].length; j++){
                    if (moving[i][j] != " ") {
                        System.out.print(moving[i][j] + " ");
                    } else if (coins[i][j] != " "){
                        System.out.print(coins[i][j] + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
            System.out.print("|");
            System.out.println();
        }
		System.out.println();

    }
   
}
