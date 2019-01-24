/**
 * Represents a single move, in which a piece moves to a destination location.
 * Since a move can be undone, also keeps track of the source location and any captured victim.
 * @author Morgan Douglas
 * @version 4/16/17
 */
public class Move
{
	private Piece piece;
	private Location source;
	private Location destination;
	private Piece victim;

	/**
	 * Constructs a new move for moving the given piece to the given destination.
	 * @param piece the Piece being moved
	 * @param destination the Location to which piece is being moved
	 */
	public Move(Piece piece, Location destination)
	{
		this.piece = piece;
		this.source = piece.getLocation();
		this.destination = destination;
		this.victim = piece.getBoard().get(destination);
		if (source.equals(destination))
			throw new IllegalArgumentException("Both source and dest are " + source);
	}

	/**
	 * @return the piece being moved
	 */
	public Piece getPiece()
	{
		return piece;
	}

	/**
	 * @return source of move
	 */
	public Location getSource()
	{
		return source;
	}

	/**
	 * @return location being moved to
	 */
	public Location getDestination()
	{
		return destination;
	}

	/**
	 * @return piece being captured at destination
	 */
	public Piece getVictim()
	{
		return victim;
	}

	/**
	 * @return String description of move
	 */
	public String toString()
	{
		return piece + " from " + source + " to " + destination + " containing " + victim;
	}

	/**
	 * @return true if Move object is equivalent to another Move object;
	 * false otherwise
	 * @param x Object being compared
	 */
	public boolean equals(Object x)
	{
		Move other = (Move)x;
		return piece == other.getPiece() && source.equals(other.getSource()) &&
			destination.equals(other.getDestination()) && victim == other.getVictim();
	}

	/**
	 * @return hashcode for move
	 */
	public int hashCode()
	{
		return piece.hashCode() + source.hashCode() + destination.hashCode();
	}
}