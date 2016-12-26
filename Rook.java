package chess;
class Rook extends Piece{
	public Rook(int _color) {
		super(_color);
	}
	static boolean validMove(int ix,int iy,int fx,int fy) {
		if(ix==fx) {
			if(fy-iy>0) {
				for(int i=iy+1;i<fy;i++) {
                                        //System.out.println("Checking: "+ix+","+i);
					if(Board.getPiece(ix,i)!=null) {
						//System.out.println("Something in between.");
						return false;
					}	
				}
				if(Board.getPiece(fx,fy)==null)
					return true;
				else if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color)
					return true;
			}
			else {
				for(int i=iy-1;i>fy;i--) {
                                        //System.out.println("Checking: "+ix+","+i);
					if(Board.getPiece(ix,i)!=null) {
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
		else if(iy==fy) {
			if(fx-ix>0) {
				for(int i=ix+1;i<fx;i++) {
                                        //System.out.println("Checking: "+i+","+iy);
					if(Board.getPiece(i,iy)!=null) {
						//System.out.println("Something in between.");
						return false;
					}
				}
				if(Board.getPiece(fx,fy)==null)
					return true;
				else if((Board.getPiece(fx,fy)).color!=(Board.getPiece(ix,iy)).color) {
					return true;
				}
				
			}
			else {
				for(int i=ix-1;i>fx;i--) {
                                        //System.out.println("Checking: "+i+","+iy);
					if(Board.getPiece(i,iy)!=null) {
                                                //System.out.println("Rook checking");
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