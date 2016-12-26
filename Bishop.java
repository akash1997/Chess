package chess;
class Bishop extends Piece{
	public Bishop(int _color) {
		super(_color);
	}
	static boolean validMove(int ix,int iy,int fx,int fy) {
		if(Math.abs(fx-ix)==Math.abs(fy-iy)) {
			if(fx-ix>0 && fy-iy>0) {
				int j=iy;
				for(int i=ix+1;i<fx;i++) {
					j++;
					if(Board.getPiece(i,j)!=null) {
						//System.out.println("Something in between.");
						return false;
					}	
				}
				if(Board.getPiece(fx,fy)==null)
					return true;
				else if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color)
					return true;
			}
			else if(fx-ix>0 && fy-iy<0) {
				int j=iy;
				for(int i=ix+1;i<fx;i++) {
					j--;
					if(Board.getPiece(i,j)!=null) {
						//System.out.println("Something in between.");
						return false;
					}
				}
				if(Board.getPiece(fx,fy)==null)
					return true;
				else if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color)
					return true;
			}
			else if(fx-ix<0 && fy-iy>0) {
				int j=iy;
				for(int i=ix-1;i>fx;i--) {
					j++;
					if(Board.getPiece(i,j)!=null) {
						//System.out.println("Something in between.");
						return false;
					}
				}
				if(Board.getPiece(fx,fy)==null)
					return true;
				else if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color)
					return true;
			}
			else if(fx-ix<0 && fy-iy<0) {
				int j=iy;
				for(int i=ix-1;i>fx;i--) {
					j--;
					if(Board.getPiece(i,j)!=null) {
						//System.out.println("Something in between.");
						return false;
					}
				}
				if(Board.getPiece(fx,fy)==null)
					return true;
				else if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color)
					return true;
			}
		}
		return false;
	}
}