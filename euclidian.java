//An implementation of Strategy 1 - Euclidian

import java.io.*;
import java.util.*;

public class euclidian {

  public static void euclidianDistance(char[][] board){
    // formula -- E((i,j),(i',j')) = sqrt[(i-i')^2+(j-j')^2])
    int initialRow = 0;
    int initialCol = 0;
    int goalRow = 0;
    int goalCol = 0;
    double distance = 0;

    //obtain locations of the initial state and the goal state
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

    //compute the formula -- sqrt[(i-i')^2+(j-j')^2]
    double start = Math.pow((initialRow - goalRow), 2);
    double end = Math.pow((initialCol - goalCol), 2);
    distance = Math.sqrt(start + end);

    System.out.println(distance);
  }
}
