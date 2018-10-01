# 28-13_FileRetrieve_Easy
# Submitted by @awong4 as part of @swd2017

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

### Problem Statement
Create a server and client application that will have the client able to request for a text file. The server will look for the file requested and then open and read the file to the client. If the server does not have the file that the client requests it should tell the client so. This program should be using a socket connection.

### User Documentation
The server program must be running before the client program. Once they are both running the client will try to attempt to connect with the server. Once connected the client will be able to type in the path and file name to request a file to be read. If the file requested is not found a message will appear to tell you, otherwise if found it will begin reading the file line by line. The user may terminate the connection by typing in "TERMINATE".

### Developer Documentation
The `Client` class will have the constructor method that will create the window for the client with the text fields for talking back and forth to the client and server. The constructor requires a string of the IP address for the connection to the server. This is modified as you create the new client object. To connection a specific server.

The `runClient()` method will process the connections and streams to and from the server. This is called once the client is created to start communicating to the server.

The `Server` class will be the file hosting source. The constructor will create the window to display what the client requests and what you are sending to the client as well.

The `runServer()` method will process the connections and streams to and from the client. This is called once the server is created to start communicating to the client.

### UML Diagram

![28-13_FileRetrieve_Easy_UML](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/28-13_FileRetrieve_Easy/doc/28-13_FileRetrieve_Easy_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/28-13_FileRetrieve_Easy/doc/)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/28-13_FileRetrieve_Easy/src/)
