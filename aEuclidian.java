//An implementation of Strategy 3 - A* with Euclidian as h(N)

import java.io.*;
import java.util.*;

public class aEuclidian {

  public static double calculateDistanceAEuclidian(int robotRow, int robotCol, int goalRow, int goalCol, int cost){

    double distance = 0;
    double euclidianDistance = 0;
    
    euclidianDistance = euclidian.calculateDistanceEuclidian(robotRow, robotCol, goalRow, goalCol);

    distance = cost + euclidianDistance;

    return distance;

  }

  public static void searchAEuclid(char[][] board, int locationRow, int locationCol, int goalRow, int goalCol){
    char [][] aEuclidBoard = board;
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    int leftCol = locationCol - 1;
    int rightCol = locationCol + 1;
    int upRow = locationRow - 1;
    int downRow = locationRow + 1;
    int aEuclidCost = 0;

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
          robot.updateBoardAEuclid(aEuclidBoard, locationRow, locationCol);
          aEuclidCost++;
          break;
        }
        if(Character.toString(board[locationRow][leftCol]).equals(".")){
          possibleLeft.add(locationRow);
          possibleLeft.add(leftCol);
          arr.add(possibleLeft);
        }
      }
      if(locationCol < aEuclidBoard.length - 1){
        if(Character.toString(board[locationRow][rightCol]).equals("g")){
          robot.updateBoardAEuclid(aEuclidBoard, locationRow, locationCol);
          aEuclidCost++;
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
          robot.updateBoardAEuclid(aEuclidBoard, locationRow, locationCol);
          aEuclidCost++;
          break;
        }
        if(Character.toString(board[upRow][locationCol]).equals(".")){
          possibleUp.add(upRow);
          possibleUp.add(locationCol);
          arr.add(possibleUp);
        }
      }
      if(locationRow < aEuclidBoard.length - 1){
        if(Character.toString(board[downRow][locationCol]).equals("g")){
          robot.updateBoardAEuclid(aEuclidBoard, locationRow, locationCol);
          aEuclidCost++;
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
        calc = calculateDistanceAEuclidian(row, col, goalRow, goalCol, aEuclidCost);
        calcs.add(calc);
      }

      double min = Collections.min(calcs);
      int index = calcs.indexOf(min);

      locationRow = arr.get(index).get(0);
      locationCol = arr.get(index).get(1);

      robot.updateBoardAEuclid(aEuclidBoard, locationRow, locationCol);
      aEuclidCost++;

      possibleUp.clear();
      possibleDown.clear();
      possibleRight.clear();
      possibleLeft.clear();
      arr.clear();
      calcs.clear();
    }

    System.out.println("A*Euclidian Strategy Path: ");
    for (int j=0; j < aEuclidBoard.length; j++) {
      for (int k=0; k < aEuclidBoard.length; k++) {
        System.out.print(aEuclidBoard[j][k]);
      }
      System.out.println("");
    }
    System.out.println("This strategy's path cost: " + aEuclidCost);

  }
}
