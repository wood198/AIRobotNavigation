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
    int fringeCount = 0;
    int nodeCount = 0;

    //create the ability to store possible successors
    ArrayList<Integer> possibleUp = new ArrayList<Integer>();
    ArrayList<Integer> possibleDown = new ArrayList<Integer>();
    ArrayList<Integer> possibleLeft = new ArrayList<Integer>();
    ArrayList<Integer> possibleRight = new ArrayList<Integer>();


    while(true) {
      leftCol = locationCol - 1;
      rightCol = locationCol + 1;
      upRow = locationRow - 1;
      downRow = locationRow + 1;

      //check the locations around where the robot is currently
      //if it is good add it to a list of possible locations
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
        row = arr.get(i).get(0);
        col = arr.get(i).get(1);
        calc = calculateDistanceAManhattan(row, col, goalRow, goalCol, aManCost);
        calcs.add(calc);
      }

      fringeCount += calcs.size() - 1;

      //determine the min of the distances in the list and choose that location
      double min = Collections.min(calcs);
      int index = calcs.indexOf(min);

      //update the current location to the one chosen
      locationRow = arr.get(index).get(0);
      locationCol = arr.get(index).get(1);

      //update the board with an o and up the cost
      robot.updateBoardAMan(aManBoard, locationRow, locationCol);
      aManCost++;

      possibleUp.clear();
      possibleDown.clear();
      possibleRight.clear();
      possibleLeft.clear();
      arr.clear();
      calcs.clear();
    }

    nodeCount = fringeCount + aManCost + 1;

    //print the board and all appropriate info
    System.out.println("A*Manhattan Strategy Path: ");
    for (int j=0; j < aManBoard.length; j++) {
      for (int k=0; k < aManBoard.length; k++) {
        System.out.print(aManBoard[j][k]);
      }
      System.out.println("");
    }
    System.out.println("This strategy's path cost: " + aManCost);
    System.out.println("The number of nodes in the search tree when the solution was found: " + nodeCount);
    System.out.println("");
  }

}
