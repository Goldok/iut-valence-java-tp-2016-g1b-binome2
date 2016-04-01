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

    
    
    public Position(int x0, int y0)
    {
    	this.x=x0;
    	this.y=y0;
    	
    }
    
    
    public Position PositionZ() 
    {
    	this.y=y++;
    	return PositionZ();
    			
    }
    
    
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
