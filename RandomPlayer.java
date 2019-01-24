import java.awt.Color;
import java.util.*;
/**
 * RandomPlayers are chess players who make random moves.
 * 
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class RandomPlayer extends Player
{
    private Board board;
    private String name;
    private Color col;
    /**
     * Constructor for objects of class RandomPlayer
     * @param b board being used
     * @param s name of player
     * @param c color of player's team
     */
    public RandomPlayer(Board b, String s, Color c)
    {
        super(b,s,c);
        board = b;
        name = s;
        col = c;
    }
    /**
     * @return random, valid Move for player
     */
    public Move nextMove()
    {
        ArrayList<Move> moves = board.allMoves(col);
        return moves.get((int) (Math.random()*moves.size()));
    }
}
