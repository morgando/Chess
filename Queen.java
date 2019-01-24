import java.awt.Color;
import java.util.*;
/**
 * Queens can move in any direction until they encounter a piece.
 * 
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class Queen extends Piece
{
    private Color color;
    private String name;
    private int value;
    /**
     * Constructor for objects of class Queen
     * @param col the Color of the Queen
     * @param name the name of the file of the Queen's image
     */
    public Queen(Color col, String name)
    {
        super(col, name, 9);
    }
    /**
     * @return list of valid destinations for Queen
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for(int i=0; i<360; i+=45)
        {
            super.sweep(locs, i);
        }
        return locs;
    }
}
