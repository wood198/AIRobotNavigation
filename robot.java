//The actual implementation of robots movement throughout the board using the strategies

import java.io.*;
import java.util.*;

public class robot {
  public static void initializeRobotEnvironment(char[][] board){
    int locationRow = 0;
    int locationCol = 0;
    int goalRow = 0;
    int goalCol = 0;
    char[][] euclidBoard;
    char[][] manBoard;
    char[][] aEuclidBoard;
    char[][] aManBoard;

    //find the initial and goal locations on the board
    for (int j = 0; j < board.length; j++) {
      for (int k = 0; k < board[j].length; k++) {
        if(Character.toString(board[j][k]).equals("i")){
          locationRow = j;
          locationCol = k;
        }
        if(Character.toString(board[j][k]).equals("g")){
          goalRow = j;
          goalCol = k;
        }
      }
    }

    //create the boards used to print solutions for the 4 search strategies
    euclidBoard = new char[board.length][board.length];
    manBoard = new char[board.length][board.length];
    aEuclidBoard = new char[board.length][board.length];
    aManBoard = new char[board.length][board.length];

    for (int j=0; j < board.length; j++) {
      for (int k=0; k < board.length; k++) {
        euclidBoard[j][k] = board[j][k];
        manBoard[j][k] = board[j][k];
        aEuclidBoard[j][k] = board[j][k];
        aManBoard[j][k] = board[j][k];
      }
    }

    //call the 4 search strategies
    euclidian.searchEuclid(euclidBoard, locationRow,locationCol, goalRow, goalCol);
    aEuclidian.searchAEuclid(aEuclidBoard, locationRow,locationCol, goalRow, goalCol);
    manhattan.searchMan(manBoard, locationRow,locationCol, goalRow, goalCol);
    aManhattan.searchAMan(board, locationRow,locationCol, goalRow, goalCol);

  }

  //update the board changing . to o during eudlidian search when the location is changed
  public static char[][] updateBoardEuclid(char[][] board, int locationRow, int locationCol){
    String replace = "o";
    board[locationRow][locationCol] = replace.charAt(0);
    return board;
  }

  //update the board changing . to o during A*Manhatan search when the location is changed
  public static char[][] updateBoardAMan(char[][] board, int locationRow, int locationCol){
    String replace = "o";
    board[locationRow][locationCol] = replace.charAt(0);
    return board;
  }

  //update the board changing . to o during A*Euclidian search when the location is changed
  public static char[][] updateBoardAEuclid(char[][] board, int locationRow, int locationCol){
    String replace = "o";
    board[locationRow][locationCol] = replace.charAt(0);
    return board;
  }

  //update the board changing . to o during Manhatan search when the location is changed
  public static char[][] updateBoardMan(char[][] board, int locationRow, int locationCol){
    String replace = "o";
    board[locationRow][locationCol] = replace.charAt(0);
    return board;
  }
}
