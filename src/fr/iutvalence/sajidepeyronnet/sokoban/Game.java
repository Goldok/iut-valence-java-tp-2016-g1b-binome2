package fr.iutvalence.sajidepeyronnet.sokoban;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Game {
    /** TODO. */
    private Checkerboard checkerboard;
    /** TODO. */
    private Position player;
    /** TODO. */
    private Position[] box;
    /** TODO. */
    private int round;
    /** TODO. */
    private String playerName;

    public Game(String playerName) {
    	checkerboard = new Checkerboard();
    	
    	player = checkerboard.getPlayerInitialPosition();
    	box  = checkerboard.getBoxesInitialPositions();
    	round = 0;
    	this.playerName = playerName; 
    }
    
	public void start() {
		// TODO Auto-generated method stub
		
	}
}
