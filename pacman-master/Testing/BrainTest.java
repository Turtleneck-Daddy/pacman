import static org.junit.Assert.*;
import org.junit.Test;
import pacmanlogic.*;
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class BrainTest{

    @Test
    public void Width_of_Game_Board(){
        Brain b = new Brain();
        assertEquals("The width of game should be equal to the number of rows of the initial array (array containing walls)",b.initialArray.length,b.getWidth());
        

    }

    @Test
    public void Height_of_Game_Board(){
        Brain b = new Brain();
        assertEquals("The width of game should be equal to the number of columns of the initial array (array containing walls)",b.initialArray[0].length,b.getHeight());

    }

}