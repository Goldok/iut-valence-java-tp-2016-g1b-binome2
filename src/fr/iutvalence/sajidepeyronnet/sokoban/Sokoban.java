package fr.iutvalence.sajidepeyronnet.sokoban;
import java.util.Scanner;
/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Sokoban {
    /**
     * TODO.
     *
     * @param args TODO
     */
    public static void main(final String... args) {
        //  TODO Enter the name with the keyboard
    	System.out.println("Enter player name");
    	Scanner sc = new Scanner(System.in);
    	
    	String playerName  = sc.nextLine();

    	Game game = new Game(playerName);
        game.start();
        
    }
}
