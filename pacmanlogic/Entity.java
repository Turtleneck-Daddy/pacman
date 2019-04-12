package pacmanlogic;

/**
 * Abstract class Entity. Parent class of movable objects Pacman and Ghost
 */

public abstract class Entity{
    
    public abstract int[] move(String input);

    public abstract void setPosition(int[] position);

    public abstract int[] getPosition();

    public abstract String getCharacter();

    public abstract String getEnemyCharacter();    
    
}
