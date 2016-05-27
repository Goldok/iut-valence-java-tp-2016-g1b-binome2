package fr.iutvalence.sajidepeyronnet.sokoban;

import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.BAS;
import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.DROITE;
import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.GAUCHE;
import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.HAUT;
import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.NULL;

import java.util.List;
import java.util.Scanner;

/**
 * @author Sajide Adil
 * @author Peyronnet Cedric
 */
class Game {
    /** Checkerboard. */
    private final Checkerboard checkerboard;
    /** List of boxes. */
    private final List<Position>   boxes;
    /** List of targets. */
    private final List<Position>   targets;
    /** Player position. */
    private       Position     player;
    /** Score */
    public int score=0;

    /**
     * Gamer's constructor
     *
     * @param playerName the name of the player
     */
    public Game(String playerName) {
        checkerboard = new Checkerboard();
        player = checkerboard.getPlayerInitialPosition();
        boxes = checkerboard.getBoxesInitialPositions();
        targets = checkerboard.getTargets();
    }

    /**
     *Function start a game 
     */
    public void start()  {
        Scanner sc = new Scanner(System.in);

        while (!victory()) {
            checkerboard.print();

            /** Get the direction from the user.*/
            final char move = sc.nextLine().charAt(0);
            Direction direction = null;
           
			try {
				direction = charToDirection(move);
				score=score+1;

			} catch (mouvementFailedException e) {
				System.err.println("Valid input z,q,s,d");
				
				continue;
			}

            /** Calculate the two positions (last and new one).*/
            final Position previousPlayerPosition = player;
            final Position newPlayerPosition = previousPlayerPosition.translate(direction);

            /** No movement*/
            if (newPlayerPosition.equals(previousPlayerPosition)) {
                continue;
            }

            /** Simple movement */
            if (checkerboard.isWalkable(newPlayerPosition)) {
                checkerboard.moveObject(previousPlayerPosition, newPlayerPosition);
                player = newPlayerPosition;
                continue;
            }

            /** Move a box */
            if (checkerboard.isMoveable(newPlayerPosition)) {
                final Position previousBoxPosition = newPlayerPosition;
                final Position newBoxPosition = previousBoxPosition.translate(direction);

                if (checkerboard.isWalkable(newBoxPosition)) {
                    checkerboard.moveObject(previousBoxPosition, newBoxPosition);
                    checkerboard.moveObject(previousPlayerPosition, newPlayerPosition);
                    
                    
                    player = newPlayerPosition;
                    
                   boxes.remove(previousBoxPosition);
                   boxes.add(newBoxPosition);
                }
            }
        }
        /**
         *  If we ended the game by a victory
         */
        if (victory()) {
        	System.out.println("Victory !");
        	System.out.println("score:");
        	System.out.println(score);
        }
    }

    /** Get a direction, depend of the move
     * @return return a direction */
    private Direction charToDirection(char move) throws mouvementFailedException {
        Direction direction = NULL;

        if (move == 'z') {
            direction = HAUT;
        }

        else if (move == 'd') {
            direction = DROITE;
        }

        else if (move == 'q') {
            direction = GAUCHE;
        }

        else if (move == 's') {
            direction = BAS;
        }
        else {
        	throw new mouvementFailedException();
        }

        return direction;
    }

    /** 
     * Condition of victory, boxes's positions have to be the same has targets's positions
     * @return if the game is end with a true
     */
    private boolean victory() {
        for (final Position target : targets) {
            if (!boxes.contains(target)) {
            	return false;
            }
        }
        return true;
    }
}



		
			
	
	

