//Generate the board from the text file

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class gameboard {
  public static void main(String[] args) throws Exception {

      int boardsize = 0;
      char c;
      int i;
      char[][] board;
      String board1 = "";

    //Accept a file input from the user
    while(true){
      Scanner in = new Scanner(System.in);
      System.out.println("Type the name of the file you would like to read: ");
      String fileName = in.nextLine();
      try{
        FileReader fr = new FileReader(fileName);

        //convert the file components into a string
        while ((i=fr.read()) != -1) {
          c = (char) i;
          board1 += String.valueOf(c);
        }
        break;
      } catch (FileNotFoundException e) {
        System.out.println("This is not an existing file please restart and try again");
      }
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
      for (int j=0; j < boardsize; j++) {
        for (int k=0; k < boardsize; k++) {
          board[j][k] = board1.charAt(k + j*boardsize + 2);
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
