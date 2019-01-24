import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class Game here.
 * 
 * @author Morgan Douglas 
 * @version 
 */
public class Game
{

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        Board board = new Board();
        BoardDisplay display = new BoardDisplay(board);
        Piece blackKing = new King(Color.BLACK, "black_king.gif");
        blackKing.putSelfInGrid(board, new Location (0, 4));
        Piece whiteKing = new King(Color.WHITE, "white_king.gif");
        whiteKing.putSelfInGrid(board, new Location (7, 4));
        Piece blackRook1 = new Rook(Color.BLACK, "black_rook.gif");
        blackRook1.putSelfInGrid(board, new Location(0, 0));
        Piece blackRook2 = new Rook(Color.BLACK, "black_rook.gif");
        blackRook2.putSelfInGrid(board, new Location(0, 7));
        Piece whiteRook1 = new Rook(Color.WHITE, "white_rook.gif");
        whiteRook1.putSelfInGrid(board, new Location(7, 0));
        Piece whiteRook2 = new Rook(Color.WHITE, "white_rook.gif");
        whiteRook2.putSelfInGrid(board, new Location(7, 7));
        Piece whiteBobo1 = new Boboquin(Color.WHITE, "white_boboquin.gif");
        whiteBobo1.putSelfInGrid(board, new Location(7,2)); 
        Piece whiteBobo2 = new Boboquin(Color.WHITE, "white_boboquin.gif");
        whiteBobo2.putSelfInGrid(board, new Location(7,5)); 
        Piece blackBobo1 = new Boboquin(Color.BLACK, "black_boboquin.gif");
        blackBobo1.putSelfInGrid(board, new Location(0,2)); 
        Piece blackBobo2 = new Boboquin(Color.BLACK, "black_boboquin.gif");
        blackBobo2.putSelfInGrid(board, new Location(0,5)); 
        
        Piece whiteQueen = new Queen(Color.WHITE, "white_queen.gif");
        whiteQueen.putSelfInGrid(board, new Location(7,3)); 
        Piece blackQueen = new Queen(Color.BLACK, "black_queen.gif");
        blackQueen.putSelfInGrid(board, new Location(0,3)); 
        for(int i=0; i<8; i++)
        {
            Piece p = new Pawn(Color.BLACK, "black_pawn.gif");
            p.putSelfInGrid(board, new Location(1, i));
        }
        for(int i=0; i<8; i++)
        {
            Piece p = new Pawn(Color.WHITE, "white_pawn.gif");
            p.putSelfInGrid(board, new Location(6, i));
        }
        Piece blackKnight1 = new Knight(Color.BLACK, "black_knight.gif");
        blackKnight1.putSelfInGrid(board, new Location(0, 1));
        Piece blackKnight2 = new Knight(Color.BLACK, "black_knight.gif");
        blackKnight2.putSelfInGrid(board, new Location(0,6));
        
        Piece whiteKnight1 = new Knight(Color.WHITE, "white_knight.gif");
        whiteKnight1.putSelfInGrid(board, new Location(7, 1));
        Piece whiteKnight2 = new Knight(Color.WHITE, "white_knight.gif");
        whiteKnight2.putSelfInGrid(board, new Location(7,6));
        
        Player jeb = new RandomPlayer(board, "jeb", Color.WHITE);
        Player karl = new HumanPlayer(board, "karl", Color.BLACK, display);
        
        display.showBoard();
        play(board, display, jeb, karl);
    }

    /**
     * Finds and executes next Move for a particular Player (executes
     * a single "turn" of game)
     * @param board Board being used
     * @param display BoardDisplay being used
     * @param player the Player whose turn it is
     */
    private static void nextTurn(Board board,
    BoardDisplay display, Player player)
    {
        display.setTitle(player.getName());
        Move move = player.nextMove();
        board.executeMove(move);
        display.clearColors();
        display.setColor(move.getSource(), Color.RED);
        display.setColor(move.getDestination(), Color.BLUE);
        try {Thread.sleep(500);} catch(InterruptedException e) {}
    }

    /**
     * repeatedly asks for and executes next moves. Alternates between
     * black and white players.
     * @param board Board being used
     * @param display BoardDisplay being used
     * @param white the white player
     * @param black the black player
     */
    public static void play(Board board, BoardDisplay display,
    Player white, Player black)
    {
        Boolean b = true;
        int i=1;
        while(b)
        {
            if(i%2==0)
            {
                nextTurn(board, display, white);
            }
            else
            {
                nextTurn(board, display, black);
            }
            i++;
            display.showBoard();
            ArrayList<Location> locs = board.getOccupiedLocations();
            int z=0;
            for(Location l : locs)
            {
                if(board.get(l).getValue()==1000)
                    z++;
                else{}
            }
            if(z!=2)
            {
                b=false;
                JOptionPane op = new JOptionPane();
                op.showMessageDialog(null,"Game Over!");
            }
        }
    }
}