package fr.iutvalence.sajidepeyronnet.sokoban;

import static fr.iutvalence.sajidepeyronnet.sokoban.Case.BOX;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.FINISH;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.FLOOR;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.PLAYER;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.WALL;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Checkerboard {
    /** Default Checkerboard width. */
    private static final int DEFAULT_DIMENSION_WIDTH  = 10;
    /** Default Checkerboard Height. */
    private static final int DEFAULT_DIMENSION_HEIGHT = 10;
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

    /** TODO. */
    public char getInfoPosition(Position newPosition) {
        return box[newPosition.y][newPosition.x].getSkin();
    }

    public Position[] getBoxesFinalPositions() {
        return boxesFinalPositions;
    }

    /** TODO. */
    public void switchCase(Position lastPosition, Position newPosition) {
        Case memo = box[newPosition.y][newPosition.x];
        box[lastPosition.y][lastPosition.x] = box[newPosition.y][newPosition.x];
        box[newPosition.y][newPosition.x] = memo;
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
    private void prepareBoard() {

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {

                box[i][j] = new Case(FLOOR);
            }
        }

        boxesInitialPositions = new Position[2];
        boxesFinalPositions = new Position[2];

        playerInitialPosition = new Position(5, 5);

        boxesInitialPositions[0] = new Position(5, 6);
        boxesInitialPositions[1] = new Position(6, 7);

        boxesFinalPositions[0] = new Position(8, 8);
        boxesFinalPositions[1] = new Position(9, 8);

        box[playerInitialPosition.x][playerInitialPosition.y] = new Case(PLAYER);

        box[0][0] = new Case(WALL);
        box[0][1] = new Case(WALL);

        box[boxesInitialPositions[0].x][boxesInitialPositions[0].y] = new Case(BOX);
        box[boxesInitialPositions[1].x][boxesInitialPositions[1].y] = new Case(BOX);

        box[boxesFinalPositions[0].x][boxesFinalPositions[0].y] = new Case(FINISH);
        box[boxesFinalPositions[1].x][boxesFinalPositions[1].y] = new Case(FINISH);
    }
}
