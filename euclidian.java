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
    int fringeCount = 0;
    int nodeCount = 0;

    //create the ability to store possible successors
    ArrayList<Integer> possibleUp = new ArrayList<Integer>();
    ArrayList<Integer> possibleDown = new ArrayList<Integer>();
    ArrayList<Integer> possibleLeft = new ArrayList<Integer>();
    ArrayList<Integer> possibleRight = new ArrayList<Integer>();

    ArrayList<String> fringe = new ArrayList<String>();

    while(true) {
      leftCol = locationCol - 1;
      rightCol = locationCol + 1;
      upRow = locationRow - 1;
      downRow = locationRow + 1;

      //check the locations around where the robot is currently
      //if it is good add it to a list of possible locations
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
        row = arr.get(i).get(0);
        col = arr.get(i).get(1);
        calc = calculateDistanceEuclidian(row, col, goalRow, goalCol);
        calcs.add(calc);
      }

      fringeCount += calcs.size() - 1;

      //determine the min of the distances in the list and choose that location
      double min = Collections.min(calcs);
      int index = calcs.indexOf(min);

      //update the current location to the one chosen
      locationRow = arr.get(index).get(0);
      locationCol = arr.get(index).get(1);

      arr.remove(index);

      //add the unexpanded nodes to the fringe list
      for (int j = 0; j < arr.size(); j++) {
        if (arr.get(j).isEmpty()){
          continue;
        } else {
          int x = arr.get(j).get(0);
          int y = arr.get(j).get(1);
          if (!fringe.contains(robot.getLocations(x, y))) {
            fringe.add(robot.getLocations(x, y));
          }
        }
      }

      //update the board with an o and up the cost
      robot.updateBoardEuclid(euclidBoard, locationRow, locationCol);
      euclidCost++;

      possibleUp.clear();
      possibleDown.clear();
      possibleRight.clear();
      possibleLeft.clear();
      arr.clear();
      calcs.clear();
    }

    fringeCount = fringe.size();
    nodeCount = fringeCount + euclidCost + 1;

    //print the board and all appropriate info
    System.out.println("Euclidian Strategy Path: ");
    for (int j=0; j < euclidBoard.length; j++) {
      for (int k=0; k < euclidBoard.length; k++) {
        System.out.print(euclidBoard[j][k]);
      }
      System.out.println("");
    }
    System.out.println("This strategy's path cost: " + euclidCost);
    System.out.println("The number of nodes in the search tree when the solution was found: " + nodeCount);
    System.out.println("");
  }
}
