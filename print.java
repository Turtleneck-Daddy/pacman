import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class print {
    public void printStuff(String score) throws FileNotFoundException {
        File scoreFile = new File("Score");
        PrintWriter printStuff = new PrintWriter(scoreFile);
        printStuff.println(score);
        printStuff.close();
    }

    
}