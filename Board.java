package chess;
class Board {
	static Piece[][] piece;
	public Board() {
		piece=new Piece[8][8];
		initialize();
	}
	private void initialize() {
		for(int i=0;i<8;i++) {
			piece[1][i]=new Pawn(1);
			piece[6][i]=new Pawn(0);
		}
		piece[0][0]=new Rook(1);
		piece[0][1]=new Knight(1);
		piece[0][2]=new Bishop(1);
		piece[0][3]=new Queen(1);
		piece[0][4]=new King(1);
		piece[0][5]=new Bishop(1);
		piece[0][6]=new Knight(1);
		piece[0][7]=new Rook(1);
		piece[7][0]=new Rook(0);
		piece[7][1]=new Knight(0);
		piece[7][2]=new Bishop(0);
		piece[7][3]=new Queen(0);
		piece[7][4]=new King(0);
		piece[7][5]=new Bishop(0);
		piece[7][6]=new Knight(0);
		piece[7][7]=new Rook(0);
		for(int i=2;i<5;i++) {
			for(int j=0;j<8;j++) {
				piece[i][j]=null;
			}
		}
	}
	static Piece getPiece(int x,int y) {
		return piece[x][y];
	}
	void display() {
		System.out.print("   ");
		for(int z=97;z<105;z++) {
			System.out.printf("%5s",(char)z);
                        System.out.printf("%5s","");
		}
                System.out.println("");
                System.out.print("   ");
		for(int i=0;i<79;i++)
			System.out.print("_");
		System.out.println("");
		for(int i=7;i>=0;i--) {
                        for(int z=0;z<8;z++) {
                                System.out.printf("  |%7s","");
                        }
                        System.out.println("  |");
			System.out.print((i+1)+" ");
			for(int j=0;j<8;j++) {
				if(piece[i][j]==null)
					System.out.printf("%-10s","|    X");
				else if(piece[i][j] instanceof Pawn) {
					if(piece[i][j].color==1)
						System.out.printf("%-10s","|WPawn");
					else
						System.out.printf("%-10s","|BPawn");
				}
				else if(piece[i][j] instanceof Rook) {
					if(piece[i][j].color==1)
						System.out.printf("%-10s","|WRook");
					else
						System.out.printf("%-10s","|BRook");
				}
				else if(piece[i][j] instanceof Knight) {
					if(piece[i][j].color==1)
						System.out.printf("%-10s","|WKnight");
					else
						System.out.printf("%-10s","|BKnight");
				}
				else if(piece[i][j] instanceof Bishop) {
					if(piece[i][j].color==1)
						System.out.printf("%-10s","|WBishop");
					else
						System.out.printf("%-10s","|BBishop");
				}
				else if(piece[i][j] instanceof Queen) {
					if(piece[i][j].color==1)
						System.out.printf("%-10s","|WQueen");
					else
						System.out.printf("%-10s","|BQueen");
				}
				else if(piece[i][j] instanceof King) {
					if(piece[i][j].color==1)
						System.out.printf("%-10s","|WKing");
					else
						System.out.printf("%-10s","|BKing");
				}
			}
                        System.out.println("| "+(i+1));
                        System.out.print("  |");
                        for(int y=0;y<8;y++) {
                            for(int z=0;z<9;z++) {
                                System.out.print("_");
                            }
                            System.out.print("|");
                        }
                        System.out.println("");
		}
                System.out.print("   ");
		for(int z=97;z<105;z++) {
			System.out.printf("%5s",(char)z);
                        System.out.printf("%5s","");
		}
                System.out.println("");
	}
	void movePiece(int ix,int iy,int fx,int fy) {
		piece[fx][fy]=piece[ix][iy];
		piece[ix][iy]=null;
	}
	void undoMove(int ix,int iy, int fx, int fy, Piece p) {
		piece[fx][fy]=piece[ix][iy];
		piece[ix][iy]=p;
	}
}