package fr.iutvalence.sajidepeyronnet.sokoban;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
class Case {
    /** Skin of walls */
    static final char WALL   = '#';
    /** Skin of the floor */
    static final char FLOOR  = ' ';
    /** Skin of finish targets */
    static final char FINISH = '*';

    /** Skin of the player */
    static final char PLAYER           = '1';
    /** Skin of the player on a finish target. */
    static final char PLAYER_ON_FINISH = '1';

    /** Skin of boxes. */
    static final char BOX           = 'B';
    /** Skin of boxes on a finish target. */
    static final char BOX_ON_FINISH = 'B';

    /** Skin of cases. */
    private final char skin;

    /**
     * TODO.
     *
     * @param skin TODO
     */
    Case(char skin) {
        this.skin = skin;
    }

    @Override
    public String toString() {
        return String.valueOf(skin);
    }

    /** To know if the case is walkable (means floor or finish) */
    boolean isWalkable() {
        return (skin == FLOOR) || (skin == FINISH);
    }

    /** To know if the case is a box (means box or box on target) */
    boolean isBox() {
        return (skin == BOX) || (skin == BOX_ON_FINISH);
    }
}
