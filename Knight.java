import java.awt.*;
import java.util.*;
import java.awt.Color;
/**
 * Kings can move two spaces in a direction and one to the side.
 * 
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class Knight extends Piece
{
    // instance variables - replace the example below with your own
    private int value;
    private Color color;
    private String name;
    /**
     * Constructor for objects of class Knight
     * @param col the Color of the Knight
     * @param fileName the name of the image containing file
     */
    public Knight(Color col, String fileName)
    {
        super(col, fileName, 3);
    }
    /**
     * Tests wheter a location is out of bounds
     * @param dest the destination to be tested.
     * @return true if dest is out of grid's bounds--false otherwise (whether space
     * is occupied doesn't matter)
     */
    public boolean isValidDestination2(Location dest)
    {
        return ((0<=dest.getRow() && dest.getRow()<8) && (0<=dest.getCol() && dest.getCol()<8))   ;
    }
    /**
     * @return list of possible destinations
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for(int i=45;i<=315;i+=90)
        {
            for(int z=0; z<360; z+=90)
            {
                Location l = super.getLocation().getAdjacentLocation(z);
                if(this.isValidDestination2(l))
                {
                    l=l.getAdjacentLocation(i);
                    if(super.isValidDestination(l))
                    {
                        Piece p = super.getBoard().get(l);
                        if(p==null)
                            locs.add(l);
                        else if(p.getColor()!=color)
                            locs.add(l);
                        else
                        {}
                    }
                }
                else
                {}
            }   
        }
        return locs;
    }
}
