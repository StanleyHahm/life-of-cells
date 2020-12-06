/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to have it do various functions.
*  This code is responsible for assigning the instance variables
*  to the super class (Cell.java). And it also determines if the
*  cells should be move toggled or not.
*/
import java.util.*;

/**
*  This class sets the sets all the arguments received to the
*  instance variables of the super class. It will also check if
*  the cell needs to apoptosis or not.
*/
public class CellMoveToggle extends CellMoveUp{
  public boolean toggled;

  /**
  *  Sets parameters to parent class Cell.java. Also sets
  *  toggled to true.
  *
  *  @param currRow the row of cell
  *  @param currCol the column of cell
  *  @param mass the mass of cell
  */
  public CellMoveToggle(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
    toggled = true;
  }

  /**
  *  This is copy constructor that copies the sets the parameters
  *  to the instance variables of the super class Cell.java.
  *
  *  @param otherCellMoveToggle this is the variable that stems
  *  from Cell.java
  */
  public CellMoveToggle(CellMoveToggle otherCellMoveToggle){
    super(otherCellMoveToggle);
  }

  /**
  *  gives back string representation
  *
  *  @return "T" string representation if toggled is true
  *  @return "t" string representation if toggled is false
  */
  public String toString(){
    if(toggled == true){
      return "T";
    }
    else{
      return "t";
    }
  }

  /**
  *  Checks if the cells did apoptosis or not
  *
  *  @return true,false if neighbors size is less than 2 and more
  *  than 5
  */
  public boolean checkApoptosis(List<Cell> neighbors){
    if((neighbors.size() < 2) || (neighbors.size() > 5)){
      return false;
    }
    else{
      return true;
    }
  }
}
