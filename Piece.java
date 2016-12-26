package chess;
abstract class Piece {
	int color;
	public Piece(int _color) {
		this.color=_color;
	}
	
	static boolean validMove(int ix,int iy,int fx,int fy,Piece p) {
		if(p instanceof Pawn) {
                        //System.out.println("Checking for pawn.");
			return Pawn.validMove(ix,iy,fx,fy);
                }
		else if(p instanceof Rook) {
                        //System.out.println("Checking for rook.");
			return Rook.validMove(ix,iy,fx,fy);
                }
		else if(p instanceof Knight) {
                        //System.out.println("Checking for knight.");
			return Knight.validMove(ix,iy,fx,fy);
                }
                else if(p instanceof Bishop) {
                        //System.out.println("Checking for bishop.");
			return Bishop.validMove(ix,iy,fx,fy);
                }
		else if(p instanceof Queen) {
                        //System.out.println("Checking for queen.");
			return Queen.validMove(ix,iy,fx,fy);
                }
		else if(p instanceof King) {
                        //System.out.println("Checking for king.");
			return King.validMove(ix,iy,fx,fy);
                }
		return false;
	}
	
	//abstract boolean validMove(int ix,int iy,int fx,int fy);
}