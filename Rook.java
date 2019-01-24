import java.awt.Color;
import java.awt.*;
import java.util.*;
/**
 * Rook can move until it meets another piece in all directions except
 * for diagonal directions.
 * 
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class Rook extends Piece
{
    private int value;
    private Color color;
    private String name;
    /**
     * Constructor for objects of class Rook
     * @param col the color of the Rook
     * @param fileName the name of the file containing image of Rook
     */
    public Rook(Color col, String fileName)
    {
        super(col, fileName, 5);
    }
    /**
     * @return ArrayList of Locations a Rook can travel in a move
     */
    public ArrayList<Location> destinations()
    {
        int direction = 0;
        ArrayList<Location> locs = new ArrayList<Location>();
        while(direction<=270)
        {
            super.sweep(locs, direction);
            direction+=90;
        }
        return locs;
    }
}
