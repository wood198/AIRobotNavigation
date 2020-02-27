//Generate the board character by character from the text file

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class gameboard {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    System.out.println("Type the name of the file you would like to read: ");
    String fileName = in.nextLine();
    FileReader fr = new FileReader(fileName);

    int count = 0;
    int countColumn = 0;
    int countRow = 0;
    int boardsize = 0;

    char c;
    int i;
    char[][] board;

    while ((i=fr.read()) != -1) {
      c = (char) i;
      boardsize = Integer.parseInt(String.valueOf(c));
      //System.out.println(boardsize);
      break;
    }

    board = new char[boardsize][boardsize];

    while ((i=fr.read()) != -1) {
      c = (char) i;
    // System.out.println(c);
      if(count == 0) {
        count++;
      } else {
        if(countColumn == boardsize){
          countColumn = 0;
          countRow = countRow + 1;
          if(countRow == boardsize) {
            break;
          }
        }
        board[countRow][countColumn] = c;
        System.out.println(board[countRow][countColumn] + " " + countRow + "," + countColumn + " 43");
        countColumn++;
      }
    }

    for (int j = 0; j < board.length; j++) {
      for (int k = 0; k < board[j].length; k++) {
        System.out.print(board[j][k] + " ");
      }
      System.out.print("\n");
    }
  }
}
