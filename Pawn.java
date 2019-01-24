import java.awt.*;
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Piece
{
    // instance variables - replace the example below with your own
    private int value;
    private Color color;
    private String name;
    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(Color col, String fileName)
    {
        super(col, fileName, 1);
        color = col;
        name = fileName;
        value = 1;
    }

    /**
     * @return list
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        if(color.equals(Color.WHITE))
        {
            Location loc = new Location(super.getLocation().getRow()-1, super.getLocation().getCol());
            if(isValidDestination(loc) && super.getBoard().get(loc)==null)
                locs.add(loc);
            else{}
        }
        else
        {
            Location loc = new Location(super.getLocation().getRow()+1, super.getLocation().getCol());
            if(isValidDestination(loc) && super.getBoard().get(loc)==null)
                locs.add(loc);
            else{}
        }
        if(color.equals(Color.WHITE))
        {
            for(int z=45; z<=315; z+=270)
            {
                Location d = super.getLocation().getAdjacentLocation(z);
                if(isValidDestination(d))
                {
                    Piece pie = super.getBoard().get(d);
                    if(pie!=null)
                    {
                        if(pie.getColor()!=color)
                            locs.add(d);
                        else{}
                    }
                    else{}
                }
            }
        }
        else
        {
            for(int z=135; z<=225; z+=90)
            {
                Location d = super.getLocation().getAdjacentLocation(z);
                if(isValidDestination(d))
                {
                    Piece pie = super.getBoard().get(d);
                    if(pie!=null)
                    {
                        if(pie.getColor()!=color)
                            locs.add(d);
                        else{}
                    }
                    else{}
                }
            }
        }
        return locs;
    }
}
