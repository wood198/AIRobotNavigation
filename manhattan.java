//An implementation of Strategy 2 - Manhattan

import java.io.*;
import java.util.*;

public class manhattan {

  public static double calculateDistanceManhattan(int robotRow, int robotCol, int goalRow, int goalCol){
    //compute the formula -- |i-i'| + |j-j'|
    double start = Math.abs(robotRow - goalRow);
    double end = Math.abs(robotCol - goalCol);
    double distance = start + end;
    return distance;
  }

  public static void searchMan(char[][] board, int locationRow, int locationCol, int goalRow, int goalCol) {
    char [][] manBoard = board;
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    int leftCol = locationCol - 1;
    int rightCol = locationCol + 1;
    int upRow = locationRow - 1;
    int downRow = locationRow + 1;
    int manCost = 0;

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
          robot.updateBoardMan(manBoard, locationRow, locationCol);
          manCost++;
          break;
        }
        if(Character.toString(board[locationRow][leftCol]).equals(".")){
          possibleLeft.add(locationRow);
          possibleLeft.add(leftCol);
          arr.add(possibleLeft);
        }
      }
      if(locationCol < manBoard.length - 1){
        if(Character.toString(board[locationRow][rightCol]).equals("g")){
          robot.updateBoardMan(manBoard, locationRow, locationCol);
          manCost++;
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
          robot.updateBoardMan(manBoard, locationRow, locationCol);
          manCost++;
          break;
        }
        if(Character.toString(board[upRow][locationCol]).equals(".")){
          possibleUp.add(upRow);
          possibleUp.add(locationCol);
          arr.add(possibleUp);
        }
      }
      if(locationRow < manBoard.length - 1){
        if(Character.toString(board[downRow][locationCol]).equals("g")){
          robot.updateBoardMan(manBoard, locationRow, locationCol);
          manCost++;
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
        calc = calculateDistanceManhattan(row, col, goalRow, goalCol);
        calcs.add(calc);
      }

      double min = Collections.min(calcs);
      int index = calcs.indexOf(min);

      locationRow = arr.get(index).get(0);
      locationCol = arr.get(index).get(1);

      robot.updateBoardMan(manBoard, locationRow, locationCol);
      manCost++;

      possibleUp.clear();
      possibleDown.clear();
      possibleRight.clear();
      possibleLeft.clear();
      arr.clear();
      calcs.clear();
    }

    System.out.println("Manhattan Strategy Path: ");
    for (int j=0; j < manBoard.length; j++) {
      for (int k=0; k < manBoard.length; k++) {
        System.out.print(manBoard[j][k]);
      }
      System.out.println("");
    }
    System.out.println("This strategy's path cost: " + manCost);

  }

}
