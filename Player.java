import java.util.*;
import java.awt.*;
import java.awt.Color;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player
{
    // instance variables - replace the example below with your own
    private Board board;
    private String name;
    private Color col;

    /**
     * @param b points to board being used
     * @param s refers to player's name
     * @param c specifies player's team color
     * Constructor for objects of class Player
     */
    public Player(Board b, String s, Color c)
    {
        board = b;
        name = s;
        col = c;
    }

    public Board getBoard()
    {
        return board;
    }

    public String getName()
    {
        return name;
    }

    public Color getColor()
    {
        return col;
    }

    public abstract Move nextMove();
}
