package fr.iutvalence.sajidepeyronnet.sokoban;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Position {
    /** TODO. */
    protected int x;
    /** TODO. */
    protected int y;

    
    
    public Position(int y0, int x0)
    {
    	this.x=x0;
    	this.y=y0;
    	
    }
    
    
 /*   public Position getNewPositionZ();
    {
    	this.x=x++;
    }
  */  
    // TODO getter without return type?
    /** TODO. */
    public int getX() {
        return x;
    }

    // TODO getter without return type?
    /** TODO. */
    public int getY() {
        return y;
    }
    
}
