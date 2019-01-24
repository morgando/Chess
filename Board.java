import java.awt.*;
import java.util.*;

/**
 * Represesents a rectangular game board, containing Piece objects.
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class Board extends BoundedGrid<Piece>
{
    /**
     * constructs a board of dimension 8x8
     */
    public Board()
    {
        super(8, 8);
    }
    /**
     * @Precondition:  move has already been made on the board
     * @Postcondition: piece has moved back to its source,
     * and any captured piece is returned to its location
     * @param move the Move being undone
     */
    public void undoMove(Move move)
    {
        Piece piece = move.getPiece();
        Location source = move.getSource();
        Location dest = move.getDestination();
        Piece victim = move.getVictim();

        piece.moveTo(source);

        if  (victim != null)
            victim.putSelfInGrid(piece.getBoard(), dest);
    }
    /**
     * @param color the color of the player's team.
     * @return list with all valid moves a player can make.
     */
    public ArrayList<Move> allMoves(Color color)
    {   
        ArrayList<Move> moves = new ArrayList<Move>();
        ArrayList<Location> locs = super.getOccupiedLocations();
        for(Location l : locs)
        {
            Piece p = super.get(l);
            if(p.getColor().equals(color))
            {
                ArrayList<Location> poss = p.destinations();
                for(Location lok : poss)
                {
                    if(super.isValid(lok))
                    {
                        moves.add(new Move(p, lok));
                    }
                }
            }
        }
        return moves;
    }
    /**
     * @param move the Move which is to be executed
     * @postcondition piece has moved from source to destination of move
     */
    public void executeMove(Move move)
    {
        move.getPiece().moveTo(move.getDestination());
    }
}