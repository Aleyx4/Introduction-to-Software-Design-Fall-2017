# S18_MergeSort_Medium
# Submitted by @awong4 as part of @swd2017

[Home](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017 "Home")

### Problem Statement
This program is to implement the merge sort algorithm in Java. The program must generate an array of 100 random integers from 0 to 1000. It should print the original array and sort the array from least to greatest. After it will print the newly sorted array.

### User Documentation
The user will need to do nothing as when you run the program it will generate the 100 numbers and print the unsorted array then sort and print the newly sorted array.

### Developer Documentation
This program will generate and sort the array of any size. The array format is a array list. The method `listgen()` with a provided integer it will generate a array list of the size with the numbers between 0 and 1000. This will then be saved into the array list in the class.

For you to get the array list you may use the method `getArray()` which will return an array list of integers of the specified size generated.

The method `printList()` will take the list from the class and print it in list with a commas to separate it.

The method `sort()` is a recursive merge sorting algorithm it will take in an array list of integers and split it up based on the algorithm by recursively calling this method till it is completely split up. It will then compare the left and right array sets and merge them back together into the array list in this class. In the end the array list in the class will be sorted you may call the `printList()` method to see the newly sorted array.

### UML Diagram

![S18_MergeSort_Medium_UML](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/blob/master/S18_MergeSort_Medium/doc/S18_MergeSort_Medium_UML.png?raw=true)

### [JavaDocs](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/S18_MergeSort_Medium/doc/)

### [Source Code](https://github.com/Aleyx4/Introduction-to-Software-Design-Fall-2017/S18_MergeSort_Medium/src/)
