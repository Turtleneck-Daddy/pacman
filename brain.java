import java.util.Arrays;

/**
 * brain
 */
public class brain {
    public static int width = 4;
    public static int height = 4;
    public static int[] playerPosition = {0, 0};
    public static int[] ghostPosition = {width-1, height-1};
    public static world gameWorld = new world(width, height, playerPosition, ghostPosition);
    
    // score

    // check for valid moves

    // check if pacman got coin/powerup

    // check if ghost go pacman

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(gameWorld.getCoinArr()));
        System.out.println(Arrays.deepToString(gameWorld.getMovingArr()));
    }
}