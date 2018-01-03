import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This program will setup the board according to the gamType. The program will then
 * setup the players dependent on which game mode is chosen. Each game mode will then
 * prompt the user or computer player to make a move. After the board will update
 * accordingly and then check win conditions or if the board is filled.
 */
public class Board extends TicTacToe{

    private JFrame frame = new JFrame("TicTacToe");

    private JButton[][] buttons = new JButton[3][3];

    private JPanel boardpanel = new JPanel(new GridLayout(3,3));

    private GameType gametype;

    private Marker marker;

    private ComputerPlayer computer = new ComputerPlayer();

    private ComputerPlayer computer2 = new ComputerPlayer();

    private HumanPlayer user = new HumanPlayer();

    private HumanPlayer user2 = new HumanPlayer();

    private Random rn = new Random();

    private ButtonHandler bh = new ButtonHandler();

    private Timer simtime = new Timer(500, bh);

    private int turn;

    /**
     * This will initialize the board window that will display the board of
     * JButtons in a 3 by 3 grid layout. Then it will setup the players
     * depending on the game mode.
     * @param gametype This is the gameType that was chosen by the user
     */
    public void initFrame(GameType gametype)
    {
        this.gametype = gametype;
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initBoardPanel();
        frame.add(boardpanel, BorderLayout.CENTER);
        frame.setSize(250, 250);
        frame.setVisible(true);

        if(gametype.equals(GameType.Single_Player))
        {
            initSingle();
        }
        else if(gametype.equals(GameType.Two_Player))
        {
            initDouble();
        }
        else
        {
            initSimulation();
        }
    }

    /**
     * This is to initialize the board panel with empty JButtons
     * in a 3 by 3 layout.
     */
    private void initBoardPanel()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].addActionListener(bh);
                buttons[i][j].setEnabled(false);
                boardpanel.add(buttons[i][j]);
            }
        }
    }

    /**
     * This is to update the game board display with enabled
     * and disabled buttons depending on if it is populated
     * with anything or not. If it is populated then it should
     * not be an enabled button since it jas been used.
     */
    public void updateDisplay()
    {
        boardpanel.removeAll();
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(buttons[i][j].getText().charAt(0) == ' ') {
                    buttons[i][j].setEnabled(true);
                }
                else
                {
                    buttons[i][j].setEnabled(false);
                }
                boardpanel.add(buttons[i][j]);
            }
        }
    }

    /**
     * If the button has been disabled and the text is still empty then the user
     * pressed the for his turn therefore a marker should be placed on the button
     * text. The marker placed is the user marker that is stored in the variable
     * marker.
     */
    private void updateUserBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++) {
                if ((buttons[i][j].getText().charAt(0) == ' ') && !(buttons[i][j].isEnabled())) {
                    if (marker.equals(Marker.cross)) {
                        buttons[i][j].setText("X");
                    } else {
                        buttons[i][j].setText("O");
                    }
                }
            }
        }
    }

    /**
     * This method removes all teh buttons on the button panel and refreshes
     * them by placing new updated buttons that have that states saved in
     * the buttons array, but disabling all buttons so it cannot be modified
     * by the player until it is the players turn.
     */
    public void updateComputerBoard()
    {
        boardpanel.removeAll();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
                boardpanel.add(buttons[i][j]);
            }
        }
    }

    /**
     * This is the initializer for the Single Player Game Mode. This will
     * randomize the marker the user gets and who gets to make the first
     * move on the board. The computer will get the other marker.
     * It will alert the player which marker they are
     * playing with. After passing the initialized board to the button
     * handler class. If the computer player goes first the user will wait
     * for the computer to make a move as the buttons are disabled till the
     * computer finishes his move. The buttons are enabled for the player
     * to make his move.
     */
    private void initSingle()
    {
        int mark = rn.nextInt(2);
        if(mark == 0)
        {
            user.setMarker(Marker.cross);
            marker = user.getMarker();
            computer.setMarker(Marker.circle);
            user.makeMove(this);
        }
        else
        {
            user.setMarker(Marker.circle);
            marker = user.getMarker();
            computer.setMarker(Marker.cross);
            computer.makeMove(this);
            user.makeMove(this);
        }
        JOptionPane.showMessageDialog(null,"Your Marker: " + marker);
        bh.setBoard(this);
    }

    /**
     * This is the initializer for the Two Player Game Mode. This will
     * randomize the marker the user gets and who gets to make the first
     * move on the board. The other player will get the other marker. An
     * alert message will prompt which player will go first and the marker
     * they got. The board will be passed to the button handler.
     */
    private void  initDouble()
    {
        int mark = rn.nextInt(2);
        if(mark == 0)
        {
            user.setMarker(Marker.cross);
            marker = user.getMarker();
            user2.setMarker(Marker.circle);
            user.makeMove(this);
            turn = 1;
            JOptionPane.showMessageDialog(null,"Player 1's Turn\n Your Marker: " + marker);
        }
        else
        {
            user.setMarker(Marker.circle);
            user2.setMarker(Marker.cross);
            marker = user2.getMarker();
            user2.makeMove(this);
            turn = 2;
            JOptionPane.showMessageDialog(null,"Player 2's Turn\n Your Marker: " + marker);
        }
        bh.setBoard(this);
    }

    /**
     * This is the initializer for the Simulator Mode. This will randomize the marker for both
     * computer players. The computer player that goes first will be called to make the first move.
     * The board will then be passed on to the button handler.  A timer will then be set and for
     * every half a second the timer will call the button handler.
     */
    private void initSimulation()
    {
        int mark = rn.nextInt(2);
        if(mark == 0)
        {
            computer.setMarker(Marker.cross);
            marker = computer.getMarker();
            computer2.setMarker(Marker.circle);
            computer.makeMove(this);
            turn = 2;
        }
        else
        {
            computer.setMarker(Marker.circle);
            computer2.setMarker(Marker.cross);
            marker = computer2.getMarker();
            computer2.makeMove(this);
            turn = 1;
        }
        bh.setBoard(this);
        simtime.start();
    }

    /**
     * This method will check if the specific space is empty and avalible to be used as a move.
     * @param row The row of the array of JButtons to be used for the move
     * @param column The column of the array of JButtons to ve used for the move
     * @return The boolean value if it is a valid move
     */
    public boolean validMove(int row, int column)
    {
        return buttons[row][column].getText().charAt(0) == ' ';
    }

    /**
     * The method used to mark the AI move. Using the opposite marker that is
     * stored in the marker variable.
     * @param row The row of the array of JButtons to be used for the move
     * @param column The column of the array of JButtons to be used for the move
     */
    public void updateAIBoard(int row, int column)
    {
        if(marker.equals(Marker.circle)) {
            buttons[row][column].setText("X");
        }
        else
        {
            buttons[row][column].setText("O");
        }
        buttons[row][column].setEnabled(false);
    }

    /**
     * This method is used to check if the board is completely full. If it is full
     * then the game is over and it is a tie. The program will prompt the tie message
     * and then end the program.
     */
    private void fullBoardCheck()
    {
        boolean isfull = true;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(buttons[i][j].getText().charAt(0) == ' ')
                {
                    isfull = false;
                    break;
                }
            }
            if(!isfull)
            {
                break;
            }
        }
        if(isfull)
        {
            simtime.stop();
            JOptionPane.showMessageDialog(null," Its A Tie!");
            System.exit(0);
        }
    }

    /**
     * This is the end display. If a win condition occurs then the
     * this method is called with the wining marker. An alert message
     * will show the winner of the game.
     * @param mark The character of the winning marker
     */
    private void gameEnd(char mark)
    {
        Marker winner;
        simtime.stop();
        if(mark == 'X')
        {
            winner = Marker.cross;
        }
        else
        {
            winner = Marker.circle;
        }
        JOptionPane.showMessageDialog(null,winner + " is the Winner!");
        System.exit(0);
    }

    /**
     * This method will check all the Tic Tac Toe win conditions
     * possible. If a win condition occurs it will call the method
     * endGame with the correct winning marker.
     */
    private void winConditionCheck()
    {
        boolean win;
        char mark;
        for(int row = 0; row < 3; row++)
        {
            win = true;
            mark = buttons[row][0].getText().charAt(0);
            if(mark != ' ')
            {
                for(int column = 0; column < 3; column++)
                {
                    if(mark != buttons[row][column].getText().charAt(0))
                    {
                        win = false;
                        break;
                    }
                }
                if(win)
                {
                    gameEnd(mark);
                }
            }
        }
        for(int column = 0; column < 3; column++)
        {
            win = true;
            mark = buttons[0][column].getText().charAt(0);
            if(mark != ' ')
            {
                for(int row = 0; row < 3; row++)
                {
                    if(mark != buttons[row][column].getText().charAt(0))
                    {
                        win = false;
                    }
                }
                if(win)
                {
                    gameEnd(mark);
                }
            }
        }
        win = false;
        mark = buttons[0][0].getText().charAt(0);
        if(mark != ' ')
        {
            for(int i = 0; i < 3; i++)
            {
                if(buttons[i][i].getText().charAt(0) != mark)
                {
                    win = false;
                    break;
                }
                else
                {
                    win = true;
                }
            }
            if(win)
            {
                gameEnd(mark);
            }
        }
        mark = buttons[1][1].getText().charAt(0);
        if((buttons[0][2].getText().charAt(0) == buttons[1][1].getText().charAt(0)) && (buttons[1][1].getText().charAt(0) == buttons[2][0].getText().charAt(0)) && (buttons[1][1].getText().charAt(0) != ' '))
        {
            gameEnd(mark);
        }
    }

    /**
     * This is the button handler that is used for each turn in every game mode.
     * Once the button is pressed for game modes one player and two player. They
     * will call for the next player to make their move. If it is single player
     * it will call the computer player to make the next move then wait for the
     * human player to make the next move again. If it is two player a prompt
     * will pop up with the next players turn.
     *
     * If it is a simulator mode then the timer will call the button handler
     * each half of a second alternating between computer players turns / markers.
     *
     * After the winCondition method will be called and the fullBoard
     * method will be checked as afterwards.
     *
     * If none of the conditions are true it will continue alternating turns till
     * one condition becomes true.
     */
    private class ButtonHandler implements ActionListener{

        private Board board;

        private void setBoard(Board board)
        {
            this.board = board;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton buttonpresssed;
            if(gametype.equals(GameType.Single_Player))
            {
                buttonpresssed = (JButton) e.getSource();
                if (marker.equals(Marker.cross)) {
                    buttonpresssed.setText("X");
                } else {
                    buttonpresssed.setText("O");
                }
                buttonpresssed.setEnabled(false);
                updateUserBoard();
                board.updateDisplay();
                winConditionCheck();
                fullBoardCheck();

                computer.makeMove(board);
                board.updateComputerBoard();
                winConditionCheck();
                fullBoardCheck();
                board.updateDisplay();
            }
            else if(gametype.equals(GameType.Two_Player))
            {
                buttonpresssed = (JButton) e.getSource();
                if (marker.equals(Marker.cross)) {
                    buttonpresssed.setText("X");
                } else {
                    buttonpresssed.setText("O");
                }
                buttonpresssed.setEnabled(false);
                updateUserBoard();
                board.updateDisplay();
                winConditionCheck();
                fullBoardCheck();
                if(turn == 1)
                {
                    turn = 2;
                }
                else
                {
                    turn = 1;
                }
                if(turn == 1)
                {
                    marker = user.getMarker();
                    JOptionPane.showMessageDialog(null,"Player 1's Turn\n Your Marker: " + marker);
                }
                else
                {
                    marker = user2.getMarker();
                    JOptionPane.showMessageDialog(null,"Player 2's Turn\n Your Marker: " + marker);
                }
            }
            else
            {
                if(turn == 1)
                {
                    marker = computer.getMarker();
                    computer.makeMove(board);
                    turn = 2;
                }
                else
                {
                    marker = computer2.getMarker();
                    computer2.makeMove(board);
                    turn = 1;
                }
                winConditionCheck();
                fullBoardCheck();
            }
        }
    }
}
