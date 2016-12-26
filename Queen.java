package chess;
class Queen extends Piece{
	public Queen(int _color) {
		super(_color);
	}
	static boolean validMove(int ix,int iy,int fx,int fy) {
		return (Rook.validMove(ix,iy,fx,fy) || Bishop.validMove(ix,iy,fx,fy));
	}
}