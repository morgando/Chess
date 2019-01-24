import java.awt.Color;
import java.util.*;
/**
 * HumanPlayer objects determine moves from user input.
 * 
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class HumanPlayer extends Player
{
    private Board board;
    private String name;
    private Color col;
    private BoardDisplay display;

    /**
     * Constructor for objects of class HumanPlayer
     * @param b the Board being played on
     * @param s the name of the player
     * @param c the Color of the player
     * @param d the BoadDisplay being used
     */
    public HumanPlayer(Board b, String s, Color c, BoardDisplay d)
    {
        super(b, s, c);
        board=b;
        name=s;
        col=c;
        display=d;
    }
    /**
     * Relies on user input to find the player's next move
     * @return the player's next Move
     */
    public Move nextMove()
    {  
        Move m = display.selectMove();
        ArrayList<Move> moves = board.allMoves(col);
        while(!moves.contains(m))
        {
            m = display.selectMove();
        }
        return m;
    }
}
