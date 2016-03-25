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
    private Position[] boxes;
    
    private Position[] targets;
    /** TODO. */
    private int round;
    /** TODO. */
    private String playerName;

    public Game(String playerName) {
    	checkerboard = new Checkerboard();
    	player = checkerboard.getPlayerInitialPosition();
    	boxes  = checkerboard.getBoxesInitialPositions();
    	targets = checkerboard.getBoxesFinalPositions();
    	round = 0;
    	this.playerName = playerName; 
    }
    
	public void start() {
		checkerboard.print();
		/*	while (!victory()) {
				Demander la translation
				
				Calculer la nouvelle position du joueur
				
				Vérifier la possibilité de jouer rééllement le coup
					=> Demander à Checkboard ce qu'il y a la nouvelle coordonnée
					=> Décision en fonction
				
				Jouer le coup
				    => Travail restant !
			
		}
	*/	
		}
		
	
}
