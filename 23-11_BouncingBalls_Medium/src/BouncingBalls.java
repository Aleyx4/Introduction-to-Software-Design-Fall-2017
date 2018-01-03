import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This BouncingBalls class is where the Application Window is created.
 * This will create a new Ball object with each click of the mouse and add it to the
 * window. This works by using an ArrayList of all the balls created.
 * Each ball that is created will begin with a new thread running the Move class that
 * will animate the ball movements in the window from the PaintComponent method by
 * redrawing each ball location as they are updated int he Move class.
 */
public class BouncingBalls implements MouseListener {
    /**
     * The JFrame that is the main window for the BouncingBalls Application
     */
    private JFrame frame = new JFrame("Bouncing Balls");
    /**
     * The Ball Object that will be used to create balls and have its inherited
     * and modifiable properties.
     */
    private Ball b;
    /**
     * The ArrayList that will hold all the tasks that will be created for separate
     * threads that will create and update movement of each ball that is created.
     */
    private ArrayList<Move> tasks = new ArrayList<>();
    /**
     * A new drawing object that is created for drawing in
     * the balls into the window.
     */
    Draw d1 = new Draw();

    /**
     * This is the constructor class that will create the
     * window for where the balls will be displayed and
     * animated.
     */
    public BouncingBalls() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d1.setPreferredSize(new Dimension(500, 500));
        d1.addMouseListener(this);
        frame.add(d1);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This the drawing class that will draw the balls that are in
     * the ArrayList. Where each click will add another ball object
     * into the ArrayList and will be drawn in the window once updated.
     */
    private class Draw extends JPanel {
        /**
         * The ArrayList for all the Ball objects that are
         * created.
         */
        List<Ball> balls = new ArrayList<>();

        @Override
        /**
         * Drawing all the balls in the ArrayList by calling
         * the addBall() method from the Ball class that will
         * draw the ball with the properties specified in each
         * ball object.
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Ball b : balls) {
                b.addBall(g);
            }
            repaint();
        }

        /**
         * The method that will be called for each mouse click.
         * It will add a new Ball Object into the ArrayList and
         * be requested to be drawn into the window.
         * @param b The Ball object to be added into the ArrayList
         */
        public void addBall(Ball b) {
            balls.add(b);
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    /**
     * The Handler for the mouse action when the mouse is clicked.
     * When it is clicked it will create a ball from the draw class
     * to be added into the ArrayList. This will then draw a ball
     * into the window. Each ball will have a thread running for each
     * of the balls movements with the Move class. Each thread running
     * is also a task that is added in an ArrayList of tasks that will
     * continuously run.
     */
    public void mouseClicked(MouseEvent e) {
        b = new Ball(frame);
        d1.addBall(b);
        tasks.add(new Move(b, frame));
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(tasks.get(tasks.size() - 1));
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}