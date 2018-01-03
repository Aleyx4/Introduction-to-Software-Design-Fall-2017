import java.util.Random;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is a class for computer players. This only
 * has one method that makes the computer player
 * randomly place the computer players marker in
 * a valid location then update the AIBoard.
 */
public class ComputerPlayer extends Player{
    /**
     * This method that makes the computer player
     * randomly place the computer players marker in
     * a valid location then update the AIBoard.
     *
     * This will disable the buttons till the AI
     * finishes its move. Making sure the player
     * cannot mess with the board till it is the
     * players turn.
     * @param board The board of the Tic Tac Toe Board
     */
    public void makeMove(Board board)
    {

        board.updateComputerBoard();
        Random rn = new Random();
        int row = rn.nextInt(3);
        int column = rn.nextInt(3);
        while(!board.validMove(row, column))
        {
            row = rn.nextInt(3);
            column = rn.nextInt(3);
        }
        board.updateAIBoard(row, column);

    }
}
