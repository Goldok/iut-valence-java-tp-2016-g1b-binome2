package fr.iutvalence.sajidepeyronnet.sokoban;

import java.util.Scanner;

import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.BAS;
import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.DROITE;
import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.GAUCHE;
import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.HAUT;
import static fr.iutvalence.sajidepeyronnet.sokoban.Direction.NULL;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
class Game {
    /** TODO. */
    private final Checkerboard checkerboard;
    /** TODO. */
    private final Position[]   boxes;
    /** TODO. */
    private final Position[]   targets;
    /** TODO. */
    private       Position     player;

    /**
     * TODO.
     *
     * @param playerName TODO
     */
    public Game(String playerName) {
        checkerboard = new Checkerboard();
        player = checkerboard.getPlayerInitialPosition();
        boxes = checkerboard.getBoxesInitialPositions();
        targets = checkerboard.getTargets();
    }

    /**
     * TODO.
     */
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (!victory()) {
            checkerboard.print();

            // Get the direction from the user.
            final char move = sc.nextLine().charAt(0);
            final Direction direction = charToDirection(move);

            // Calculate the two positions (last and new one).
            final Position previousPlayerPosition = player;
            final Position newPlayerPosition = previousPlayerPosition.translate(direction);

            // No movement
            if (newPlayerPosition.equals(previousPlayerPosition)) {
                continue;
            }

            // Simple movement
            if (checkerboard.isWalkable(newPlayerPosition)) {
                checkerboard.moveObject(previousPlayerPosition, newPlayerPosition);
                player = newPlayerPosition;
                continue;
            }

            // Move a box
            if (checkerboard.isMoveable(newPlayerPosition)) {
                final Position previousBoxPosition = newPlayerPosition;
                final Position newBoxPosition = previousBoxPosition.translate(direction);

                if (checkerboard.isWalkable(newBoxPosition)) {
                    checkerboard.moveObject(previousBoxPosition, newBoxPosition);
                    checkerboard.moveObject(previousPlayerPosition, newPlayerPosition);
                    player = newPlayerPosition;
                    for (int i = 0; i < boxes.length; i++) {
                        if (boxes[i].equals(previousBoxPosition)) {
                            boxes[i] = newBoxPosition;
                        }
                    }
                }
            }
        }
        //* If we ended the game by a victory/* 
        if (victory()) {
        	System.out.println("Victory !");
        }
    }

    /** Get a direction, depend of the move */
    private Direction charToDirection(char move) {
        Direction direction = NULL;

        if (move == 'z') {
            direction = HAUT;
        }

        if (move == 'd') {
            direction = DROITE;
        }

        if (move == 'q') {
            direction = GAUCHE;
        }

        if (move == 's') {
            direction = BAS;
        }

        return direction;
    }

    /** Condition of victory, boxes's positions have to be the same has targets's positions */
    private boolean victory() {
        for (final Position target : targets) {
            boolean empty = true;
            for (final Position box : boxes) {
                if (box.equals(target)) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                return false;
            }
        }
        return true;
    }
}



		
			
	
	

