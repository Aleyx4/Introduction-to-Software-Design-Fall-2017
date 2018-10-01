# 22-13_ColorChooser_Hard
# Submitted by @awong4 as part of @swd2017

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

### Problem Statement
Create a color chooser that will provide three sliders and text fields. Each slider and text field will have a specific value from 0 to 255 for the colors red, green, and blue which are all part of the color composition. These values will be linked to each other if the slider updates then the text field should update as well and in reverse as well. A panel should preview the current color values and should auto update with each change in value of the color composition.

### User Documentation
The program will run and provide three slides and text fields with one in each row. The labels on each row are the colors that compose of the color at the bottom of the window which is the preview of that color. The sliders can be moved left to right from 0  to 255 respectively. The user may also type the number in the text box if they do not want to use the sliders. Any changes will automatically update the entire program from the color preview, sliders, and text field. You may close the program at any time the user presses to the "x" at the top right corner of the window.

### Developer Documentation
This class have the following set and get methods. `RedValue()`, `GreenValue()`, and `BlueValue()`. These methods are used to edit the color to your choice and get its color composition values of its current color as well. The method `initWindow()` is used to setup the application display for the sliders, text fields, and such for user to be able to see it in GUI. Handlers are use for the slider and the text fields to update each other and its color previewer.

### UML Diagram

![22-13_ColorChooser_Hard_UML](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/22-13_ColorChooser_Hard/doc/22-13_ColorChooser_Hard_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/22-13_ColorChooser_Hard/doc/)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/22-13_ColorChooser_Hard/src/)
