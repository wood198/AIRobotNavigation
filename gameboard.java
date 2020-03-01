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
    char s = board1.charAt(1);
    boolean doubleDigits = isNumeric(String.valueOf(s));
    if(doubleDigits){
      String t = board1.substring(0, 2);
      boardsize = Integer.parseInt(t);
    }else{
      char p = board1.charAt(0);
      boardsize = Integer.parseInt(String.valueOf(p));
    }

    board = new char[boardsize][boardsize];

    //create the board
    if(doubleDigits){
      for (int j=1; j < boardsize; j++) {
        for (int k=1; k < boardsize; k++) {
          board[j][k] = board1.charAt(k + j*boardsize + 1);
        }
      }
    } else {
      for (int j=0; j < boardsize; j++) {
        for (int k=0; k < boardsize; k++) {
          board[j][k] = board1.charAt(k + j*boardsize + 1);
        }
      }
    }

    robot.initializeRobotEnvironment(board);

  }

  //checks if a string is a number
  public static boolean isNumeric(String str) {
  try {
    Integer.parseInt(str);
    return true;
  } catch(NumberFormatException e){
    return false;
  }
}
}
