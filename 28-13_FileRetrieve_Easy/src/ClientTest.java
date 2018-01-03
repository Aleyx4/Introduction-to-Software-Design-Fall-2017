import javax.swing.*;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is a Client Tester class. This will attempt to connect
 * to the Server class with its IP. In this example this will
 * connect to a LocalHost IP.
 */
public class ClientTest {
    public static void main(String[] args) {
        Client application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new Client("127.0.0.1"); // connect to localhost
        else
            application = new Client(args[0]); // use args to connect

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}