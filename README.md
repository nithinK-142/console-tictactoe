# Tic Tac Toe Game

This is a simple implementation of the classic game Tic Tac Toe in Java, which can be played between two human players or a human player and an AI player. 

## Getting Started

To get started, clone the repository to your local machine and run the code using your favorite Java IDE. Alternatively, you can compile the code in the command line using `javac` and run it using `java`.

### Prerequisites

- Java SE Development Kit (JDK) 8 or higher

### How to Play

The game can be played in two modes: player vs. player (PVP) or player vs. AI (PVAI). When the game starts, the user will be prompted to choose a mode by entering the corresponding number. 

1. PVP: Two human players take turns placing their marks (X or O) on the 3x3 game board. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game.

2. PVAI: A human player faces off against an AI player. The human player places their mark first, followed by the AI player. The game board and AI player's moves are randomized. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game.

## Code Structure

The code consists of four classes: 

- `TicTacToe`: A class that defines the game board and contains methods for initializing the board, displaying the board, placing a mark on the board, checking for a win or draw, and more.

- `Player`: An abstract class that defines a player and contains a method for making a move. 

- `HumanPlayer`: A class that extends `Player` and represents a human player. It contains a method for prompting the user for a move.

- `AIPlayer`: A class that extends `Player` and represents an AI player. It contains a method for generating a random move. 
