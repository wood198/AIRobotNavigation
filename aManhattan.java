//An implementation of Strategy 4 - A* with Manhattan as h(N)

import java.io.*;
import java.util.*;

public class aManhattan {

  public static double calculateDistanceAManhattan(int robotRow, int robotCol, int goalRow, int goalCol, int cost){

    double distance = 0;
    double manhattanDistance = 0;

    manhattanDistance = manhattan.calculateDistanceManhattan(robotRow, robotCol, goalRow, goalCol);

    distance = cost + manhattanDistance;

    return distance;

  }

  public static void searchAMan(char[][] board, int locationRow, int locationCol, int goalRow, int goalCol) {
    char [][] aManBoard = board;
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    int leftCol = locationCol - 1;
    int rightCol = locationCol + 1;
    int upRow = locationRow - 1;
    int downRow = locationRow + 1;
    int aManCost = 0;

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
          robot.updateBoardAMan(aManBoard, locationRow, locationCol);
          aManCost++;
          break;
        }
        if(Character.toString(board[locationRow][leftCol]).equals(".")){
          possibleLeft.add(locationRow);
          possibleLeft.add(leftCol);
          arr.add(possibleLeft);
        }
      }
      if(locationCol < aManBoard.length - 1){
        if(Character.toString(board[locationRow][rightCol]).equals("g")){
          robot.updateBoardAMan(aManBoard, locationRow, locationCol);
          aManCost++;
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
          robot.updateBoardAMan(aManBoard, locationRow, locationCol);
          aManCost++;
          break;
        }
        if(Character.toString(board[upRow][locationCol]).equals(".")){
          possibleUp.add(upRow);
          possibleUp.add(locationCol);
          arr.add(possibleUp);
        }
      }
      if(locationRow < aManBoard.length - 1){
        if(Character.toString(board[downRow][locationCol]).equals("g")){
          robot.updateBoardAMan(aManBoard, locationRow, locationCol);
          aManCost++;
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
        calc = calculateDistanceAManhattan(row, col, goalRow, goalCol, aManCost);
        calcs.add(calc);
      }

      double min = Collections.min(calcs);
      int index = calcs.indexOf(min);

      locationRow = arr.get(index).get(0);
      locationCol = arr.get(index).get(1);

      robot.updateBoardAMan(aManBoard, locationRow, locationCol);
      aManCost++;

      possibleUp.clear();
      possibleDown.clear();
      possibleRight.clear();
      possibleLeft.clear();
      arr.clear();
      calcs.clear();
    }

    System.out.println("A*Manhattan Strategy Path: ");
    for (int j=0; j < aManBoard.length; j++) {
      for (int k=0; k < aManBoard.length; k++) {
        System.out.print(aManBoard[j][k]);
      }
      System.out.println("");
    }
    System.out.println("This strategy's path cost: " + aManCost);

  }

}
