import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is the main program for Tic Tac Toe. This will initialize the
 * game window by asking the user the type of game mode the user wants
 * to play then call the board to initialize the board to the specified
 * game mode.
 */
public class TicTacToe {

    /**
     * The object type marker is the possible markers that the board may have.
     */
    public enum Marker {cross, circle}

    /**
     * The object type gameType are the possible gameTypes that are possible.
     */
    public enum GameType {Single_Player, Two_Player, Simulation}

    /**
     * The variable to store the gameType the user chooses.
     */
    private GameType gametype;

    /**
     * The JFrame for the pop up window to choose the gameType the user wants to play.
     */
    private JFrame frame = new JFrame("TicTacToe");

    /**
     * The holder for the gameType list and Start button.
     */
    private JPanel onepanel = new JPanel(new FlowLayout());

    /**
     * The List of gameTypes that can be selected.
     */
    private JComboBox<GameType> gametypelist = new JComboBox<>(GameType.values());

    /**
     * This method is to initialize the Tic Tac Toe game. It will prompt the user
     * to choose a gameType and then once the user hits start it will begin to
     * populate the board in the board class with the corresponding gameType.
     */
    public void initMenu()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel menu = new JLabel("Pick Your Game Mode:");
        menu.setHorizontalAlignment(frame.getWidth()/2);
        ButtonHandler bh = new ButtonHandler();
        JButton button = new JButton("Start");
        button.addActionListener(bh);
        onepanel.add(gametypelist);
        onepanel.add(button);
        frame.add(menu, BorderLayout.NORTH);
        frame.add(onepanel, BorderLayout.CENTER);
        frame.setSize(300,90);
        frame.setVisible(true);
    }

    /**
     * Retrieve the gamrType chosen by the user.
     * @return The gameType the user chose
     */
    public GameType getGameType()
    {
        return this.gametype;
    }

    /**
     * Method to set the gameType.
     * @param gametype The gameType to be set.
     */
    public void setGameType(GameType gametype)
    {
        this.gametype = gametype;
    }

    /**
     * Button Handler that is used to confirm the users choice of the
     * specific gameType. This will initialize the board with the
     * specific gameType chosen.
     */
    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            setGameType((GameType)gametypelist.getSelectedItem());
            frame.removeAll();
            frame.setVisible(false);
            Board board = new Board();
            board.initFrame(gametype);
        }
    }
}