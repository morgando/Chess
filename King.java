import java.awt.*;
import java.util.*;
import java.awt.Color;
/**
 * Kings can move one space in all directions (including diagonally)
 * The game will end when the king is killed.
 * 
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class King extends Piece
{
    private int value;
    private Color color;
    private String name;
    /**
     * Constructor for objects of class King
     * @param col Color of King object
     * @param fileName the name of the image containing file
     */
    public King(Color col, String fileName)
    {
        super(col, fileName, 1000);
    }
    /**
     * @return list of possible destinations
     */
    public ArrayList<Location> destinations()
    {
        int direction = 0;
        ArrayList<Location> locs = new ArrayList<Location>();
        for(int i=0; i<8; i++)
        {
            Location loc = super.getLocation().getAdjacentLocation(direction);
            if(isValidDestination(loc))
            {
                Piece p = super.getBoard().get(loc);
                if(p==null)
                    locs.add(loc);
                else if(p.getColor()!=color)
                    locs.add(loc);
                else
                {}
            }
            direction+=45;
        }
        return locs;
    }
}
