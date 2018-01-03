import javax.swing.*;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is a runnable class that will be used to create and update ball movement.
 * This will use that size of the window that is given to decide when the ball
 * need to bounce and it will update the direction and location of the ball.
 */
public class Move implements Runnable {
    /**
     * The Ball Object that needs to have the speed, direction, and location modified,
     */
    private Ball b;
    /**
     * The Frame of where the ball are being drawn. Used to get the boarders of the window for bouncing.
     */
    private JFrame frame;

    /**
     * Constructor to get the Ball and JFrame object.
     * @param b The Ball Object that will be moving in the Frame
     * @param frame The JFrame that will have the Ball moving in
     */
    public Move(Ball b, JFrame frame) {
        this.b = b;
        this.frame = frame;
    }

    @Override
    /**
     * This is the logic of how the ball will move. The conditions are that the ball will move in the
     * speed and direction it was generated in the properties every 10 milliseconds. If the ball reaches
     * to the edge of the window size it will change directions (reverse with negative speed on a specific
     * axis depending on which wall it bounced).
     */
    public void run() {
        while (true) {
            b.setXlocation(b.getXspeed() + b.getXlocation());
            b.setYlocation(b.getYspeed() + b.getYlocation());
            if ((b.getXlocation() > (frame.getComponent(0).getWidth() - b.getSize()))) {
                b.setXlocation(frame.getComponent(0).getWidth() - b.getSize());
                b.setXspeed(-b.getXspeed());
            }
            if ((b.getYlocation() > (frame.getComponent(0).getHeight() - b.getSize()))) {
                b.setYlocation(frame.getComponent(0).getHeight() - b.getSize());
                b.setYspeed(-b.getYspeed());
            }
            if ((b.getXlocation() < 0)) {
                b.setXlocation(0);
                b.setXspeed(-b.getXspeed());
            }
            if ((b.getYlocation() < 0)) {
                b.setYlocation(0);
                b.setYspeed(-b.getYspeed());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            frame.repaint();
        }
    }
}