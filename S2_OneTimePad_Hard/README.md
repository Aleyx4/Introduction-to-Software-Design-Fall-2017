# S2_OneTimePad_Hard
# Submitted by @awong4 as part of @swd2017

[Home](https://class-git.engineering.uiowa.edu/swd2017/awong4_swd/wikis/home "Home")

### Problem Statement
This program needs to generate a key file with the user inputting a set number of values to be generated as a key.

>If the user inputs: 15

>The key generator will generate 15 values as such:

>8, 15, 6, 7, 12, 20, 11, 4, 3, 8, 1, 16, 12, 2, 7

The program will then generate a starting place for the set of numbers to start its encryption.

Example of a Key Generated File:

>7

>8, 15, 6, 7, 12, 20, 11, 4, 3, 8, 1, 16, 12, 2, 7

On the encrypting program, it will then take the key generated file and ask for the user to input the message to be encrypted. For example, let the message be *HELLO*. The encrypter will start at the seventh digit in this case and it would be *11*. Beginning with the message encryption we shift the alphabet by *11* spaces to the right for the first character. In this case, it would be *S*. After we go to the next number on the right of the list which is *4*. Then encrypt the next letter *E* which becomes *I* and so forth.

The following would be the encrypted message file:

>7

>SIOTP

We then need to update the key generated file of the number *7* to where the message ended which is at the number *16* which is the twelve number, therefore the end key files would be:

>12

>8, 15, 6, 7, 12, 20, 11, 4, 3, 8, 1, 16, 12, 2, 7

The decrypting program will then need to retrace through to get back to the real message. This program should also ask the user for the following file locations of the key generated file and the encrypted file.

### User Documentation

This is broken down into three different programs:
- Key Generator = **OneTimePadKeyGen**
- Encrypter = **OneTimePadEncrypt**
- Decrypter = **OneTimePadDecrypt**

#### OneTimePadKeyGen

The user will use this program to generate a key file to be used for encrypting the message. This program will prompt the user to input the file directory for where the user wants the new key file to be created. It will also prompt the user to input the desired name of the new key file. The file will then be created and ask the user the number of values they want to populate in the key value set for the file and the max range of numbers it should generate. Once entered in the file will begin by populating the first line with the index value of where to start encrypting from which can be anywhere from the beginning to the last value that will be on the key value set. The second line will then be generated with the values from one to the max value the user inputted until a full set of values is completely generated.

The file created will have the extension .ky to easily identify the file.

#### OneTimePadEncrypt

The user will use this program to generate the encrypted file of a message they want. They will need to have a key file already made to be able to use this program as it will ask for it at the beginning of the program. After the user will input the message they want encrypted. The message can only have letters and spaces. No numbers, punctuation, and such is allowed in the message. The program will then ask the user to input a directory where the encrypted file should be stored and its name for the new file to be created.

The encrypted file will have an extension .em to easily determine it is the encrypted message file.

#### OneTimePadDecrypt

The user will be using this program to decrypt the encrypted message file with a key file. The user will need to input in the directory to both of these files to allow the program to decrypt the message. The program will output the message onto the prompt once it all the files has been inputted.

### Developer Documentation

As these are standalone programs for encryption and decryption the development of these programs. Each one of the main programs will prompt the user for the files needed to progress through the program and will automatically read these files and interpret them. Then it will call the methods corresponding to its program:

#### `keygen()`
This will generate the number of numbers within the range determined and output a String of numbers divided by spaces.

#### `encrypt()`
This will take a character and the number of times it needs to be shifted right though ASCII code values. If it reaches the end of the alphabet it will go back to the start and continually shift. After it will output the encrypted character.

#### `decrypt()`
This will do the same as what `encrypt()` did but in reverse where it will shift to the left though ASCII code values and output the decrpted character.

### UML Diagram

![S2_OneTimePad_Hard_UML](https://class-git.engineering.uiowa.edu/swd2017/awong4_swd/raw/master/oral_exam1/S2_OneTimePad_Hard/S2_OneTimePad_Hard_UML.png)

### [JavaDocs](http://localhost:8000/oral_exam1/S2_OneTimePad_Hard/doc/)

### [Source Code](https://class-git.engineering.uiowa.edu/swd2017/awong4_swd/tree/master/oral_exam1/S2_OneTimePad_Hard/src)
