import javax.swing.*;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is the Sever Tester Class. This will create a server for the
 * client to connect to.
 */
public class ServerTest {
    public static void main(String[] args) {
        Server application = new Server(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer(); // run server application
    }
}