package fr.iutvalence.sajidepeyronnet.sokoban;

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
    	String playerName = "Toto";

    	Game game = new Game(playerName);
        game.start();
    }
}
