package pacmanlogic;

/**
 * Logic class Ghost. Extends abstract class Entity and is used in Brain.
 */

public class Ghost extends Entity{

    //Instance variables
    private boolean powerStatus = false; 
    private int powerPelletCount = 25;
    private int[] position;
    private double[][] diffusedArray;


    //Constructors
    public Ghost(int[] initialPosition, double[][] array){
        setPosition(initialPosition);
        setDiffusedArray(array);
    }

    public Ghost(Ghost aGhost){
        this(aGhost.getPosition(), aGhost.getDiffusedArray());
    }

    /**
     * Returns the character value of Ghost, "G" or "g" that is used in the arrays 
     */
    @Override
    public String getCharacter() {
        if (powerStatus) return "g";
        else return "G";
    }

    /**
     * Returns the character value of the enemy Pacman, "P", that is used in the arrays
     */
    @Override
    public String getEnemyCharacter() {
        return "P";
    }

    /**
     * returns the next move Ghost will take
     */
    public int[] move(String input) {

        int[][] directions = {{0, -1}, {0, 1}, {1,-1}, {1, 1}};
        // Up, Down, Left, Right

        double [][] array = getDiffusedArray();
        int[] position = getPosition();
        double bestVal = array[position[0]][position[1]];
        int decision = 0;
        int[][] toCheck = {{position[0] - 1, position[1]}, {position[0] + 1, position[1]}, {position[0], position[1] - 1}, {position[0], position[1] + 1}};
        
        for (int i = 0; i < toCheck.length; i++) {
            if (toCheck[i][0] >= 0 && toCheck[i][0] <= array.length-1 && toCheck[i][1] >= 0 && toCheck[i][1] <= array[0].length-1) {
                if (!powerStatus) {
                    if (array[toCheck[i][0]][toCheck[i][1]] >= bestVal) {
                        bestVal = array[toCheck[i][0]][toCheck[i][1]];
                        decision = i;
                    }
                } else {
                    bestVal = 1;
                    if (array[toCheck[i][0]][toCheck[i][1]] <= bestVal && array[toCheck[i][0]][toCheck[i][1]] >= 0 ) {
                        bestVal = array[toCheck[i][0]][toCheck[i][1]];
                        decision = i;
                    }
                }
            }
        }

        return directions[decision];

    }

    /**
     * @return the diffusedArray
     */
    public double[][] getDiffusedArray() {
        return diffusedArray;
    }

    /**
     * @param diffusedArray the diffusedArray to set
     */
    public void setDiffusedArray(double[][] diffusedArray) {
        this.diffusedArray = diffusedArray;
    }
    
    /**
     * sets the position
     */
    public void setPosition(int[] position){
        this.position = position;
    }

    /**
     * returns the position
     */
    public int[] getPosition(){
        return new int[] {position[0], position[1]};
    }

    /**
     * @return true is edible, otherwise false
     */
    public boolean getPowerStatus(){
        return powerStatus;
    }

    /**
     * changes the edibility 
     */
    public void setPowerStatus(boolean value){
        powerStatus = value;
    }

    /**
     * @return the turns left until the power pellet has worn off
     */
    public int getCounter(){
        return powerPelletCount;
    }

    /**
     * decreases the counter by 1
     */
    public void decreaseCounter(){
        powerPelletCount--;
    }

    /**
     * resets the counter to 25
     */
    public void resetCounter(){
        if (powerPelletCount == 0){
            powerPelletCount = 25;
        }
    }
}
