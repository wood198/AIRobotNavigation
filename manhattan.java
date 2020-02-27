//An implementation of Strategy 2 - Manhattan

import java.io.*;
import java.util.*;

public class manhattan {

  public static void manhattanDistance(char[][] board){
    //formula -- M((i,j),(i',j')) = |i-i'| + |j-j'|)

    int initialRow = 0;
    int initialCol = 0;
    int goalRow = 0;
    int goalCol = 0;
    double distance = 0;

    for (int j = 0; j < board.length; j++) {
      for (int k = 0; k < board[j].length; k++) {
        if(Character.toString(board[j][k]).equals("i")){
          initialRow = j;
          initialCol = k;
        }
        if(Character.toString(board[j][k]).equals("g")){
          goalRow = j;
          goalCol = k;
        }
      }
    }

    //compute the formula -- |i-i'| + |j-j'|
    double start = Math.abs(initialRow - goalRow);
    double end = Math.abs(initialCol - goalCol);
    distance = start + end;

    System.out.println(distance);
  }

}
