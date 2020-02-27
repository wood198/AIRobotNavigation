//The actual implementation of robots movement throughout the board using the strategies

import java.io.*;
import java.util.*;

public class robot {
  public static void search(char[][] board){
    for (int j = 0; j < board.length; j++) {
      for (int k = 0; k < board[j].length; k++) {
        System.out.print(board[j][k] + " ");
      }
      System.out.println("");
    }
  }
}
