//Generate the board character by character from the text file

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class gameboard {
  public static void main(String[] args) throws Exception {

    //Accept a file input from the user
    Scanner in = new Scanner(System.in);
    System.out.println("Type the name of the file you would like to read: ");
    String fileName = in.nextLine();
    FileReader fr = new FileReader(fileName);

    int boardsize = 0;
    char c;
    int i;
    char[][] board;
    String board1 = "";

    //convert the file components into a string
    while ((i=fr.read()) != -1) {
      c = (char) i;
      board1 += String.valueOf(c);
    }

    //clean the string to have it all on one line
    board1 = board1.replaceAll("\r", "").replaceAll("\n", "");

    //compute the boardsize
    char t = board1.charAt(0);
    boardsize = Integer.parseInt(String.valueOf(t));

    board = new char[boardsize][boardsize];

    //create the board
    for (int j=0; j < boardsize; j++) {
      for (int k=0; k < boardsize; k++) {
        board[j][k] = board1.charAt(k + j*boardsize + 1);
      }
    }

    euclidian.euclidianDistance(board);
    manhattan.manhattanDistance(board);

  }
}
