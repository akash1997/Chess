package chess;
class Knight extends Piece{
	public Knight(int _color) {
		super(_color);
	}
	static boolean validMove(int ix,int iy,int fx,int fy) {
		
		if(fx-ix==1 || fx-ix==-1) {
			if(fy-iy==2 || fy-iy==-2) {
				if(Board.getPiece(fx,fy)==null) {
					return true;
				}
				else if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color) {
					return true;
				}
			}
		}
		else if(fx-ix==2 || fx-ix==-2) {
			if(fy-iy==1 || fy-iy==-1) {
				if(Board.getPiece(fx,fy)==null) {
					return true;
				}
				else if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color) {
					return true;
				}
			}
		}
		return false;
	}
}