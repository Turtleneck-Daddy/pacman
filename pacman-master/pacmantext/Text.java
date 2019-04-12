package pacmantext;
import pacmanlogic.*;
import java.util.Scanner;

public class Text {

        public static void main(String[] args) {
        // Gameloop
        Brain gameBrain = new Brain();
        Scanner keyboard = new Scanner(System.in);
        Pacman player = gameBrain.getPlayer();
        Ghost ghost1 = gameBrain.getGhost();

        while (!gameBrain.checkGameOver() && !gameBrain.checkWin()){
            gameBrain.displayBoard();
            gameBrain.validateMove(player, player.move(keyboard.nextLine()));

            gameBrain.checkLives();
            gameBrain.validateMove(ghost1, ghost1.move("s")); 

            gameBrain.checkCoins();

            if(ghost1.getPowerStatus() && ghost1.getCounter() > 0){
                ghost1.decreaseCounter();
            }
            else{
                gameBrain.deactivatePowerUp(ghost1);
                gameBrain.getGhost().resetCounter();
            }
            gameBrain.checkLives();
        }
    }
}
    
    
  
