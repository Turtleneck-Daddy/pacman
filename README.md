#Development of the following program is almost complete

# Pacman
Pacman is a collection of classes that work together to make a recreation of the popular arcade game PACMAN.

## Description
The pacmanlogic package contains the logic classes.
The pacmangui package contains the Gui class to run GUI.
The pacmantext package contains the Text class to run the text based version.
The Resources folder contains the gif files for GUI.
The Testing folder contains the test classes and jar files to run the J Unit tests.
The input is expected in the following forms to indicate the direction they want the avatar to move in:
  w for up, s for down, d for right and  a for left.
The goal of the user is to collect coins and power ups (which reward points) without running into the ghosts present in the game.
Once power pellet is consumed the ghost can be eaten by the user.
The game ends once the user eats all the coins.

## Installation
Download the following java packages in the same folder:
  pacmanlogic
  pacmangui
  pacmantext
  Resources
The GUI version of the game can be run by compiling the Gui.java class in the console and then running Gui.
The Text version of the game can be run by compiling the Text.java class in the console and then running Text.
Command to compile- javac packagename/filename.java
Command to run - java packagename.filename

## Testing
Download the pacmanlogic package in the Testing folder
Command to compile- javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java
Command to run the test- java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test class>

## Authors
Nikita Tripathi 
Brendan Baker
Mubarak Adetunji
Soumya Kumaria
Vi Tsang

## Year
Project started in Feburary, 2019, development ended in April, 2019
Status: Completed
