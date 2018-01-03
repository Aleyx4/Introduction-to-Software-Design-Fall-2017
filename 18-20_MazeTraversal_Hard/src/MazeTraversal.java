/**
 * @author Alex Wong wong4a@gmail.com
 * @version 1.0
 * <p>MazeTraversal is a program that will take a 2D array of a maze of
 * any box size and with a given starting position it will traverse through
 * the maze till it finds the exit. The exit is defined where the path hits
 * the edge of the maze map. The class contained in this program will print
 * out the maze each time marker makes a move through the maze. The marker
 * uses a right turn path to complete the maze.
 *
 * As the maze traverses through the paths the previous marks are "X".
 *
 * Note: Starting Position must be a starting edge of the maze.
 *
 * The maze format uses "#" as walls and "." as the path. The following is
 * an example of a maze:
 *
 * # # # # # # # #
 * # . . . . . . #
 * # . # . # # . .
 * . . # . . # . #
 * # # # # # # # #
 *
 * This is then formatted into an 2d array as such:
 * {
 * {"#","#","#","#","#","#","#","#"}
 * {"#",".",".",".",".",".",".","#"}
 * {"#",".","#",".","#","#",".","."}
 * {".",".","#",".",".","#",".","#"}
 * {"#","#","#","#","#","#","#","#"}
 * }</p>
 */
public class MazeTraversal   {
    /**
     * This is a array that stores the current y and x coordinates
     * respective to its array positions 0 and 1.
     */
    private int[] currentPosition = {0,0};
    /**
     * This is a array that stores that startin y and x coordinates
     * respective to its array positions 0 and 1.
     */
    private int[] startingPosition = {0,0};
    /**
     * This is the maze size in the horizontal direction.
     */
    private int mazeXSize;
    /**
     * This is the maze size in the vertical direction.
     */
    private int mazeYSize;
    /**
     * This is a array that stores the position of the front view
     * of the marker direction with its y and x coordinates
     * respective to its array position 0 and 1.
     */
    private int[] front = {0,0};
    /**
     * This is a array that stores the position of the back view
     * of the marker direction with its y and x coordinates
     * respective to its array position 0 and 1.
     */
    private int[] back = {0,0};
    /**
     * This is a array that stores the position of the left view
     * of the marker direction with its y and x coordinates
     * respective to its array position 0 and 1.
     */
    private int[] left = {0,0};
    /**
     * This is a array that stores the position of the right view
     * of the merker directio with its y and x coordinates
     * respective to its array position 0 and 1.
     */
    private int[] right = {0,0};

    /**
     * This method is to print out the maze that is given.
     * @param maze The 2D array of the respective maze that will be printed out
     * @param rows The size of the maze in its vertical direction
     * @param columns The size of the maze in its horizontal direction
     */
    public void printMaze(String[][] maze, int rows, int columns)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * This is a debugger method that will print out the views of each view and its grid position
     * This prints out a true or false for each view that shows if the path is blocked or avalible.
     * @param maze The 2D array of the respective maze that will be printed out
     */
    public void printCurrentView(String[][] maze)
    {
        System.out.println("front: " + frontview(maze) + " " + front[0] + ", " + front[1]);
        System.out.println("left: " + leftview(maze) + " " + left[0] + ", " + left[1]);
        System.out.println("right: " + rightview(maze) + " " + right[0] + ", " + right[1]);
        System.out.println("current position: " + currentPosition[0] + ", " + currentPosition[1]);
    }

    /**
     * This is the constructor call for the MazeTraversal to set up the program. It will
     * set up the starting position with is current position. Then it will begin to set
     * up the views from the front, left, right, and back position. If the starting position
     * it at the border the null value "-10" will be set.
     * @param row The starting Y position of the maze
     * @param column The starting X position of the maze
     */
    public MazeTraversal(int row, int column)
    {
        currentPosition[0] = row;
        currentPosition[1] = column;
        startingPosition[0] = row;
        startingPosition[1]= column;
        if(startingPosition[0] == 0)
        {
            front[0] = -10;
            front[1] = -10;

            back[1] = column;
            back[0] = row - 1;
        }
        else if(startingPosition[0] == mazeXSize)
        {
            front[1] = column;
            front[0] = row + 1;

            back[0] = -10;
            back[1] = -10;
        }
        else
        {
            front[1] = column;
            front[0] = row - 1;

            back[1] = column;
            back[0] = row + 1;
        }
        if(startingPosition[1] == 0)
        {
            left[0] = -10;
            left[1] = -10;

            right[1] = column + 1;
            right[0] = row;
        }
        else if(startingPosition[1] == mazeYSize)
        {
            left[1] = column - 1;
            left[0] = row;

            right[0] = -10;
            right[1] = -10;
        }
        else
        {
            left[1] = column - 1;
            left[0] = row;

            right[1] = column + 1;
            right[0] = row;
        }
    }

    /**
     * Sets up the maze size variables
     * @param rowmax The size of the maze in the vertical direction
     * @param columnmax The size of the maze in the horizontal direction
     */
    public void mazeSize(int rowmax, int columnmax)
    {
        mazeXSize = columnmax;
        mazeYSize = rowmax;
    }

    /**
     * Checks if the current position is at teh finishing point in the maze. If it is then
     * it will return a boolean value of true otherwise if it is incomplete it will return false.
     * @return Boolean value if the maze is complete or not
     */
    public boolean finishMaze()
    {
        if((currentPosition[0] == startingPosition[0])&&(currentPosition[1] == startingPosition[1]))
        {
            System.out.println("Error - No Finish Line Found!");
            return true;
        }
        return ((currentPosition[0] != startingPosition[0])&&(currentPosition[1] != startingPosition[1])&&((currentPosition[0] == mazeYSize-1)||(currentPosition[0] == 0)||(currentPosition[1] == mazeXSize-1)||(currentPosition[1] == 0)));
    }
    
    /**
     * This is method that is used to traverse the maze. It will print out the maze traversal
     * as it goes through each step of the maze, It will mark the marker with a "O". This will
     * run till it reaches to the end of the maze. This is a recursive method till the maze is
     * complete.
     * @param maze The 2D array of the respective maze to be traversed
     */
    private void start(String[][] maze)
    {
        maze[currentPosition[0]][currentPosition[1]] = "O";
        printMaze(maze, mazeYSize, mazeXSize);
        maze[currentPosition[0]][currentPosition[1]] = "X";
        // # . #
        // # O #
        // # . #
        if((!leftview(maze))&&(!rightview(maze))&&(frontview(maze)))
        {
            //printCurrentView(maze);
            moveforward();
        }
        // # . #
        // . O .
        // # . #
        else if(leftview(maze)&&rightview(maze)&&frontview(maze))
        {
            //printCurrentView(maze);
            rotateright();
            moveforward();
        }
        // # # #
        // # O .
        // # . #
        else if((!frontview(maze))&&(!leftview(maze))&&(rightview(maze)))
        {
            //printCurrentView(maze);
            rotateright();
            moveforward();
        }
        // # # #
        // . O #
        // # . #
        else if((!frontview(maze))&&(leftview(maze))&&(!rightview(maze)))
        {
            //printCurrentView(maze);
            rotateleft();
            moveforward();
        }
        // # . #
        // # O .
        // # . #
        else if((frontview(maze))&&(!leftview(maze))&&(rightview(maze)))
        {
            //printCurrentView(maze);
            rotateright();
            moveforward();
        }
        // # # #
        // . O .
        // # . #
        else if((!frontview(maze))&&(leftview(maze))&&(rightview(maze)))
        {
            //printCurrentView(maze);
            rotateright();
            moveforward();
        }
        // # . #
        // . O #
        // # . #
        else if((frontview(maze))&&(leftview(maze))&&(!rightview(maze)))
        {
            //printCurrentView(maze);
            moveforward();
        }
        // # # #
        // # O #
        // # . #
        else if((!frontview(maze))&&(!leftview(maze))&&(!rightview(maze)))
        {
            rotateright();
            rotateright();
            moveforward();
        }
        else
        {
            rotateright();
        }
        if(!finishMaze())
        {
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {

            }
            clear();
            start(maze);
        }
    }

    /**
     * This is method that is used to traverse the maze. It will call the
     * recursive method to traverse through the maze and once completed it
     * will print out that the maze is completed.
     * @param maze The 2D array of the respective maze to be traversed
     */
    public void traverse(String[][] maze)
    {
        start(maze);
        maze[currentPosition[0]][currentPosition[1]] = "O";
        printMaze(maze, mazeYSize, mazeXSize);
        maze[currentPosition[0]][currentPosition[1]] = ".";
        System.out.println("Maze Completed!");
    }

    /**
     * This is to check if the front view is a valid position to move to.
     * @param maze The 2D array for the respective maze being traversed
     * @return Boolean value to check if it is a valid move and has no wall in the way
     */
    private boolean frontview(String[][] maze)
    {
        try {
            return ((maze[front[0]][front[1]] == ".")||(maze[front[0]][front[1]] == "X"));
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    /**
     * This is to check if the left view is a valid position to move to.
     * @param maze The 2D array for the respective maze being traversed
     * @return Boolean value to check if it is a valid move and has no wall in the way
     */
    private boolean leftview(String[][] maze)
    {
        try {
            return ((maze[left[0]][left[1]] == ".")||(maze[left[0]][left[1]] == "X"));
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    /**
     * This is to check if the right view is a valid position to move to.
     * @param maze The 2D array for the respective maze being traversed
     * @return Boolean value to check if it is a valid move and has no wall in the way
     */
    private boolean rightview(String[][] maze)
    {
        try {
            return ((maze[right[0]][right[1]] == ".")||(maze[right[0]][right[1]] == "X"));
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    /**
     * Updates the position as it moves forward. Taking the current position and updating it
     * to the Front position. The change in position is calculated and used to update the other
     * viewing positions.
     */
    private void moveforward()
    {
        if((front[0] > -1)||(front[1] > -1))
        {
            int tempYChange = front[0] - currentPosition[0];
            int tempXChange = front[1] - currentPosition[1];
            currentPosition[0] = front[0];
            currentPosition[1] = front[1];

            front[0] = currentPosition[0] + tempYChange;
            front[1] = currentPosition[1] + tempXChange;

            back[0] = currentPosition[0] - tempYChange;
            back[1] = currentPosition[1] - tempXChange;

            if(tempXChange == 0)
            {
                left[0] = currentPosition[0];
                right[0] = currentPosition[0];
                if(tempYChange == 1)
                {
                    left[1] = currentPosition[1] + 1;
                    right[1] = currentPosition[1] - 1;
                }
                else
                {
                    left[1] = currentPosition[1] - 1;
                    right[1] = currentPosition[1] + 1;
                }
            }
            else
            {
                left[1] = currentPosition[1];
                right[1] = currentPosition[1];
                if(tempXChange == 1)
                {
                    left[0] = currentPosition[0] - 1;
                    right[0] = currentPosition[0] + 1;
                }
                else
                {
                    left[0] = currentPosition[0] + 1;
                    right[0] = currentPosition[0] - 1;
                }
            }
        }
    }

    /**
     * Updates the view positions rotating the positions to the right where
     * the Front position gets the Right position, the Right position gets the
     * Back Position, the Back position gets the Left position, and the Left position
     * gets the Front position.
     */
    private void rotateright()
    {
        int tempY = left[0];
        int tempX = left[1];
        left[0] = front[0];
        left[1] = front[1];
        front[0] = right[0];
        front[1] = right[1];
        right[0] = back[0];
        right[1] = back[1];
        back[0] = tempY;
        back[1] = tempX;
    }

    /**
     * Updates the view positions rotating the positions to the left where
     * the Front position gets the Left Position, the Left position gets the
     * Back position, the Back position gets the Right position and the Right
     * position gets the Front.
     */
    private void rotateleft()
    {
        int tempY = left[0];
        int tempX = left[1];
        left[0] = back[0];
        left[1] = back[1];
        back[0] = right[0];
        back[1] = right[1];
        right[0] = front[0];
        right[1] = front[1];
        front[0] = tempY;
        front[1] = tempX;
    }

    /**
     * This is a function to create space to clear the console for ease of
     * viewing of the maze at each traversal.
     */
    public void clear()
    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
