package fr.iutvalence.sajidepeyronnet.sokoban;

import static fr.iutvalence.sajidepeyronnet.sokoban.Case.BOX;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.BOX_ON_FINISH;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.FINISH;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.FLOOR;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.PLAYER;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.PLAYER_ON_FINISH;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.WALL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
class Checkerboard {
	/** Default Checkerboard WIDTH. */
	private static final int WIDTH  = 10;
	/** Default Checkerboard Height. */
	private static final int HEIGHT = 20;
	/** Checkers. */
	private final Case[][]   board;
	/** TODO. */
	private  final List<Position> targets;

	/** Creation of checkerboard with targets, box and a player 
	 * 
	 * 
	 * */
	Checkerboard() {

		board = new Case[WIDTH][HEIGHT];
		for (int i = 1; i < (WIDTH - 1); i++) {
			for (int j = 1; j < (HEIGHT - 1); j++) {
				board[i][j] = new Case(FLOOR);
			}
		}

		for (int i = 0; i < WIDTH; i++) {
			board[i][0] = new Case(WALL);
			board[i][HEIGHT - 1] = new Case(WALL);
		}

		for (int i = 0; i < HEIGHT; i++) {
			board[0][i] = new Case(WALL);
			board[WIDTH - 1][i] = new Case(WALL);
		}

		Position playerInitialPosition = getPlayerInitialPosition(); 
		board[playerInitialPosition.y()][playerInitialPosition.x()] = new Case(PLAYER);

		List<Position> boxesInitialPositions = getBoxesInitialPositions();
		for (Position box : boxesInitialPositions) {
			board[box.y()][box.x()] = new Case(BOX);
		}

		targets = getTargets();
		for (Position target : targets) {
			board[target.y()][target.x()] = new Case(FINISH);
		}
	}

	/** Function to get the player's position.
	 * @return the playerInitialPosition */
	Position getPlayerInitialPosition() {
		return new Position(1, 1);
	}

	/** Function to get boxes's initial Positions.
	 * @return boxesInitialPosition
	 *  */

	List<Position> getBoxesInitialPositions() {
		List<Position> boxes = new ArrayList<Position>();
		boxes.add(new Position(2, 2));
		boxes.add(new Position(5, 5));
		return boxes;
	}

	/** TODO. */
	List<Position> getTargets() {
		List<Position> targets = new ArrayList<Position>();
		targets.add(new Position(3,3));
		targets.add(new Position(4,3));
		return targets;
	}

	/** Function to know if a position is walkable.
	 * @return if it's walkable  */
	boolean isWalkable(Position position) {
		return board[position.y()][position.x()].isWalkable();
	}

	/** Function to know if a position can be move. 
	 * @return if it's move-able
	 *  */
	boolean isMoveable(Position position) {
		return board[position.y()][position.x()].isBox();
	}

	/** Function to move an object to a new position. 
	 * @param last position the previous Position
	 * @param new position the new Position
	 * */
	void moveObject(Position lastPosition, Position newPosition){
		int lY = lastPosition.y();
		int lX = lastPosition.x();
		int nY = newPosition.y();
		int nX = newPosition.x();

		board[nY][nX] = board[lY][lX];


		boolean newIsNormal = true;
		if (targets.contains(newPosition)) {
			newIsNormal = false;
			board[nY][nX] = new Case(board[lY][lX].isBox() ? BOX_ON_FINISH : PLAYER_ON_FINISH);
		}

		board[lY][lX] = new Case(FLOOR);

		if (targets.contains(lastPosition)) {
			// Object leaves a target
			board[lY][lX] = new Case(FINISH);
			if (newIsNormal) {
				board[nY][nX] = new Case(board[nY][nX].isBox() ? BOX : PLAYER);
			}
		}
	}

	/** Function to print the checkerboard */
	void print() {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
