/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is the Players class that the Human and Computer Player
 * class inherits from. Each player has a marker, a moveMaker method,
 * and the ability to get and set the marker. We set the makeMove
 * abstract as we do not know what should be in the method but we know
 * what the structure should be and that each player needs the ability
 * to make a move.
 */
abstract public class Player extends TicTacToe{

    /**
     * The marker for the specific player.
     */
    private Marker marker;

    /**
     * This is the method that will be used to make a move.
     * @param board The board of the Tic Tac Toe Board
     */
    abstract void makeMove(Board board);

    /**
     * This is to retrieve the marker that the player has.
     * @return The marker that the player uses
     */
    public Marker getMarker()
    {
        return this.marker;
    }

    /**
     * Method to set up the marker for the player.
     * @param marker The marker that the player uses
     */
    public void setMarker(Marker marker)
    {
        this.marker = marker;
    }

}
