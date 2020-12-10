/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to have it do various functions.
*  This code is responsible for assigning the instance variables
*  to the super class (Cell.java). And it also determines if the
*  cells should be divided or not.
*/
import java.util.*;

/**
*  This class sets the sets all the arguments received to the
*  instance variables of the super class. It will also check if
*  the cell needs to apoptosis or not.
*/
public class CellDivide extends Cell implements Divisible{
  public int direction;

  /**
  *  Sets parameters to parent class Cell.java. Also sets direction
  *  to 1.
  *
  *  @param currRow the row of cell
  *  @param currCol the column of cell
  *  @param mass the mass of cell
  */
  public CellDivide(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
    this.direction = 1;
  }

  /**
  *  This is copy constructor that copies the sets the parameters
  *  to the instance variables of the super class Cell.java.
  *
  *  @param otherCellDivide this is the variable that stems
  *  from Cell.java
  */
  public CellDivide(CellDivide otherCellDivide){
    super(otherCellDivide);
    this.direction = otherCellDivide.direction;
  }

  /**
  *  gives back string representation
  *
  *  @return "+" this is the string representation
  */
  public String toString(){
    return "+";
  }

  /**
  *  Checks if the cells did apoptosis or not
  *
  *  @return true,false if neighbors size is 3
  */
  public boolean checkApoptosis(List<Cell> neighbors){
    if(neighbors.size() == 3){
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
    Cell copy = new CellDivide(this);
    return copy;
  }

  /**
  *  utilizes Divisible and creates the spawn of the new cell
  *  depending on the direction
  *
  *  @return spawnPosition gives back the spawnPosition of the new cell
  */
  public int[] getDivision(){
    int[] spawnPosition = new int[2];
    if(direction == 0){
      spawnPosition[0] -= 1;
    }
    if(direction ==1){
      spawnPosition[0] += 1;
    }
    if(direction == 2){
      spawnPosition[1] -= 1;
    }
    if(direction == 3){
      spawnPosition[0] += 1;
    }

    return spawnPosition;
  }
}
