package chess;

public class Queen extends Piece {
    public Queen(PieceColour colour){
        
        this.colour = colour;
        if(colour == PieceColour.WHITE){
            setSymbol("\u265B");
        }
        else {
            setSymbol("\u2655");
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
        int differi = Math.abs(i0 -i1);
        int differj = Math.abs(j0 -j1);
        int highj = 0;
        int lowj = 0;
        int highi = 0;
        int lowi = 0;

        if(overLap(i0,j0,i1,j1)){
            return false;
          }

        if (differi == 0 || differj == 0 || differi == differj) {
            
            
            if (j0>j1){
            highj = j0;
            lowj = j1;
            }
            else{
            highj = j1;
            lowj = j0;
            }
            
            if(i0>i1){
            highi = i0;
            lowi = i1;
            }else{
            highi = i1;
            lowi = i0;
            }

            if (differi == 0) {
            for (int x = lowj + 1; x < highj  ;x++ ) {
                if (board[i0][x].hasPiece()) {
                    return false;
                }
            }
        }
            else if (differj == 0) {
            for (int x = lowi + 1; x < highi ;x++ ) {
                if (board[x][j0].hasPiece()) {
                 return false;
                }
            }
            } 
            else {
            
            int dist = Math.abs(i0 -i1);

            int x = 0;
            int y = 0;

            while (Math.abs(x) < dist -1 ) {
                if (i0<i1) {
                x=x+1;
                } 
                else {
                x=x-1;
                }
                if (j0<j1) {
                y=y+1;
                } 
                else {
                y=y-1;
                }

                if (board[x + i0][y + j0].hasPiece()) {
                return false;
                }
            }
    
        }
    }
    return true;

    }
}
    


    


