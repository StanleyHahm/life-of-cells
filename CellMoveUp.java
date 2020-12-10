/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to have it do various functions.
*  This code is responsible for assigning the instance variables
*  to the super class (Cell.java). And it also determines if the
*  cells should move up or not.
*/
import java.util.*;

/**
*  This class sets the sets all the arguments received to the
*  instance variables of the super class. It will also check if
*  the cell needs to apoptosis or not.
*/
public class CellMoveUp extends Cell implements Movable{
  /**
  *  Sets parameters to parent class Cell.java.
  *
  *  @param currRow the row of cell
  *  @param currCol the column of cell
  *  @param mass the mass of cell
  */
  public CellMoveUp(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
  }

  /**
  *  This is copy constructor that copies the sets the parameters
  *  to the instance variables of the super class Cell.java.
  *
  *  @param otherCellMoveUp this is the variable that
  *  stems from Cell.java.
  */
  public CellMoveUp(CellMoveUp otherCellMoveUp){
    super(otherCellMoveUp);
  }

  /**
  *  gives back string representation
  *
  *  @return "^" this is the string representation
  */
  public String toString(){
    return "^";
  }

  /**
  *  Checks if the cells did apoptosis or not
  *
  *  @return true,false if neighbors size is not 4
  */
  public boolean checkApoptosis(List<Cell> neighbors){
    if(neighbors.size() != 4){
      return true;
    }
    else{
      return false;
    }
  }

  /**
  *  uses copy constructor to make a deep copy of the object
  *
  *  @return copy gives deep copy of calling object
  */
  public Cell newCellCopy(){
    Cell copy = new CellMoveUp(this);
    return copy;
  }


  public int[] getMove(){
    int[] newPosition = new int[2];
    newPosition[0] += 1;
    return newPosition;
  }
}
