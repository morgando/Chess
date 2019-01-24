import java.awt.*;
import java.util.*;
import java.awt.Color;
public abstract class Piece
{
    //the board this piece is on
    private Board board;

    //the location of this piece on the board
    private Location location;

    //the color of the piece
    private Color color;

    //the file used to display this piece
    private String imageFileName;

    //the approximate value of this piece in a game of chess
    private int value;

    //constructs a new Piece with the given attributes.
    public Piece(Color col, String fileName, int val)
    {
        color = col;
        imageFileName = fileName;
        value = val;
    }
    /**
     * @return Board piece is in
     */
    public Board getBoard()
    {
        return board;
    }
    /**
     * @return Location piece is at
     */
    public Location getLocation()
    {
        return location;
    }
    /**
     * @return Color of piece
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * @return name of file of image for piece
     */
    public String getImageFileName()
    {
        return imageFileName;
    }
    /**
     * @return value of piece
     */
    public int getValue()
    {
        return value;
    }
    /**
     * 
     */
    public boolean isValidDestination(Location dest)
    {
        if((0<=dest.getRow() && dest.getRow()<8) && (0<=dest.getCol() && dest.getCol()<8))
        {
            if(board.get(dest)!=null)
            {
                if(board.get(dest).getColor()!=color)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public abstract ArrayList<Location> destinations();

    /**
     * Puts this piece into a board. If there is another piece at the given
     * location, it is removed. <br />
     * Precondition: (1) This piece is not contained in a grid (2)
     * <code>loc</code> is valid in <code>gr</code>
     * @param brd the board into which this piece should be placed
     * @param loc the location into which the piece should be placed
     */
    public void putSelfInGrid(Board brd, Location loc)
    {
        if (board != null)
            throw new IllegalStateException(
                "This piece is already contained in a board.");

        Piece piece = brd.get(loc);
        if (piece != null)
            piece.removeSelfFromGrid();
        brd.put(loc, this);
        board = brd;
        location = loc;
    }
    /**
     * Removes this piece from its board. <br />
     * Precondition: This piece is contained in a board
     */
    public void removeSelfFromGrid()
    {
        if (board == null)
            throw new IllegalStateException(
                "This piece is not contained in a board.");
        if (board.get(location) != this)
            throw new IllegalStateException(
                "The board contains a different piece at location "
                + location + ".");

        board.remove(location);
        board = null;
        location = null;
    }
    /**
     * Moves this piece to a new location. If there is another piece at the
     * given location, it is removed. <br />
     * Precondition: (1) This piece is contained in a grid (2)
     * <code>newLocation</code> is valid in the grid of this piece
     * @param newLocation the new location
     */
    public void moveTo(Location newLocation)
    {
        if (board == null)
            throw new IllegalStateException("This piece is not on a board.");
        if (board.get(location) != this)
            throw new IllegalStateException(
                "The board contains a different piece at location "
                + location + ".");
        if (!board.isValid(newLocation))
            throw new IllegalArgumentException("Location " + newLocation
                + " is not valid.");
        if (newLocation.equals(location))
            return;
        board.remove(location);
        Piece other = board.get(newLocation);
        if (other != null)
            other.removeSelfFromGrid();
        location = newLocation;
        board.put(location, this);
    }
    /**
     * Adds to dests all empty locations in spaces away from piece in direction.
     * Will add to the array an encountered piece if it is of opposite color.
     * @param dests ArrayList into which locations are being added
     * @param direction degrees (in bearing) of the direction
     */
    public void sweep(ArrayList<Location> dests, int direction)
    {
        boolean encounter = false;
        Location l = this.getLocation();
        l = l.getAdjacentLocation(direction);
        while(!encounter && this.isValidDestination(l))
        {
            if(this.isValidDestination(l))
            {
                if(board.get(l) !=null)
                {
                    encounter = true;
                    if(board.get(l).getColor()!=color)
                    {
                        dests.add(l);
                    }
                    else
                    {
             
                    }
                }
                else
                {
                    dests.add(l);
                }
            }
            l = l.getAdjacentLocation(direction);
        }
    }
}
