import java.util.Random;
/**
 * ghost
 */
public class ghost {

    private static final Random RANDOM = new Random();

    public String getRandomMove() {
        int rand = RANDOM.nextInt(4);
        String[] directions = {"U", "D", "L", "R"};

        return directions[rand];
    }
}