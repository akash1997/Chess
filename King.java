package chess;
class King extends Piece{
	public King(int _color) {
		super(_color);
	}
	static boolean validMove(int ix,int iy,int fx,int fy) {
		
		if((fx-ix==1 || fx-ix==-1 || fx==ix) && (fy-iy==1 || fy-iy==-1 ||fy==iy)) {
                        if(Board.getPiece(fx,fy)==null)
                                return true;
                        else if(Board.getPiece(fx,fy).color!=Board.getPiece(ix,iy).color) {
				return true;
			}
		}
		//Castling case
		else if(fx==ix && iy-fy==2) {
                    if(Board.getPiece(ix,0) instanceof Rook) {
                        if(Rook.validMove(ix, 0, ix, 2))
                            return true;
                    }
                }
                else if(fx==ix && fy-iy==2) {
                    if(Board.getPiece(fx, 7) instanceof Rook) {
                        if(Rook.validMove(ix, 7, ix, 5))
                            return true;
                    }
                }
		return false;
	}
}