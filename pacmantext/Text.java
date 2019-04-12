import pacmanlogic.*;
import java.util.Scanner;

public class Text {

        public static void main(String[] args) {
        // Gameloop
        Brain gameBrain = new Brain();
        Scanner keyboard = new Scanner(System.in);
        Pacman player = gameBrain.getPlayer();

        while (!gameBrain.checkGameOver() && !gameBrain.checkWin()){
            gameBrain.displayBoard();
            gameBrain.validateMove(player, player.move(keyboard.nextLine()));

            gameBrain.checkLives();
                        
            gameBrain.checkCoins();
              
            int number = 1;
            for (Ghost ghost : gameBrain.getGhostArray()) {
                gameBrain.validateMove(ghost, ghost.move("s"));             
                            
                if(ghost.getPowerStatus() && ghost.getCounter() > 0){
                    ghost.decreaseCounter();
                }
                else{
                    gameBrain.deactivatePowerUp(ghost);
                    gameBrain.getGhost(number).resetCounter();
                }
                number++;
            }
            gameBrain.checkLives();
        }
        keyboard.close();
    }
}
    
    
  
