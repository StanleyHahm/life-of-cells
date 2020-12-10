/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to have it do various functions.
*  This code is responsible for assigning the instance variables
*  to the super class (Cell.java). And it also determines if the
*  cells should be stationary or not.
*/
import java.util.*;

/**
*  This class sets the sets all the arguments received to the
*  instance variables of the super class. It will also check if
*  the cell needs to apoptosis or not.
*/
public class CellStationary extends Cell{
  /**
  *  Sets parameters to parent class Cell.java.
  *
  *  @param currRow the row of cell
  *  @param currCol the column of cell
  *  @param mass the mass of cell
  */
  public CellStationary(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
  }

  /**
  *  This is copy constructor that copies the sets the parameters
  *  to the instance variables of the super class Cell.java.
  *
  *  @param otherCellStationary this is the variable that
  *  stems from Cell.java.
  */
  public CellStationary(CellStationary otherCellStationary){
    super(otherCellStationary);
  }

  /**
  *  gives back string representation
  *
  *  @return "." this is the string representation
  */
  public String toString(){
    return ".";
  }

  /**
  *  Checks if the cells did apoptosis or not
  *
  *  @return true,false if neighbors size is less than or equal to 7
  *  and more than or equal to 3
  */
  public boolean checkApoptosis(List<Cell> neighbors){
    if((neighbors.size() <= 7) && (neighbors.size() >= 3)){
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
    Cell copy = new CellStationary(this);
    return copy;
  }
}
