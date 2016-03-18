package fr.iutvalence.sajidepeyronnet.sokoban;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Checkerboard {
	/** Default Checkerboard width. */
	private static final int DEFAULT_DIMENSION_WIDTH = 10;
	/** Default Checkerboard Height.  */
	private static final int DEFAULT_DIMENSION_HEIGHT = 10;

	/**  Checkerboard's Width */
	private final int width;
	/** Checkerboard's Height */
	private final int height;
	/** Checkers. */
	private final Case[][] box;

	private Position playerInitialPosition;
	private Position[] boxesInitialPositions;
	
	public Checkerboard() {
		this.width = DEFAULT_DIMENSION_WIDTH;
		this.height = DEFAULT_DIMENSION_HEIGHT;
		box = new Case[width][height];
		
		prepareBoard();
	}

	public Checkerboard(int width, int height) {
		this.width =  width;
		this.height = height;
		box = new Case[width][height];

		prepareBoard();
	}


	private void prepareBoard() {
		// TODO Auto-generated method stub
		
	}

	public Position getPlayerInitialPosition() {
		return playerInitialPosition;
	}

	public Position[] getBoxesInitialPositions() {
		// TODO Auto-generated method stub
		return boxesInitialPositions;
	}




}
