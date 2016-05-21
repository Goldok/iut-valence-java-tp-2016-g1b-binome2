package fr.iutvalence.sajidepeyronnet.sokoban;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
class Case {
    /** TODO. */
    static final char WALL   = '#';
    /** TODO. */
    static final char FLOOR  = ' ';
    /** TODO. */
    static final char FINISH = '*';

    /** TODO. */
    static final char PLAYER           = '1';
    /** TODO. */
    static final char PLAYER_ON_FINISH = '2';

    /** TODO. */
    static final char BOX           = 'B';
    /** TODO. */
    static final char BOX_ON_FINISH = '$';

    /** TODO. */
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

    /** TODO. */
    boolean isWalkable() {
        return (skin == FLOOR) || (skin == FINISH);
    }

    /** TODO. */
    boolean isBox() {
        return (skin == BOX) || (skin == BOX_ON_FINISH);
    }
}
