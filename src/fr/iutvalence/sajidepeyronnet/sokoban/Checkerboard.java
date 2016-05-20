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
    private static final int DEFAULT_DIMENSION_WIDTH  = 10;
    /** Default Checker
     * board Height. */
    private static final int DEFAULT_DIMENSION_HEIGHT = 20;
    /** Checkers. */
    private final Case[][]   box;
    /** Checkerboard's Width */
    private final int        width;
    /** Checkerboard's Height */
    private final int        height;
    /** TODO. */
    private       Position   playerInitialPosition;
    /** TODO. */
    private       Position[] boxesInitialPositions;
    /** TODO. */
    private       Position[] boxesFinalPositions;

    /** TODO. */
    public Checkerboard() {
        width = DEFAULT_DIMENSION_WIDTH;
        height = DEFAULT_DIMENSION_HEIGHT;
        box = new Case[width][height];

        prepareBoard();
    }

    /**
     * TODO.
     *
     * @param width  TODO
     * @param height TODO
     */
    public Checkerboard(int width, int height) {
        this.width = width;
        this.height = height;
        box = new Case[width/*y*/][height/*x*/];

        prepareBoard();
    }

    /** TODO. */
    public Position getPlayerInitialPosition() {
        return playerInitialPosition;
    }

    /** TODO. */
    public Position[] getBoxesInitialPositions() {
        return boxesInitialPositions;
    }

    public Position[] getBoxesFinalPositions() {
        return boxesFinalPositions;
    }

    public boolean isWalkable(Position newPosition0)
    {
    		return box[newPosition0.y][newPosition0.x].isWalkable();
    }    	
    
    public boolean isFinish(Position newPosition0)
    {
    		return box[newPosition0.y][newPosition0.x].isFinish();
    }    	
    
    public boolean isOnFinish(Position newPosition0)
    {
    		return box[newPosition0.y][newPosition0.x].isOnFinish();
    }    	
    
    public boolean boxIsOnFinish(Position newPosition0)
    {
    		return box[newPosition0.y][newPosition0.x].boxIsOnFinish();
    }    	
    
    public boolean isBox(Position newPosition0)
   	{
    	return box[newPosition0.y][newPosition0.x].isBox();
   	}
    
    
    
    /** TODO. */
    public void switchCase(Position lastPosition, Position newPosition) {
    		 Case memo = box[lastPosition.y][lastPosition.x];
    	     box[lastPosition.y][lastPosition.x] = box[newPosition.y][newPosition.x];
    	     box[newPosition.y][newPosition.x] = memo;
    }
    	     
    public void switchCaseOnFinish(Position lastPosition, Position newPosition, Position firstPosition) {
        	 	 box[newPosition.y][newPosition.x] = new Case(BOX_ON_FINISH);  	     
        	 	box[lastPosition.y][lastPosition.x] = new Case(PLAYER);
        	 	box[firstPosition.y][firstPosition.x] =new Case(FLOOR);
        	 	
    	}
    
    public void switchBoxOnFinish(Position lastPosition, Position newPosition, Position boxNewPosition) {
	 	 box[boxNewPosition.y][boxNewPosition.x] = new Case(BOX);	     
	 	box[lastPosition.y][lastPosition.x] = new Case(FLOOR);
	 	box[newPosition.y][newPosition.x] =new Case(ON_FINISH);
    }
    
    public void replaceCase(Position lastPosition, Position newPosition)
    {
    
		box[newPosition.y][newPosition.x] = new Case(ON_FINISH);
    	box[lastPosition.y][lastPosition.x] = new Case(FLOOR);

    }
    
    public void createFinish(Position lastPosition, Position newPosition)
    {
    	box[lastPosition.y][lastPosition.x] = new Case(FINISH);
    	box[newPosition.y][newPosition.x] = new Case(PLAYER);
 
    }
    		
    

    /** TODO. */
    public void print() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                System.out.print(box[i][j]);
            }
            System.out.println();
        }
    }

    /** TODO. */
    
    // Fonction aléatoire prépareboard
    private void prepareBoard() {

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {
            
                box[i][j] = new Case(FLOOR);
                
                if (i==0)
                {box[i][j] = new Case(WALL);}
                if (i==width-1)
                {box[i][j] = new Case(WALL);}
                if (j==0)
                {box[i][j] = new Case(WALL);}
                if (j==height-1)
                {box[i][j] = new Case(WALL);}
            }
        }

        boxesInitialPositions = new Position[2];
        boxesFinalPositions = new Position[2];

        playerInitialPosition = new Position(1,1);

        boxesInitialPositions[0] = new Position(2, 2);
        boxesInitialPositions[1] = new Position(5, 5);

        boxesFinalPositions[0] = new Position(3, 3);
        boxesFinalPositions[1] = new Position(5, 12);

        box[playerInitialPosition.x][playerInitialPosition.y] = new Case(PLAYER);
        


        box[boxesInitialPositions[0].x][boxesInitialPositions[0].y] = new Case(BOX);
        box[boxesInitialPositions[1].x][boxesInitialPositions[1].y] = new Case(BOX);

        box[boxesFinalPositions[0].x][boxesFinalPositions[0].y] = new Case(FINISH);
        box[boxesFinalPositions[1].x][boxesFinalPositions[1].y] = new Case(FINISH);
    }
}
