/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is the players class. It will has only one method
 * that is called for the players move it will enable all
 * the valid move buttons to allow the player to click
 * to choose a move for the marker to be placed.
 */
public class HumanPlayer extends Player{
    /**
     * This method is called for the players move it will enable all
     * the valid move buttons to allow the player to click
     * to choose a move for the marker to be placed.
     * @param board The board of the Tic Tac Toe Board
     */
    public void makeMove(Board board)
    {
        board.updateDisplay();
    }
}
