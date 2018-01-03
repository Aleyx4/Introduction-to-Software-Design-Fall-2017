import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is the client side of the program. This program will allow the
 * client to access any files in the Server side. The user will need
 * to request a file in a specific directory. Preferably a text file
 * that exists. If it exits the Server will read and sent the text
 * line by line to the client. If the file does not exits it the
 * Server will tell the client no file exits.
 */
public class Client extends JFrame {
    /**
     * This is the JTextField that will allow the user to enter the file
     * directory and file name. That should be requested to the Server side.
     */
    private JTextField enterField;
    /**
     * This is the display field of all information that is sent and received from server to client
     * and client to server.
     */
    private JTextArea displayArea;
    /**
     * Output Stream to the Server
     */
    private ObjectOutputStream output;
    /**
     * Input Stream from Server
     */
    private ObjectInputStream input;
    /**
     * Any Message Sent from the Server will be Stored Here
     */
    private String message = "";
    /**
     * Host Server for this Application
     */
    private String chatServer;
    /**
     * Socket to Communicate with the Server
     */
    private Socket client;
    /**
     * Top JPanel for the TextFieldBox and Buttons
     */
    private JPanel top = new JPanel(new FlowLayout());
    /**
     * The JButton to Open the File Selector
     */
    private JButton fileSelector = new JButton("File Selector");
    /**
     * The JButton to Send What is in the TextFieldBox
     */
    private JButton send = new JButton("Send Request");

    /**
     * The Initialization for the Client Window
     * @param host The IP Address to the Host ex. 127.0.0.1
     */
    public Client(String host) {
        super("Client");

        chatServer = host; // set server to which this client connects

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);

        /**
         * ActonListener for the keyboard when the Enter key is pressed.
         * When the Enter key is pressed the data in the textfield will
         * be send and cleared.
         */
        enterField.addActionListener(new ActionListener() {
                    // Send message to server by hitting "ENTER"
                    public void actionPerformed(ActionEvent e) {
                        sendData(e.getActionCommand());
                        enterField.setText("");
                    }
                }
        );

        /**
         * ButtonListener for the FileSelector that will open up the
         * FileChooser to select the file that should be opened. Then
         * giving the path to the textfield to be submitted.
         *
         * Note: This function is for debugging in a LocalHost as you
         * should not have the ability to see the file directory of the
         * sever.
         */
        fileSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(getParent());
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    enterField.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        /**
         * ButtonListener for the Send JButton. When the button is
         * pressed the data in the textfield will be sent and cleared.
         */
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData(enterField.getText());
                enterField.setText("");
            }
        });

        top.add(enterField);
        top.add(fileSelector);
        top.add(send);
        add(top, BorderLayout.NORTH);

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(650, 700); // set size of window
        enterField.setPreferredSize(new Dimension(400,20));
        setVisible(true); // show window
    }

    /**
     * Connection to connect to the Server and Process Messages
     * that are send from the Server.
     */
    public void runClient() {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (EOFException eofException) {
            displayMessage("\nClient Terminated Connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection(); // close connection
        }
    }

    /**
     * Method to Connect to the Server
     * @throws IOException Any error in trying to connect to the server will throw an IOException
     */
    private void connectToServer() throws IOException {
        displayMessage("Attempting Connection\n");

        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 12345);

        // display connection information
        displayMessage("Connected To: " +
                client.getInetAddress().getHostName());
    }

    /**
     * Get Streams to Send and Receive Data
     * @throws IOException Any error in trying to receive and send data will throw a IOException
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O Streams\n");
    }

    /**
     * Process the Connection to the Server and Receiving Messages
     * @throws IOException Any issue with the connection to the server will throw a IOException
     */
    private void processConnection() throws IOException {
        // enable enterField so client user can send messages
        setTextFieldEditable(true);

        do // process messages sent from server
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown Object Type Received");
            }

        } while (!message.equals("SERVER>>> TERMINATE"));
    }

    /**
     * A method to close the Stream and Socket to end
     * the connection to the server and disabling any
     * ability to send.
     */
    private void closeConnection() {
        displayMessage("\nClosing Connection");
        setTextFieldEditable(false); // disable enterField
        fileSelector.setEnabled(false);
        send.setEnabled(false);

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Method to send messages to the Server.
     * @param message The string of a message to be sent to the server
     */
    private void sendData(String message) {
        try // send object to server
        {
            output.writeObject(message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT>>> Requesting File: " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError Writing Object");
        }
    }

    /**
     * Display message that should be displayed with from the display area.
     * @param messageToDisplay The string of a message that should be displayed / added to
     *                         the display area
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }

    // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable(editable);
                    }
                }
        );
    }
}
