import java.util.Arrays;

/**
 * brain
 */
public class Brain {
    public static String[][] initialArray = {{" ", " ", "W", " "}, {" ", " ", "W", " "}, {" ", " ", "W", " "}, {" ", " ", " ", " "}};
    public static int width = initialArray.length;
    public static int height = initialArray[0].length;
    public static int[] playerPosition = {0, 0};
    public static int[] ghostPosition = {width-1, height-1};
    public static ghost ghost1 = new ghost();
    public static world gameWorld = new world(initialArray, playerPosition, ghostPosition);
    
    // score
    public static int score = 0;

    // check for valid moves
    public static void validateMove(int[] position, int[] move) {
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
            System.out.println(move[0] + ", " + move[1]);
            System.out.println("Couldn't move, Did nothing");
        } else {
            move(position, move);
        }

    }

    // move
    public static void move(int[] position, int[] move) {
        String[][] newArr = gameWorld.copyArr(gameWorld.getMovingArr());
        String character = newArr[position[0]][position[1]];

        newArr[position[0]][position[1]] = " ";
        position[move[0]] = position[move[0]] + move[1];

        newArr[position[0]][position[1]] = character;

        gameWorld.setMovingArr(newArr);
    }

    // check if pacman got coin/powerup
    public static void checkCoins() {
        String[][] coins = gameWorld.getCoinArr();
        if (coins[playerPosition[0]][playerPosition[1]] != " "){
            if (coins[playerPosition[0]][playerPosition[1]] == "C") {
                score += 100;
            } else if (coins[playerPosition[0]][playerPosition[1]] == "P"){
                score += 250;
            }
            String[][] newCoins = gameWorld.copyArr(coins);
            newCoins[playerPosition[0]][playerPosition[1]] = " ";
            gameWorld.setCoinArr(newCoins);
            System.out.println("Collected!");
        }
    }
 
    // check if ghost is exactly 1 move away from pacman
    //if the vertical distance between ghost an player is 1 and horisontal is 0 (or vice-versa) that means they are exactly 1 move apart, so game over
    // true means you lost false means still going
    public static boolean checkGameOver() {
        int wDist = Math.abs(playerPosition[0] - ghostPosition[0]);
        int hDist = Math.abs(playerPosition[1] - ghostPosition[1]);

        return (wDist == 1 & hDist == 0) || (wDist == 0 & hDist == 1);
    }

    //For displaying arrays in  matrix form
	public static void display(String display[][]){
		for(int i =0; i< display.length;i++){
            System.out.print("| ");
				for (int j =0;j<display.length; j++){
					System.out.print(display[i][j]+" ");
                }
            System.out.print("|");
            System.out.println();
        }
		System.out.println();        
	}

    public static void main(String[] args) {
        display(gameWorld.getCoinArr());
        display(gameWorld.getMovingArr());

        // testing the move and validate move methods
        checkCoins();
        validateMove(ghostPosition, ghost1.getRandomMove());

        display(gameWorld.getCoinArr());
        display(gameWorld.getMovingArr());
        
        checkCoins();
        validateMove(ghostPosition, ghost1.getRandomMove());

        display(gameWorld.getCoinArr());
        display(gameWorld.getMovingArr());
        
        checkCoins();
        validateMove(ghostPosition, ghost1.getRandomMove());

        display(gameWorld.getCoinArr());
        display(gameWorld.getMovingArr());
    }
}
