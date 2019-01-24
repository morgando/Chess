import java.awt.Color;
import java.util.*;
/**
 * Boboquins can move to any space in the row two rows ahead of theirs.
 * Boboquins can only take pieces two rows ahead of them in their current column.
 * 
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class Boboquin extends Piece
{
    private int value;
    private Color color;
    private String name;
    /**
     * Constructor for objects of class Boboquin
     * @param col the Color of the Boboquin
     * @param fileName the name of Boboquin's image file
     */
    public Boboquin(Color col, String fileName)
    {
        super(col, fileName, 40);
        color = col;
        name = fileName;
    }
    /**
     * @return list with possible destinations
     */
    public ArrayList<Location> destinations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int row = super.getLocation().getRow();
        int col = super.getLocation().getCol();
        if(color.equals(Color.WHITE))
            row-=2;
        else
            row+=2;
        if(row >= 8 || row <0)
            return locs;
        for(int i=0; i<8; i++)
        {
            Location l = new Location(row, i);
            Piece p = super.getBoard().get(l);
            if(p==null)
                locs.add(l);
            else
            {
                if(!p.getColor().equals(color) && p.getLocation().getCol()==col)
                    locs.add(l);
                else {}
            }
        }
        return locs;
    }
}
