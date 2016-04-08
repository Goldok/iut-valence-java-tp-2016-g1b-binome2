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
    private Position     player;
    /** TODO. */
    private Position[]   boxes;
    /** TODO. */
    private Position[]   targets;
    /** TODO. */
    private int          round;
    /** TODO. */
    private String       playerName;

    /**
     * TODO.
     *
     * @param playerName TODO
     */
    public Game(String playerName) {
        checkerboard = new Checkerboard();
        player = checkerboard.getPlayerInitialPosition();
        boxes = checkerboard.getBoxesInitialPositions();
        targets = checkerboard.getBoxesFinalPositions();
        round = 0;
        this.playerName = playerName;
    }

    /**
     * TODO.
     */
    public void start() {
        checkerboard.print();

        while (!victory()) {
            // TODO Implement interactive
            char move = 'z';

            Position lastPosition = this.player;
            Position newPosition = lastPosition;
            Direction direction = Direction.NULL;
            
            if (move == 'z') {
            	direction = Direction.HAUT;
            }
            
            if (move == 'd') {
            	direction = Direction.DROITE;
            }
            if (move == 'q') {
            	direction = Direction.GAUCHE;
            }
            if (move == 's') {
            	direction = Direction.BAS;
            }
                        
            
            
            
            newPosition = lastPosition.translate(direction);

            if (newPosition == lastPosition) {
            	continue;
            }
            
            if (checkerboard.isWalkable(newPosition)==true) {
            		checkerboard.switchCase(lastPosition, newPosition);
            		continue;
            	}
            
                if (checkerboard.isBox(newPosition)==true)
                {
                	Position boxLastPosition = newPosition;
                    Position boxNewPosition = boxLastPosition.translate(direction);
                    
                    if (checkerboard.isWalkable(boxNewPosition)==true)
                    {
                    	checkerboard.switchCase(lastPosition, newPosition);
                    	checkerboard.switchCase(boxLastPosition, boxNewPosition);
                    }
                    
                    
                    
                }
                
                
            }

            
            
            
            
            
            // teste sur mouvement si Wall  si caisse si vide //

            // TODO Should be methods of Checkerboard

            if (checkerboard.getInfoPosition(newPosition) == Case.FLOOR) {
                checkerboard.switchCase(lastPosition, newPosition);
            }

            if (checkerboard.getInfoPosition(newPosition) == Case.WALL) {
                return;
            }

            if (checkerboard.getInfoPosition(newPosition) == Case.BOX) {
                Position boxLastPosition = newPosition;
                Position boxNewPosition = boxLastPosition.PositionZ();

                if (checkerboard.getInfoPosition(boxNewPosition) == Case.FLOOR) {
                    checkerboard.switchCase(boxLastPosition, boxNewPosition);
                    checkerboard.switchCase(lastPosition, newPosition);
                }

                if (checkerboard.getInfoPosition(newPosition) == (Case.WALL)) {
                    return;
                }
                if (checkerboard.getInfoPosition(newPosition) == (Case.BOX)) {
                    return;
                }
            }
        }
    }

    private boolean victory() {
        for (int i = 0; i < targets.length; i++) {
            int j = 0;
            while (j != 2 && !targets[i].equals(boxes[j])) {
                j++;
            }
            if (!targets[i].equals(boxes[j])) {
                return false;
            }
        }
        return true;
    }
}

			
		
			
		
		
		
		
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

		
	

