import java.util.Arrays;

/**
 * brain
 */
public class brain {
    public static int width = 4;
    public static int height = 4;
    public static int[] playerPosition = {0, 0};
    public static int[] ghostPosition = {width-1, height-1};
    public static ghost ghost1 = new ghost();
    public static world gameWorld = new world(width, height, playerPosition, ghostPosition);
    
    // score
    public static int score = 0;

    // check for valid moves
    public static void validateMove(int[] position, int[] move) {
        int toCheck = position[move[0]] + move[1];
        int ceiling;
        if (move[0] == 0){
            ceiling = width;
        } else {
            ceiling = height;
        }

        if (toCheck < 0 || toCheck >= ceiling){
            // do nothing
            System.out.println(move);
            System.out.println("Couldn't move, Did nothing");
        } else {
            move(position, move);
        }

    }

    // move
    public static void move(int[] position, int[] move) {
        String[][] newArr = gameWorld.copyArr(gameWorld.getMovingArr());
        String character = newArr[position[0]][position[1]];

        newArr[position[0]][position[1]] = null;
        position[move[0]] = position[move[0]] + move[1];

        newArr[position[0]][position[1]] = character;

        gameWorld.setMovingArr(newArr);
    }

    // check if pacman got coin/powerup

    // check if ghost go pacman

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(gameWorld.getCoinArr()));
        System.out.println(Arrays.deepToString(gameWorld.getMovingArr()));

        // testing the move and validate move methods

        validateMove(ghostPosition, ghost1.getRandomMove());

        System.out.println(Arrays.deepToString(gameWorld.getCoinArr()));
        System.out.println(Arrays.deepToString(gameWorld.getMovingArr()));

        validateMove(ghostPosition, ghost1.getRandomMove());

        System.out.println(Arrays.deepToString(gameWorld.getCoinArr()));
        System.out.println(Arrays.deepToString(gameWorld.getMovingArr()));

        validateMove(ghostPosition, ghost1.getRandomMove());

        System.out.println(Arrays.deepToString(gameWorld.getCoinArr()));
        System.out.println(Arrays.deepToString(gameWorld.getMovingArr()));
    }
}