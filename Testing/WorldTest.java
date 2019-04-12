import static org.junit.Assert.*;
import org.junit.Test;
import pacmanlogic.*;
import java.util.Arrays;

public class WorldTest{
    @Test
    public void CoinArray_is_2D_array(){
        World w = new World();
        String [][] twoDArray = {
            {" ", " ", " ", " ", "W", "W", "W", " ", "W", " "},
    
            {" ", "W", " ", "W", "W", "W", " ", " ", " ", " "},
    
            {" ", "W", " ", " ", " ", " ", " ", "W", "W", " "},
    
            {" ", " ", " ", " ", " ", " ", " ", "W", " ", " "},
    
        };
        w.setCoinArr(twoDArray);

        assertEquals("The array should be set to",true,Arrays.equals(w.getCoinArr(), twoDArray));

    }

    @Test
    public void MovingArray_is_2D_array(){
        World w = new World();
        String [][] twoDArray = {
            {" ", " ", " ", " ", "W", "W", "W", " ", "W", " "},
    
            {" ", "W", " ", "W", "W", "W", " ", " ", " ", " "},
    
            {" ", "W", " ", " ", " ", " ", " ", "W", "W", " "},
    
            {" ", " ", " ", " ", " ", " ", " ", "W", " ", " "},
    
        };
        w.setMovingArr(twoDArray);

        assertEquals("The array should be set to",true,Arrays.equals(w.getMovingArr(), twoDArray));

    }




}