package chess;

public class King extends Piece {
    public King(PieceColour colour){
        
        this.colour = colour;
        if(colour == PieceColour.WHITE){
            setSymbol("\u265A");
        }
        else {
            setSymbol("\u2654");
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
        int differi = Math.abs(i0 -i1);
        int differj = Math.abs(j0 -j1);
        
        if(overLap(i0,j0,i1,j1)){
            return false;
          }

		if (differi <= 1 && differj <= 1) {
			return true;
		}
    return false;
  }
        
    
}

