import java.util.Scanner;

public class PacManDemo {
	
	
	public static void main(String[] args) {
		
		//setting up the variables
		Scanner keyboard = new Scanner(System.in);
		
		boolean gameWon = false;
		
		int ROW = 5;
		int COL = 5;
		int pRow = 0;
		int pCol = 0;
		int points = 0;
	
		int[][] coins = new int[5][5];
		char[][] walls = new char[5][5];
		char[][] pacman = new char[5][5];
		
		//Let 1 represent coin, 0 represent no coin
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COL; j++) {
				coins[i][j] = 1;
			}
		}
		coins[0][0] = 0;
		
		//Let w represent walls;
		walls[1][0] = 'w';
		walls[1][1] = 'w';
		walls[1][2] = 'w';
		walls[1][3] = 'w';
		walls[2][3] = 'w';
		walls[3][3] = 'w';
		walls[3][2] = 'w';
		walls[3][1] = 'w';
		
		//Let pacman start at 0,0
		pacman[pRow][pCol] = 'P'; //array needed for GUI(I think)
		
		//running the game
		while(gameWon == false) {
			System.out.println("Current pacman position is column " + pCol + ", row " + pRow);
			System.out.println("Number of points is " + points);
			
			for(int row = 0; row < 5; row++) {
				for(int col = 0; col < 5; col++) {
					if(walls[row][col] == 'w') {
						System.out.print(walls[row][col] + " ");
						coins[row][col] = 0;
					}
					else {
						System.out.print(coins[row][col] + " ");
					}
				}
			System.out.println();
			
			}
			
			//taking in keyboard input
			
			String direction = keyboard.nextLine();
			
			//checking valid moves and updating position
			pacman[pRow][pCol] = 'x'; // let x represent that pacman is not there
			if(direction.equals("left")) {
				if((pCol- 1 >= 0)&&(walls[pRow][pCol -1] != 'w')){
					--pCol;
				}
				pacman[pRow][pCol] =  'p';
			}
				
			else if(direction.equals("right")) {
				if((pCol + 1< COL)&&(walls[pRow][pCol +1] != 'w')) {
					++pCol;
				}
				pacman[pRow][pCol] =  'p';
			}
			
			else if(direction.equals("up")) {
				if((pRow - 1 >= 0)&&(walls[pRow -1][pCol] != 'w')) {
					--pRow;
				}
				pacman[pRow][pCol] =  'p';
			}
			
			else if(direction.equals("down")) {
				if((pRow + 1< ROW)&& (walls[pRow+1][pCol] != 'w')) {
					++pRow;
				}
				pacman[pRow][pCol] =  'p';
			}
			
			//counting points
			if(coins[pRow][pCol] == 1) {
				points++;
				coins[pRow][pCol] = 0;
			}
			
			if(points == 16){
				gameWon = true;
				System.out.println("Yay");
			}
			
		}
	}
}