//An implementation of Strategy 1 - Euclidian

import java.io.*;
import java.util.*;

public class euclidian {

  public static double calculateDistanceEuclidian(int robotRow, int robotCol, int goalRow, int goalCol){
    //compute the formula -- sqrt[(i-i')^2+(j-j')^2]
    double start = Math.pow((robotRow - goalRow), 2);
    double end = Math.pow((robotCol - goalCol), 2);
    double distance = Math.sqrt(start + end);
    return distance;
  }

  public static void searchEuclid(char[][] board, int locationRow, int locationCol, int goalRow, int goalCol){
    char [][] euclidBoard = board.clone();
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    int leftCol = locationCol - 1;
    int rightCol = locationCol + 1;
    int upRow = locationRow - 1;
    int downRow = locationRow + 1;
    int euclidCost = 0;

    ArrayList<Integer> possibleUp = new ArrayList<Integer>();
    ArrayList<Integer> possibleDown = new ArrayList<Integer>();
    ArrayList<Integer> possibleLeft = new ArrayList<Integer>();
    ArrayList<Integer> possibleRight = new ArrayList<Integer>();


    while(true) {
      leftCol = locationCol - 1;
      rightCol = locationCol + 1;
      upRow = locationRow - 1;
      downRow = locationRow + 1;

      if(locationCol > 0){
        if(Character.toString(board[locationRow][leftCol]).equals("g")){
          robot.updateBoardEuclid(euclidBoard, locationRow, locationCol);
          euclidCost++;
          break;
        }
        if(Character.toString(board[locationRow][leftCol]).equals(".")){
          possibleLeft.add(locationRow);
          possibleLeft.add(leftCol);
          arr.add(possibleLeft);
        }
      }
      if(locationCol < euclidBoard.length - 1){
        if(Character.toString(board[locationRow][rightCol]).equals("g")){
          robot.updateBoardEuclid(euclidBoard, locationRow, locationCol);
          euclidCost++;
          break;
        }
        if(Character.toString(board[locationRow][rightCol]).equals(".")){
          possibleRight.add(locationRow);
          possibleRight.add(rightCol);
          arr.add(possibleRight);
        }
      }
      if(locationRow > 0){
        if(Character.toString(board[upRow][locationCol]).equals("g")){
          robot.updateBoardEuclid(euclidBoard, locationRow, locationCol);
          euclidCost++;
          break;
        }
        if(Character.toString(board[upRow][locationCol]).equals(".")){
          possibleUp.add(upRow);
          possibleUp.add(locationCol);
          arr.add(possibleUp);
        }
      }
      if(locationRow < euclidBoard.length - 1){
        if(Character.toString(board[downRow][locationCol]).equals("g")){
          robot.updateBoardEuclid(euclidBoard, locationRow, locationCol);
          euclidCost++;
          break;
        }
        if(Character.toString(board[downRow][locationCol]).equals(".")){
          possibleDown.add(downRow);
          possibleDown.add(locationCol);
          arr.add(possibleDown);
        }
      }

      double calc = 0;
      int row = 0;
      int col = 0;
      ArrayList<Double> calcs = new ArrayList<Double>();

      //loop through list and calc distance on all locations in ArrayList
      for (int i = 0; i < arr.size(); i++) {
        //System.out.println(arr.get(i));
        row = arr.get(i).get(0);
        col = arr.get(i).get(1);
        calc = calculateDistanceEuclidian(row, col, goalRow, goalCol);
        calcs.add(calc);
      }

      double min = Collections.min(calcs);
      int index = calcs.indexOf(min);

      locationRow = arr.get(index).get(0);
      locationCol = arr.get(index).get(1);

      robot.updateBoardEuclid(euclidBoard, locationRow, locationCol);
      euclidCost++;

      possibleUp.clear();
      possibleDown.clear();
      possibleRight.clear();
      possibleLeft.clear();
      arr.clear();
      calcs.clear();
    }

    System.out.println("Euclidian Strategy Path: ");
    for (int j=0; j < euclidBoard.length; j++) {
      for (int k=0; k < euclidBoard.length; k++) {
        System.out.print(euclidBoard[j][k]);
      }
      System.out.println("");
    }
    System.out.println("This strategy's path cost: " + euclidCost);

  }
}
