# 18-20_MazeTraversal_Hard

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

### Problem Statement
Write a recursive method to traverse through the maze. The maze is based on a 2D array that will consist of `#` and `.`. Where the `#` is the wall and `.` is a path.

#### Example of a Maze:

![Maze Example](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/18-20_MazeTraversal_Hard/doc/Screenshot_1.png?raw=true)

### User Documentation
The user will not need to do anything because the program will automatically run and traverse through the maze.

### Developer Documentation
The basic method `printMaze()` is used to print a 2D array with the size in row and column of the maze. 

The constructor `MazeTraversal()` will take the starting position given and set all the views from the front, left, right, and back. `mazeSize()` will set the size of maze. `printCurrentView()` will print out the views of all around the current position and print if it is a valid movement option and the location of the view.

`finishMaze()` will check if the maze is complete where the finish line must be at the end of the grid board. `traverse()` is used to traverse the maze calling the recursive call moving through out the maze depending on what the views show. 

The traversal method used is the right turn method.

### UML Diagram

![18-20_MazeTraversal_Hard_UML](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/18-20_MazeTraversal_Hard/doc/18-20_MazeTraversal_Hard_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/18-20_MazeTraversal_Hard/doc)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/18-20_MazeTraversal_Hard/src/)
