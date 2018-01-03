import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is the server side of the program. This program will allow the
 * client to access any files in the Server side. The user will need
 * to request a file in a specific directory. Preferably a text file
 * that exists. If it exits the Server will read and sent the text
 * line by line to the client. If the file does not exits it the
 * Server will tell the client no file exits.
 */
public class Server extends JFrame {
    /**
     * This is the display field of all information that is sent and received from server to client
     * and client to server.
     */
    private JTextArea displayArea;
    /**
     * Output Stream to the Client
     */
    private ObjectOutputStream output;
    /**
     * Input Stream from Client
     */
    private ObjectInputStream input;
    /**
     * Socket to Communicate with the Client
     */
    private ServerSocket server;
    /**
     * Connection Socket to Connect to the Client
     */
    private Socket connection;
    /**
     * The Counter to the Number of Connections the Server Has
     */
    private int counter = 1;

    /**
     * The Initialization for the Server Window
     */
    public Server() {
        super("File Host");

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150); // set size of window
        setVisible(true); // show window
    }

    /**
     * Setup and Run the Server
     */
    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } catch (EOFException eofException) {
                    displayMessage("\nServer Terminated Connection");
                } finally {
                    closeConnection(); //  close connection
                    ++counter;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Wait for Connection Request to Arrive and then Display Connection Information
     * @throws IOException Any issue to connect to the Client will throw a IOException
     */
    private void waitForConnection() throws IOException {
        displayMessage("Waiting For Connection\n");
        connection = server.accept(); // allow server to accept connection
        displayMessage("Connection " + counter + " Received From: " +
                connection.getInetAddress().getHostName());
    }

    /**
     * Get Steams to Send and Receive Data to and from the Client
     * @throws IOException Any issue to get the Streams will throw an IOException
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O Streams\n");
    }

    /**
     * Process the Connection to the Client and Receiving Messages and Processing its Request
     * @throws IOException Any issue with the connection to the client will throw a IOException
     */
    private void processConnection() throws IOException {
        String message = "Connection Successful";
        sendData(message); // send connection successful message

        do // process messages sent from client
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\nClient Requested File: " + message); // display file requested
                readFile(message);
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown Object Type Received");
            }

        } while (!message.equals("\nCLIENT>>> TERMINATE"));
    }

    /**
     * This is to read the file with the given file directory and name.
     * If the file could not be found it will prompt an error to the client.
     * If the file is found it will open the file and send its contents line
     * by line till the end of the file.
     * @param filename The string of the file directory and name
     */
    private void readFile(String filename)
    {
        String message = "";
        try{
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));
            sendData("--------"+filename+"--------");
            while((message = br.readLine())!= null)
            {
                sendData(message);
                message = "";
            }
            sendData("--------End Of File--------");
            br.close();
        } catch (FileNotFoundException e)
        {
            sendData("SERVER>>> File Was Not Found!");
        } catch (IOException e)
        {
        }
    }

    /**
     * A method to close the Stream and Socket to end
     * the connection to the server.
     */
    private void closeConnection() {
        displayMessage("\nTerminating Connection\n");

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Method to send messages to the Client.
     * @param message The string of a message to be sent to the client
     */
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject(message);
            output.flush(); // flush output to client
            displayMessage("\n" + message);
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
                        displayArea.append(messageToDisplay); // append message
                    }
                }
        );
    }
}