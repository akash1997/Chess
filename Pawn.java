package chess;
class Pawn extends Piece{
	public Pawn(int _color) {
		super(_color);
	}
	static boolean validMove(int ix,int iy,int fx,int fy) {
		if(iy==fy) {
			if((ix==1 && fx<=3) || (ix==6 && fx>=4)) {
				if((Board.getPiece(ix,iy)).color==1) {
					for(int i=ix+1;i<=fx;i++) {
						if(Board.getPiece(i,iy)!=null) {
							//System.out.println("Something in between.");
							return false;
						}
					}
					return true;
				}
				else {
					for(int i=ix-1;i>=fx;i--) {
						if(Board.getPiece(i,iy)!=null) {
							//System.out.println("Something in between.");
							return false;
						}
					}
					return true;
				}
			}
			else {
				if((Board.getPiece(ix,iy)).color==1) {
					if(Board.getPiece(fx,fy)==null && fx-ix==1)
						return true;
				}
				else {
					if(Board.getPiece(fx,fy)==null && fx-ix==-1)
						return true;
				}
			}
		}
		else if(fy-iy==1 || fy-iy==-1){
			if(Board.getPiece(fx,fy)!=null) {
				if((Board.getPiece(ix,iy)).color==1) {
					if(fx-ix==1) {
						if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color)
							return true;
					}
				}
				else {
					if(fx-ix==-1) {
						if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color)
							return true;
					}
				}
			}
		}
		return false;
	}
}