/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * This is the tester class for the MazeTraversal program. It will send a 2D array of a maze
 * into the program and allow it to traverse through the maze.
 */
public class MazeTraversalTest {
    public static void main(String args[])
    {
        //Maze that will be sent to be traversed
        String[][] maze = {
                {"#","#","#","#","#","#","#","#","#","#","#","#"},
                {"#",".",".",".","#",".",".",".",".",".",".","#"},
                {".",".","#",".","#",".","#","#","#","#",".","#"},
                {"#","#","#",".","#",".",".",".",".","#",".","#"},
                {"#",".",".",".",".","#","#","#",".","#",".","."},
                {"#","#","#","#",".","#",".","#",".","#",".","#"},
                {"#",".",".","#",".","#",".","#",".","#",".","#"},
                {"#","#",".","#",".","#",".","#",".","#",".","#"},
                {"#",".",".",".",".",".",".",".",".","#",".","#"},
                {"#","#","#","#","#","#",".","#","#","#",".","#"},
                {"#",".",".",".",".",".",".","#",".",".",".","#"},
                {"#","#","#","#","#","#","#","#","#","#","#","#"}
        };
        /*
         * Creating a new object called a MazeTraversal with its starting point from
         * X Coordinate of 0 and Y Coordinate of 2.
         */
        MazeTraversal mt = new MazeTraversal(2,0);
        /*
         * Set the size of the maze at a 12 by 12
         */
        mt.mazeSize(12,12);
        //Begin traversing through the maze
        mt.traverse(maze);
    }
}
