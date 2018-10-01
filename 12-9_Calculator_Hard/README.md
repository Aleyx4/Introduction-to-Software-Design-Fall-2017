# 12-9_Calculator_Hard

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

![ScreenShot](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/12-9_Calculator_Hard/doc/Screenshot.png?raw=true)

### Problem Statement
Create a GUI calculator that will run the basic functions:
- Addition
- Subtraction
- Multiplication
- Division
- Decimals (Floats)

### User Documentation
When this program starts the GUI interface will display. On the bottom, half of the window will be keys for inputting in an expression. Once the user hits the "=" symbol it will return the value in the text box above the key. You can continue to do operations or hit "C" to clear the expression in the text box. The "-" key can be used as a negative or a subtraction symbol. If the expression is not valid it will not return a valid number instead it will return an error message to the display. Clear the message by pressing "C" to clear the display to try inputting a new expression.

### Developer Documentation
The calculator program initialized the frame to place the button panel and text box in the correct BorderLayout. The text box is set to be not editable so it makes sure the inputs are more likely to not contain any invalid characters. The button handler will input any buttons pressed into the text box until the "=" symbol is pressed. Once the button is pressed then the program will parse the String to a linked list. Then the program will optimise and go through the order of operations removing linked list elements as it gets simplified. Once only one element is left in the linked list then that is the answer and it gets inputted back into the text box to be reused. If "C" button is ever pressed the text boxes will be cleared. While parsing the expression if at any point it tries to parse a character that is not a number and tried to arithmetic the program will catch the exception and display an error message.

Creating a new Calculator Object will automatically initialize the JFrame for the Calculator to be visible with its functionality ready to go.

### UML Diagram

![12-9_Calculator_Hard](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/12-9_Calculator_Hard/doc/12-9_Calculator_Hard_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/12-9_Calculator_Hard/doc)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/12-9_Calculator_Hard/src)
