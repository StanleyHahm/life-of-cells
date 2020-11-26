import java.util.ArrayList;

public class CellMoveDiagonal extends Cell{
  public boolean orientedRight;
  public int diagonalMoves;

  public CellMoveDiagonal(int currRow, int currCol, int mass){
    this.currRow = currRow;
    this.currCol = currCol;
    this.mass = mass;
    orientedRight = true;
    diagonalMoves = 0;
  }

  public CellMoveDiagonal(CellMoveDiagonal otherCellMoveDiagonal){
    currRow = otherCellMoveDiagonal.currRow;
    currCol = otherCellMoveDiagonal.currCol;
    mass = otherCellMoveDiagonal.mass;
  }

  public String toString(){
    if(orientedRight == true){
      return "/";
    }
    else{
      return "\\";
    }
  }

  public boolean checkApoptosis(List<Cell> neighbors){
    if(neighbors.size() > 3){
      return true;
    }
    else{
      return false;
    }
  }
}
