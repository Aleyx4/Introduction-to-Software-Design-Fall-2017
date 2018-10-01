# S21_Hangman_Hard

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

![ScreenShot](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/S21_HangmanGUI_Hard/doc/Screenshot.png?raw=true)

### Problem Statement
This program is to allow the user to be able to play Hangman with a implemented GUI. The GUI will need the following:

- A place for the user to input the word to be guessed. The word should be hidden from the player
- The number of guesses left in the game
- The incorrect letters guessed
- A Place for the guesser to input a letter
- A Display for the number of characters in the word and the correct letters guessed
- Indication of when the game is over
- Graphics for hangman progression of the game


#### [General Rules of Hangman](https://en.wikipedia.org/wiki/Hangman_(game)#Overview)

### User Documentation
The user at the beginning of the game will be prompted to input a word. This word will be hidden with a password field hiding the word from view. Once entered the user will be greeted with the GUI. The bottom window will have the alphabet of buttons that can be pushed to guess a letter. On the left side of the window is the letters guessed and on the right is the number of guesses left before game over. Each time the user pushes a letter the program will check if the corresponding letter is in the word. If it is it will populate the display of the blank spaces with the letter otherwise you will lose a guess left and a stick figure will slowly be drawn as well.

As the game progresses the GUI will begin to populate and until the end, if the user ran out of guesses the "Game Over" message box will be displayed with the word that was to be guessed. If the user guesses all the letters correctly the "You Win" message box will appear instead.

The program will exit once the game has been completed.

### Developer Documentation
The program as a method called `initalsetup()`. This method will initialize all the required panels to the frame. They will be placed according to a BorderLayout and size the windows to the set preferred size. It will then be viewable. `initalsetup()` requires a String to be able to set the word that should be guessed onto the panel.

#### `getWord()`
This will allow access to the word that is being guessed.

#### `getUsedletters()`
Allows you to see a string of letters that the user has already guessed.

Example of the String:
> ABCDEFG

Note: The String will include one space at the beginning of the String

#### `getGuessesleft()`
This will return an integer of the guesses the user has left.

#### `getGuessedletters()`
This will return an integer of the number of letters that have been guessed.

The following functions allow you to be able to get information from the game also it allows you to set up the hangman game by initializing a word of your choice.

Internally there is a Button Handler that will handle all of the events of when a button is pressed. This includes being able to set the panels to display new information and being able to handle events when the game is over.

The `DrawHangman` class will override the inherited class of painComponent from JPanel and draw the hangman graphics depending on the number of guesses left.

### UML Diagram

![S21_Hangman_Hard_UML](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/S21_HangmanGUI_Hard/doc/S21_HangmanGUI_Hard_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/S21_HangmanGUI_Hard/doc)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/S21_HangmanGUI_Hard/src)
