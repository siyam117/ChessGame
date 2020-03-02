package chess;

public class Bishop extends Piece {
    public Bishop(PieceColour colour){


        this.colour = colour;
        if(colour == PieceColour.WHITE){
            setSymbol("\u265D");
        }
        else {
            setSymbol("\u2657");
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
        int diffi = Math.abs(i0-i1);
        int diffj = Math.abs(j0-j1);
        Square[][] board = Board.getBoard();
        int dist = Math.abs(i0 - i1);
        int x = 0;
        int y = 0;


        if(overLap(i0,j0,i1,j1)){
            return false;
          }

        if (diffi == diffj){

            while (Math.abs(x) < dist - 1){
                if (i0<i1){
                  x = x + 1;
                } else {
                  x = x - 1;
                }
          
                if (j0<j1){
                  y = y + 1;
                }else{
                  y = y - 1;
                }

                if (board[x + i0][y + j0].hasPiece()){
                  return false;
                }
          
              }
              return true;
            }

        return false;
        
    }
}

