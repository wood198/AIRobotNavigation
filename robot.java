//The actual implementation of robots movement throughout the board using the strategies

import java.io.*;
import java.util.*;

public class robot {
  public static void initializeRobotEnvironment(char[][] board){
    //look around itself to find the . around it
    //choose . and send it to the aEuclidian / aManhattan to see if its right
    //if its right
      //replace . with o in board when moved there
    //else look at a different . around it
    //replace the current . with a o

    int locationRow = 0;
    int locationCol = 0;
    int goalRow = 0;
    int goalCol = 0;
    char[][] euclidBoard;
    char[][] manBoard;
    char[][] aEuclidBoard;
    char[][] aManBoard;


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

    euclidian.searchEuclid(euclidBoard, locationRow,locationCol, goalRow, goalCol);
    aEuclidian.searchAEuclid(aEuclidBoard, locationRow,locationCol, goalRow, goalCol);
    manhattan.searchMan(manBoard, locationRow,locationCol, goalRow, goalCol);
    aManhattan.searchAMan(board, locationRow,locationCol, goalRow, goalCol);

  }

  public static char[][] updateBoardEuclid(char[][] board, int locationRow, int locationCol){
    String replace = "o";
    board[locationRow][locationCol] = replace.charAt(0);
    return board;
  }

  public static char[][] updateBoardAMan(char[][] board, int locationRow, int locationCol){
    String replace = "o";
    board[locationRow][locationCol] = replace.charAt(0);
    return board;
  }

  public static char[][] updateBoardAEuclid(char[][] board, int locationRow, int locationCol){
    String replace = "o";
    board[locationRow][locationCol] = replace.charAt(0);
    return board;
  }

  public static char[][] updateBoardMan(char[][] board, int locationRow, int locationCol){
    String replace = "o";
    board[locationRow][locationCol] = replace.charAt(0);
    return board;
  }
}
