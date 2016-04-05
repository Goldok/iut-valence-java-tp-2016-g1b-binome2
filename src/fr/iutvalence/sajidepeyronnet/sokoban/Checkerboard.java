package fr.iutvalence.sajidepeyronnet.sokoban;

import static fr.iutvalence.sajidepeyronnet.sokoban.Case.*;

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

	int i, j ;
	/**  Checkerboard's Width */
	private final int width;
	/** Checkerboard's Height */
	private final int height;
	/** Checkers. */
	protected final Case[][] box;

	private Position playerInitialPosition;
	private Position[] boxesInitialPositions;
	private Position[] boxesFinalPositions;
	
	public Checkerboard() {
		this.width = DEFAULT_DIMENSION_WIDTH;
		this.height = DEFAULT_DIMENSION_HEIGHT;
		box = new Case[width][height];

		
		prepareBoard();
	}

	public Checkerboard(int width, int height) {
		this.width =  width;
		this.height = height;
		box = new Case[width/*y*/][height/*x*/];

		
		prepareBoard();
	}


	private void prepareBoard() {
		

		
		for(i=0; i<this.width; i++){
			
			for (j=0; j<this.height; j++){
				
				box[i][j] = new Case(FLOOR);
			}
			
		}
		
		
		
		boxesInitialPositions = new Position[2];
		boxesFinalPositions = new Position[2];
		
		playerInitialPosition = new Position(5,5);
		
		boxesInitialPositions[0] = new  Position(5,6);
		boxesInitialPositions[1] = new  Position(6,7);
		
		boxesFinalPositions[0] = new Position(8,8);
		boxesFinalPositions[1] = new Position(9,8);
		
		

		
		
		
		box[playerInitialPosition.x][playerInitialPosition.y] = new Case(PLAYER);
		
		box[0][0] = new Case(WALL);
		box[0][1] = new Case(WALL);
		
		box[boxesInitialPositions[0].x][boxesInitialPositions[0].y] = new Case(BOX);
		box[boxesInitialPositions[1].x][boxesInitialPositions[1].y] = new Case(BOX);
		
		box[boxesFinalPositions[0].x][boxesFinalPositions[0].y] = new Case(FINISH);
		box[boxesFinalPositions[1].x][boxesFinalPositions[1].y] = new Case(FINISH);
	}

	public Position getPlayerInitialPosition() {
		return playerInitialPosition;
	}

	public Position[] getBoxesInitialPositions() {
		return boxesInitialPositions;
	}
	
	
	/* Info pour prévoir mouvement*/
	
	public char getInfoPosition(Position newPosition)
	{
		return box[newPosition.y][newPosition.x].getSkin();
	}
	
	/* Methode Switch Case pour inverser 2 Case du Checkerboard */ 
	/* Case ou skin ??? */
	
	public void switchCase(Position lastPosition , Position newPosition)
	{
		Case memo = box[newPosition.y][newPosition.x];
		box[lastPosition.y][lastPosition.x]=box[newPosition.y][newPosition.x];
		box[newPosition.y][newPosition.x]=memo;
		
	}
	
	
	public Position[] getBoxesFinalPositions() {
		return boxesFinalPositions;
	}

	public void print() {
		for(i=0; i<this.width; i++){
			for (j=0; j<this.height; j++){
				
				System.out.print(box[i][j]);
			}
			System.out.println();

		}		
	}



}
