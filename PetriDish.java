/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to get the board and put it into
*  a new 2D array.
*/
import java.util.*;

/**
*  This class sets the sets the board to the 2D array of Cell.java.
*  It also intereacts w/ the other Cell subclasses if the element
*  in the board meets that.
*/
public class PetriDish{

  public Cell[][] dish;

  /**
  *  This is the constructor method that prints the board into
  *  the instance variable dish.
  *
  *  @param board the 2D string array that has the Cell Types and
  *  masses of each cell
  */
  public PetriDish(String[][] board){
    String cellType;
    int mass;
    String str;
    String[] split_str;
    dish = new Cell[board.length][board[0].length];
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[0].length; col++){
        //checks if the element is null or not
        if(board[row][col] != "null"){
          str = board[row][col];
          split_str = str.split(" ", 0);
          cellType = split_str[0];
          mass = Integer.parseInt(split_str[1]);
          //checks cellTypes and sets new variables to that
          //cell type
          if(cellType.equals("CellStationary")){
            dish[row][col] = new CellStationary(row, col, mass);
          }
          if(cellType.equals("CellMoveUp")){
            System.out.println("It works!");
            dish[row][col] = new CellMoveUp(row, col, mass);
          }
          if(cellType.equals("CellDivide")){
            dish[row][col] = new CellDivide(row, col, mass);
          }
          if(cellType.equals("CellMoveToggle")){
            dish[row][col] = new CellMoveToggle(row, col, mass);
          }
          if(cellType.equals("CellMoveDiagonal")){
            dish[row][col] = new CellMoveDiagonal(row, col, mass);
          }
          if(cellType.equals("CellMoveToggleChild")){
            dish[row][col] = new CellMoveToggleChild(row, col, mass);
          }
        }
        else{
          dish[row][col] = null;
        }
      }
    }
    System.out.println(Arrays.deepToString(dish));
  }

  public static void main (String args[]){
    String[][] petri = new String[][]{ {"CellMoveUp 0", "CellMoveToggle 1", "CellMoveToggleChild 2", "null"},
{"CellMoveDiagonal 3", "CellDivide 4", "CellMoveToggle 5", "null"}};
    PetriDish petriTest = new PetriDish(petri);
  }
}
