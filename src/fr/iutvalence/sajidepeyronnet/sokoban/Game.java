package fr.iutvalence.sajidepeyronnet.sokoban;

import static fr.iutvalence.sajidepeyronnet.sokoban.Case.FLOOR;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.PLAYER;

import java.util.Scanner;

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
    
    private int a=0;
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
        Scanner sc = new Scanner(System.in);
        
        while (!victory()) {
        	
            checkerboard.print();

            // TODO Implement interactive
        	
        	// DEMANDER MOUVEMENT JOUEUR
        	

            char move = sc.nextLine().charAt(0);
            	
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
            
            
            if (checkerboard.isOnFinish(lastPosition))
            {  // TODO Remplacer le switch par juste une affectation
            	checkerboard.switchCase(lastPosition, newPosition);
            	checkerboard.createFinish(lastPosition, newPosition);
            	player = newPosition;
            	a=0;
            }   
            if (checkerboard.isWalkable(newPosition)) {
            	checkerboard.switchCase(lastPosition, newPosition);
            	player = newPosition;
            	continue;
            }

            if (checkerboard.isFinish(newPosition))
            {
            	checkerboard.replaceCase(lastPosition, newPosition);	
            	player = newPosition;
            	a=1;
            	continue;


            }



            /* cas des box*/


            if (checkerboard.isBox(newPosition))
            {
            	Position boxLastPosition = newPosition;
            	Position boxNewPosition = boxLastPosition.translate(direction);




            	if (checkerboard.isWalkable(boxNewPosition)==true)
            	{
            		checkerboard.switchCase(boxLastPosition, boxNewPosition);
            		checkerboard.switchCase(lastPosition, newPosition);
            		player = newPosition;
            	}

            	/* Si caisse => finish */ 

            			if (checkerboard.isFinish(boxNewPosition)==true)
            			{


            				checkerboard.switchCaseOnFinish(boxLastPosition, boxNewPosition, lastPosition);


            				player = newPosition;



            			}
            }
            if (checkerboard.boxIsOnFinish(newPosition)==true){

            	Position boxNewPosition = newPosition.translate(direction);

            	checkerboard.switchBoxOnFinish(lastPosition, newPosition, boxNewPosition);

            	player = newPosition;
            	a=1;                	   
            }



        }



    }
    			// verifier que victory fonctionne ?
    private boolean victory() {
        for (int i = 0; i < targets.length; i++) {
            int j = 0;
            while (j != boxes.length && !targets[i].equals(boxes[j])) {
                j++;
            }
            
            if (!targets[i].equals(boxes[j-1])) {
                return false;
            }
        }
        return true;
    }
}



		
			
	
	

