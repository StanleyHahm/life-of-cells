/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to have it do various functions.
*  This code is responsible for a constructor and copy constructor
*  for the instance variables. And it'll also get the rows and
*  columns of the cells.
*/
import java.util.*;

/**
*  This class sets the sets all the arguments received to the
*  instance variables. It will also check if the cell needs to
*  apoptosis or not.
*/
public abstract class Cell{
  public int currRow;
  public int currCol;
  public int mass;

  /**
  *  Checks if parameters are non-negative and then sets them
  *  to the instance variables.
  *
  *  @param currRow the row of cell
  *  @param currCol the column of cell
  *  @param mass the mass of cell
  */
  public Cell(int currRow, int currCol, int mass){
    if((currRow >= 0) && (currCol >= 0) && (mass >= 0)){
      this.currRow = currRow;
      this.currCol = currCol;
      this.mass = mass;
    }
    else{
      this.currRow = 0;
      this.currCol = 0;
      this.mass = 0;
    }
  }

  /**
  *  This is copy constructor that copies the sets the parameters
  *  to the instance variables.
  *
  *  @param otherCell this is the variable that stems from Cell.java
  */
  public Cell(Cell otherCell){
    currRow = otherCell.currRow;
    currCol = otherCell.currCol;
    mass = otherCell.mass;
  }

  /**
  *  This is apoptosis method that sets variables to -1
  */
  public void apoptosis(){
    currRow = -1;
    currCol = -1;
    mass = -1;
  }

  /**
  *  gives back current row
  *
  *  @return gives back the current row of cell
  */
  public int getCurrRow(){
    return currRow;
  }

  /**
  *  gives back current column
  *
  *  @return gives back the current column of cell
  */
  public int getCurrCol(){
    return currCol;
  }

  /**
  *  gives back mass
  *
  *  @return gives back the mass of cell
  */
  public int getMass(){
    return mass;
  }

  /**
  *  Checks if the cells did apoptosis or not
  */
  public abstract boolean checkApoptosis(List<Cell> neighbors);

}
