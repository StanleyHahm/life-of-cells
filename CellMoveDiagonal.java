/**
*  NAME: Stanley Hahm
*  ID: A14609365
*  EMAIL: sthahm@ucsd.edu
*
*  For this code, we are trying to have it do various functions.
*  This code is responsible for assigning the instance variables
*  to the super class (Cell.java). And it also determines if the
*  cells should be moved diagonally or not.
*/
import java.util.*;

/**
*  This class sets the sets all the arguments received to the
*  instance variables of the super class. It will also check if
*  the cell needs to apoptosis or not.
*/
public class CellMoveDiagonal extends CellMoveUp{
  public boolean orientedRight;
  public int diagonalMoves;

  /**
  *  Sets parameters to parent class Cell.java. Also sets
  *  orientedRight to true and diagonalMoves to 0.
  *
  *  @param currRow the row of cell
  *  @param currCol the column of cell
  *  @param mass the mass of cell
  */
  public CellMoveDiagonal(int currRow, int currCol, int mass){
    super(currRow, currCol, mass);
    orientedRight = true;
    diagonalMoves = 0;
  }
  /**
  *  This is copy constructor that copies the sets the parameters
  *  to the instance variables of the super class Cell.java.
  *
  *  @param otherCellMoveDiagonal this is the variable that stems
  *  from Cell.java
  */
  public CellMoveDiagonal(CellMoveDiagonal otherCellMoveDiagonal){
    super(otherCellMoveDiagonal);
    this.orientedRight = otherCellMoveDiagonal.orientedRight;
    this.diagonalMoves = otherCellMoveDiagonal.diagonalMoves;

  }

  /**
  *  gives back string representation
  *
  *  @return /, \ string representation if orientedRight is true or false
  */
  public String toString(){
    if(orientedRight == true){
      return "/";
    }
    else{
      return "\\";
    }
  }

  /**
  *  Checks if the cells did apoptosis or not
  *
  *  @return true,false if neighbors size is more 3
  */
  public boolean checkApoptosis(List<Cell> neighbors){
    if(neighbors.size() > 3){
      return true;
    }
    else{
      return false;
    }
  }
}
