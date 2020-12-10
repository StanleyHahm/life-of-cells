/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to have it do various functions.
*  This code is responsible for assigning the instance variables
*  to the super class (Cell.java).
*/
import java.util.*;

/**
*  This class sets the sets all the arguments received to the
*  instance variables of the super class. It will also check if
*  the cell needs to apoptosis or not.
*/
public class CellMoveToggleChild extends CellMoveToggle{
  public static int numAlive;

  /**
  *  Sets parameters to parent class Cell.java. Also increments
  *  numAlive by 1.
  *
  *  @param currRow the row of cell
  *  @param currCol the column of cell
  *  @param mass the mass of cell
  */
  public CellMoveToggleChild(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
    numAlive += 1;
  }

  /**
  *  This is copy constructor that copies the sets the parameters
  *  to the instance variables of the super class Cell.java.
  *
  *  @param otherCellMoveToggleChild this is the variable that
  *  stems from Cell.java.
  */
  public CellMoveToggleChild(CellMoveToggleChild
    otherCellMoveToggleChild){
    super(otherCellMoveToggleChild);
    numAlive += 1;
  }

  /**
  *  This is apoptosis method that calls super class apoptosis and
  *  decrements numAlive by 1.
  */
  public void apoptosis(){
    super.apoptosis();
    numAlive -= 1;
  }

  /**
  *  Checks if the cells did apoptosis or not
  *
  *  @return true,false if super class checkApoptosis is true and
  *  if neighbors is less than 10.
  */
  public boolean checkApoptosis(List<Cell> neighbors){
    if((super.checkApoptosis(neighbors) == true)
      && (numAlive < 10)){
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
    Cell copy = new CellMoveToggleChild(this);
    return copy;
  }
}
