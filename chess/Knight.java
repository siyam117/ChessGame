package chess;

public class Knight extends Piece {
    public Knight(PieceColour colour){
        
        this.colour = colour;
        if(colour == PieceColour.WHITE){
            setSymbol("\u265E");
        }
        else {
            setSymbol("\u2658");
        }
    }


    public boolean overLap(int i0, int j0, int i1, int j1){
        Square [][] board = Board.getBoard();
        if (board[i1][j1].hasPiece()) {
            if (board[i0][j0].getPiece().getColour() == board[i1][j1].getPiece().getColour()) {
              return true;
            }
          }
          return false;
        }

    @Override
    public boolean isLegitMove(int i0, int j0, int i1, int j1){


        if(overLap(i0,j0,i1,j1)){
            return false;
          }


        if ((i1==i0+2) && (j1 == j0+1)){
            return true;
        }
        else if ((i1 == i0+1) && (j1==j0+2)){
            return true;
        }
        else if ((i1==i0-1) && (j1 == j0+2)){
            return true;
        }
        else if ((i1 == i0-2) && (j1==j0+1)){
            return true;
        }
        else if ((i1 == i0-2) && (j1==j0-1)){
            return true;
        }
        else if ((i1 == i0-1) && (j1==j0-2)){
            return true;
        }
        else if ((i1 == i0+1) && (j1==j0-2)){
            return true;
        }
        else if ((i1 == i0+2) && (j1==j0-1)){
            return true;
        }
        else{
            return false;
        }
        
    }
}

