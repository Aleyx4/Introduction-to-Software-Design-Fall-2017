# 23-11_BouncingBalls_Medium

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

![ScreenShot](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/23-11_BouncingBalls_Medium/doc/Screenshot.png?raw=true)

### Problem Statement
Write a program that will bounce balls in a window. The balls should be created with a click of a mouse. When the ball hits the edge of the window it should bounce off the edge and continue moving in the opposite direction. Each ball should be in a separate thread.

### User Documentation
When this program runs the user will be able to create a ball with each click the user makes. The program will randomly assign this ball a color, size, and movement pattern. The program will be able to end at anytime the user closes the window. The window size can be dynamically changed and the balls will bounce accordingly to the new window size.

### Developer Documentation
This program has several classes. This includes a ball class, movement class and the application class.

The `Ball` class will have all the properties of the ball that is needed for the application. In this class you are able to retrieve the properties of the ball color, size, speed, and location. There are also set methods to update the balls location and speed. A final method called `addBall()` is used to create a ball with its properties in the corresponding Graphics object for a JPanel.

The `Move` class is a runnable class for multi-threading. The constructor will begin by passing in the ball object and its window to the runnable class. This will then run and  update its position based on the movement speed. The boundaries are set by the window that is passed into the move class from the constructor. After updating its location it will repaint the window with the new location with a delay based on the number of frames per second built into the program. It is set with 10 millisecond per frame making it 100 frames per second.

The application class `BouncingBalls` is the main function that creates the viewer for the balls. Its constructor will set the frame of 500 by 500 and create a listener for its mouse. Each time a mouse is clicked it will create a ball object and store the new ball in an array list. It will then create a task for the ball object to be passed into the move class that continuously updates its movement or position. The draw class that extends JPanel is the class that is the viewer for the program. The class will draw the balls that are in the array list.

### UML Diagram

![23-11_BouncingBalls_Medium_UML](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/23-11_BouncingBalls_Medium/doc/23-11_BouncingBalls_Medium_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/23-11_BouncingBalls_Medium/doc/)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/23-11_BouncingBalls_Medium/src/)
