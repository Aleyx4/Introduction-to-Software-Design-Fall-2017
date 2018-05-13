# Figure 2.4 (welcome3.java)

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

### Problem Statement
This program is used in Java How To Program Early Objects (10th Edition) in by Paul and Harvey Deitel to learn how to display multiple lines of text with a single line of code. This is shown in Figure 2.4 of the book. This uses `\n` within the `System.out.println()` to line break between characters without another `System.out.println()`.

### User Documentation
Once the user starts this program it will print out the following message:
>Welcome

>to

>Java

>Programming!

The program will end once the message is completely printed out.

### Developer Documentation
This program has only the main class called `Welcome3`. Within this, it only contains the main method that contains one line of code:
```java
System.out.println("Welcome\nto\nJava\nProgramming!");
```
This will print out the text and create a line break in between when `\n` is injected. 

[Source Code] (https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/tree/master/Figure%202.4%20(Welcome3.java)/src)
