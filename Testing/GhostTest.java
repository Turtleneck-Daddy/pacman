import static org.junit.Assert.*;
import org.junit.Test;
import pacmanlogic.*;
import java.util.Arrays;

public class GhostTest{
    @Test
    public void value_of_powerstatus_is_boolean(){
        Ghost g = new Ghost();
        g.setPowerStatus(true);
        assertEquals("The powerstatus getters and setters must be boolean",true,(g.getPowerStatus()));
    }

    @Test
    public void Testing_decrease_Counter(){
        Ghost g = new Ghost();
        g.decreaseCounter();
        assertEquals("The power pellet counter must decrease after calling decrease counter.",19,(g.getCounter()));
    }

    @Test
    public void Testing_Initial_Position_of_ghost(){
        Ghost g = new Ghost();
        int [] counter = {2,4};
        g.setPosition(counter);
        assertEquals("The initial position should be",counter,(g.getPosition()));

        



    }


    
}