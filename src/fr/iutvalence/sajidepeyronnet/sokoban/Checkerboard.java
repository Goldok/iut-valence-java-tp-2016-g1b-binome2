package fr.iutvalence.sajidepeyronnet.sokoban;

import static fr.iutvalence.sajidepeyronnet.sokoban.Case.BOX;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.BOX_ON_FINISH;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.FINISH;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.FLOOR;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.PLAYER;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.PLAYER_ON_FINISH;
import static fr.iutvalence.sajidepeyronnet.sokoban.Case.WALL;

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
    private       Position   playerInitialPosition;
    /** TODO. */
    private       Position[] boxesInitialPositions;
    /** TODO. */
    private       Position[] targets;

    /** TODO. */
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

        playerInitialPosition = new Position(1, 1);
        board[1][1] = new Case(PLAYER);

        boxesInitialPositions = new Position[]{new Position(2, 2), new Position(5, 5)};
        board[2][2] = new Case(BOX);
        board[5][5] = new Case(BOX);

        targets = new Position[]{new Position(3, 3), new Position(4, 3)};
        board[3][3] = new Case(FINISH);
        board[3][4] = new Case(FINISH);
    }

    /** TODO. */
    Position getPlayerInitialPosition() {
        return playerInitialPosition;
    }

    /** TODO. */
    Position[] getBoxesInitialPositions() {
        return boxesInitialPositions.clone();
    }

    /** TODO. */
    Position[] getTargets() {
        return targets.clone();
    }

    /** TODO. */
    boolean isWalkable(Position position) {
        return board[position.y()][position.x()].isWalkable();
    }

    boolean isMoveable(Position position) {
        return board[position.y()][position.x()].isBox();
    }

    /** TODO. */
    void moveObject(Position lastPosition, Position newPosition) {
        int lY = lastPosition.y();
        int lX = lastPosition.x();
        int nY = newPosition.y();
        int nX = newPosition.x();

        board[nY][nX] = board[lY][lX];

        boolean newIsNormal = true;
        for (final Position target : targets) {
            if (newPosition.equals(target)) {
                newIsNormal = false;
                board[nY][nX] = new Case(board[lY][lX].isBox() ? BOX_ON_FINISH : PLAYER_ON_FINISH);
            }
        }

        board[lY][lX] = new Case(FLOOR);
        for (final Position target : targets) {
            if (lastPosition.equals(target)) {
                // Object leaves a target
                board[lY][lX] = new Case(FINISH);
                if (newIsNormal) {
                    board[nY][nX] = new Case(board[nY][nX].isBox() ? BOX : PLAYER);
                }
                break;
            }
        }
    }

    /** TODO. */
    void print() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
