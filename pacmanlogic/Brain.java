package pacmanlogic;

import java.util.Arrays;


/**
 * brain
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
                        //System.out.println("( "+ row + " " + col + " ) (" + coord[0] + " " + coord[1] + " ) " + result[coord[0]][coord[1]]);
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
                    // row = 0;
                    // col = 0;
                    diffuse();
                    // for (double[] tiles : diffusedArray) {
                    //     for (double item : tiles) {
                    //         System.out.print(item + " ");
                    //     }
                    //     System.out.println();
                    // }
                    // System.out.println();
            
                }
            }
        }
    }
    
    //Getters and setters
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Pacman getPlayer(){
        return player;
    }

    public Ghost getGhost(){
        return ghost1;
    }

    public World getGameWorld(){
        return gameWorld;
    }

    /**
     * @return the ghostArray
     */
    public Ghost[] getGhostArray() {
        return ghostArray;
    }

   /**
   	checks for valid moves of movable objects, moving them accordingly
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
            // do nothing
            System.out.println("Couldn't move, Did nothing." + mover.getCharacter() + " Tried to move" + move[0] + " " + move[1]);
        } else {
            move(mover, move);
            // System.out.println(initialPlayerPosition[0] + " " +  initialPlayerPosition[1]);
            // System.out.println(initialGhostPosition[0] + " " +  initialGhostPosition[1]);
        }

    }

    // updates position of movable object
    public void move(Entity mover, int[] move) {
		//Resets the position if they intersect, depending on the Pacmans status (powered up or not)
		//Current parameters: Pacman gets sent to top left, ghost gets sent to inside the box
		//BUG: can not get the GUI version to take any keyboard input until counter runs out
		//     the game halts until the counter runs out for the power pellet
        
        int[] position = mover.getPosition();
        boolean munched = false;

        for (Ghost ghost : ghostArray) {
            if (player.getPosition()[0] == ghost.getPosition()[0] && player.getPosition()[1] == ghost.getPosition()[1]) {
                munched = true;
                System.out.println("MUNCH");
                resetPosition(ghost);
                break;
            }
        }
        
		// if (player.getPosition()[0] == ghost1.getPosition()[0] && player.getPosition()[1] == ghost1.getPosition()[1]) {
        //     System.out.println("MUNCH");
		// 	resetPosition();
        // }
        
		if (! munched) {
			String[][] newArr = gameWorld.copyArr(gameWorld.getMovingArr());
            String character = newArr[position[0]][position[1]];
                        
            newArr[position[0]][position[1]] = " ";
            position[move[0]] = position[move[0]] + move[1]; 
            int[] newLocation = position;


            mover.setPosition(newLocation);

            // this next line might be the issue
			newArr[position[0]][position[1]] = character;

			gameWorld.setMovingArr(newArr);
        }
        
        updateDiffArr();
        diffuseFully();
        // System.out.println(ghost1.getPowerStatus() + " " + ghost1.getPosition()[0] + " " + ghost1.getPosition()[1]);
    }

    /**
    	Checks if pacman obtained a power pellet or coin	
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
	    Checks lives of player or ghost and resets the position if necessary
	*/
	public void checkLives(){
        // boolean intersect = false;
        // Ghost intersectedGhost;

        for (Ghost ghost : ghostArray) {
            if (player.getPosition()[0] == ghost.getPosition()[0] && player.getPosition()[1] == ghost.getPosition()[1]) {
                // intersect = true;
                // intersectedGhost = ghost;

                if (player.getLives() > 0 && !ghost.getPowerStatus()) {
                    player.loseLife();
                    System.out.println("You lost a life!");
                }
                resetPosition(ghost);

                break;
            }
        }

	}
	
	/**
		returns the game board
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
		Allows pacman to eat the ghosts after obtaining a power pellet (only functional in the Text base version)
	*/
	public void activatePowerUp(){
        for (Ghost ghost : ghostArray) {
            ghost.setPowerStatus(true);
        }
		gameWorld.setPowerUpArr();
    }
    
    public void deactivatePowerUp(Ghost ghost){
		ghost.setPowerStatus(false); 
		gameWorld.resetFromPowerUpArr();  
    }
	
	/**
		resets pacman to the first block if lives stil remain, and ghost to the inside box if consumed
	*/
	public void resetPosition(Ghost ghost) {
		
        String[][] newMoveArr = gameWorld.copyArr(gameWorld.getMovingArr());
        Entity eaten;
        // double toPlace;

        // make sure to check all ghosts
		
		if (!ghost.getPowerStatus()){

            eaten = player;
            // toplace = 1;
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
        } else {
            eaten.setPosition(new int[] {6,8});
		    newMoveArr[2][4] = eaten.getCharacter();
        }

        gameWorld.setMovingArr(newMoveArr);
	}
	
 
	/**
		games over when lives have run out
	*/
    public boolean checkGameOver() {
        
        return player.getLives() == 0;
    }

    //For displaying arrays in  matrix form (good for debugging)
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
    
    // for displaying the actual game board
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
