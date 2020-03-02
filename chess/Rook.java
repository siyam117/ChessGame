package chess;

public class Rook extends Piece {
    public Rook(PieceColour colour){

            
        this.colour = colour;
        if(colour == PieceColour.WHITE){
            setSymbol("\u265C");
        }
        else {
            setSymbol("\u2656");
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


        Square[][] board = Board.getBoard();
        int highi = 0;
        int highj = 0;
        int lowi = 0;
        int lowj = 0;

        if(overLap(i0,j0,i1,j1)){
            return false;
          }



        if ((i0 == i1 ^ j0 == j1)) {

            if(i0>i1){  // if initial row poisition > final row position
                highi = i0; //highest pos = initial row position  
                lowi = i1; //lowest pod = final row position
              }
            else{
                highi = i1; //highest row = final row positoin
                lowi = i0; // lowest = initial row position
              }
          
            if (j0>j1){
                highj = j0; //highest column = initial column  position 
                lowj = j1; //lowest column = final column position
            }
            else{
                highj = j1;
                lowj = j0;
              }

            if ((i0 - i1) == 0) {  
                for (int x = lowj + 1; x < highj  ;x++ ) { //if there is a piece in between final destination and initial position then return false (FOR COLUMN)
                  if (board[i0][x].hasPiece()) {  
                    return false;
                    }
                } 
            }
                
            else {
                for (int x = lowi + 1; x < highi ;x++ ) {  // if there is a piece in between final destination and initial position then return false (FOR ROW)
                    if (board[x][j0].hasPiece()) {
                        return false;
                      }
                    }
                  }
                return true;
            }
        
        return false;
        
    }
}

