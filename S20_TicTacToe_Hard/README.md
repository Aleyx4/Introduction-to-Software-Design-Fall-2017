# S20_TicTacToe_Hard

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

![ScreenShot](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/S20_TicTacToe_Hard/doc/Screenshot.png?raw=true)

### Problem Statement
This is a Tic Tac Toe game that will support the following game modes.

- One Human Player and One Computer Player (Single Player)
- Two Human Players (Two Player)
- Two Computer Players (Simulation)

The program after each move must be displayed and check for a winner. If the winner or all places on the board are full. The program must display a status at the end of the game.

The game must consist of the following classes:
- Board: Holds the board configurations and ensures valid moves are made.
- Player: Parent class for both ComputerPlayer and HumanPlayer Classes.
- ComputerPlayer: Class representing a computer player. Inherits from the Player Class.
- HumanPlayer: Class representing a human player. Inherits from the Player Class.

The program must use inheritance and polymorphism to structure the program. The user interface must not contain any player-specific code except at points where you instantiate your ComputerPlayer or HumanPlayer objects. HumanPlayer cannot print to the screen except in HumanPlayer's makeMove method which is allowed to prompt the user for input and take in that input.

### User Documentation
The program once running will allow the user to select the game mode of the users choice. The board will begin to populate and then the game will begin. In simulation mode the game will be locked to the computer players only. The user will not be able to interact with the board. The winner will be shown once the game is complete.

In Single Player Mode, the program will randomly choose who goes first. If it is the player the board will be enabled for the user to interact with the board. Clicking on the active tiles will choose where to place the marker. If it is the computer player's turn it will lock the board till the computer is done with its turn. The game will continue till the board is filled or there is a winner. A prompt will show the results at the end of the game.

In Two Player Mode, the program will randomly choose who goes first. The program will prompt the user who goes first and the marker they will use. Each time the player completes a move the program will prompt for the next player. A end game prompt will show for the winner or tie.

### Developer Documentation
The `TicTacToe` class has the following enums:
- Marker: Only can be a cross or a circle.
- GameType: Single_Player, Two_Player, or Simulation

The method `initMenu()` will create a menu for the user to pick a game mode from a JComboBox. A button handler will tell what the user selected and then call the board to initialize according to the game mode chosen. You are able to get the game type chosen by calling `getGameType()`.

The `Board` class is used to initialize the board and its players. It is also used to determine the win conditions and ties. Also it will display the messages that will be used for the end game. This also controls who's turn it is.

`initFrame()` will create the base window while calling the correct `init` for the correct game mode. Each init game mode will set the correct players human or computer player. Then it will call the makeMove for the first persons turn depending on who goes first. The first player is randomly chosen by a toss of a random number from 0 or 1.

A button handler is used to determine the when the player has made its move. Then call the `makeMove()` for the next player. If it is a simulation the program will use a timer to delay and call the button handler to make a move for the computer player.

There are multiple update methods. `updateComputerBoard()` is used to remove all the buttons and disable them all for the user to not be able to mess with the buttons are done until the computer make its move. The `updateUserBoard()` uses the button status to determine which button was it. If the button was disabled because it was hit then the text on the button is replaced with the users marker. The `updateDisplay()` all the buttons will be enabled or disabled based on the text in each button if the button has a text marker then it will be disabled. If it is disable the user will be unable to press this button. `updateAIBoard()` will take the row and column selected to set the correct marker and disable the button.

The `validMove()` will check the row and column and give a Boolean variable if the move is valid.

### UML Diagram

![S20_TicTacToe_Hard_UML](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/S20_TicTacToe_Hard/doc/S20_TicTacToe_Hard_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/S20_TicTacToe_Hard/doc/)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/S20_TicTacToe_Hard/src/)
