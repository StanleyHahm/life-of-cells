import java.util.ArrayList;

public abstract class Cell{
  public int currRow;
  public int currCol;
  public int mass;

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

  public Cell(Cell otherCell){
    currRow = otherCell.currRow;
    currCol = otherCell.currCol;
    mass = otherCell.mass;
  }

  public void apoptosis(){
    currRow = -1;
    currCol = -1;
    mass = -1;
  }

  public int getCurrRow(){
    return currRow;
  }

  public int getCurrCol(){
    return currCol;
  }

  public int getMass(){
    return mass;
  }

//WHAT AM I SUPPOSED TO DO WITH THIS METHOD??
  public abstract boolean checkApoptosis(List<Cell> neighbors){

  }
}
