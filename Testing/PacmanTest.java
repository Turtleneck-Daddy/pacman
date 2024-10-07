import static org.junit.Assert.*;
import org.junit.Test;
import pacmanlogic.*;
import java.util.Arrays;

public class PacmanTest{
    /* Checks the number of lives initially present. */
    @Test
    public void No_of_Lives_Initially(){
        Pacman p = new Pacman();
        assertEquals("The number of lives initially",3,p.getLives());
    }
    /* Checks if no of lives decrease if a life is lost */
    @Test
    public void No_of_Lives_after_Loss_Of_oneLife(){
        Pacman p = new Pacman();
        p.loseLife();
        assertEquals("The number of lives initially",2,p.getLives());
    }
    /* Checks if no of lives become 0 if three lives are lost */
    @Test
    public void No_of_Lives_after_Loss_Of_ThreeLives(){
        Pacman p = new Pacman();
        p.loseLife();
        p.loseLife();
        p.loseLife();
        assertEquals("The number of lives initially",0,p.getLives());
    }

    /*Checks if 100 points are added to the score*/
    @Test
    public void Adding_Score_100_points(){
        Pacman p = new Pacman();
        p.addScore(100);
        assertEquals("The number of lives initially",100,p.getScore());

    }

    /*Checks if the position can be changed*/
    @Test
    public void Checking_the_Position(){
        Pacman p = new Pacman();
        int [] pos = {1,2};
        p.setPosition(pos);
        assertEquals("The position is",pos,p.getPosition());

    }

    /*Checks if the right direction is taken on pressing 'w','s','a','d'*/
    @Test
    public void Checking_the_move(){
        Pacman p = new Pacman();
        int [] forW = {0,-1};
        int [] forS = {0, 1};
        int [] forA = {1, -1};
        int [] forD = {1, 1};

        assertEquals("The move when w is pressed should be up",true,Arrays.equals(p.move("w"), forW));
        assertEquals("The move when s is pressed should be down",true,Arrays.equals(p.move("s"), forS));
        assertEquals("The move when a is pressed should be left",true,Arrays.equals(p.move("a"), forA));
        assertEquals("The move when d is pressed should be right",true,Arrays.equals(p.move("d"), forD));

    }





}