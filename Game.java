package chess;
import java.util.Scanner;
import java.util.regex.*;
class Game {
	
	static Board b;
	static int[] checkby=new int[2];
	static Piece checkfrom;
        
	public Game() {
		b=new Board();
	}
	
	public static void main(String args[]) {
		new Game();
                TestCases.testCases();
		int turn=1;
		while(true) {
			b.display();
			if(!play(turn%2))
				continue;
			System.out.println("Number of turns: "+turn);
			turn++;
		}
	}
	
	static boolean play(int color) {
		Scanner scan=new Scanner(System.in);
                //PrintStream diskWriter= new PrintStream("C:\\Users\\AKASH AGRAWAL\\Documents\\cookeddata.txt");
                //diskWriter.println("Chess game log:");
		int otherColor;
		if(color==1) {
			otherColor=0;
                        System.out.println("White's move");
                }
                else {
			otherColor=1;
                        System.out.println("Black's move");
                }
                System.out.println("Enter initial position and final position in format ([1-8][a-h] [1-8][a-h])");
		System.out.println("Eg:2a 4a");
                Pattern format=Pattern.compile("[1-8][a-h] [1-8][a-h]");
		String input=scan.nextLine();
                if(format.matcher(input).matches()) {
                        int ix=input.charAt(0)-49;
                        int iy=(int)input.charAt(1)-97;
                        int fx=input.charAt(3)-49;
                        int fy=(int)input.charAt(4)-97;
                        Piece p=b.getPiece(ix,iy);
                        if(p!=null) {
                                if(p.color==color) {
                                        if(p.validMove(ix,iy,fx,fy,p)) {
                                                Piece k=b.getPiece(fx,fy);
                                                b.movePiece(ix, iy, fx, fy);
                                                if(fx==ix && fy-iy==2) {
                                                    if(ix==0 || ix==7)
                                                        b.movePiece(ix, 7, ix, 5);
                                                }
                                                else if(fx==ix && iy-fy==2) {
                                                    if(ix==0 || ix==7)
                                                        b.movePiece(ix, 0, ix, 3);
                                                }
                                                if(!isCheck(color)) {
                                                        //System.out.println("Moved."+input);
                                                        //diskWriter.println(input);
                                                }
                                                else {
                                                        System.out.println("You are in check, save your king first.");
                                                        if(fx==ix && fy-iy==2) {
                                                                if(ix==0 || ix==7) {
                                                                        b.movePiece(fx, fy, ix, iy);
                                                                        if(fx==ix && iy-fy==2)
                                                                                b.movePiece(ix, 2, ix, 0);
                                                                        else
                                                                                b.movePiece(ix, 5, ix, 7);
                                                                }
                                                        }
                                                        else {
                                                            b.undoMove(fx,fy,ix,iy,k);
                                                        }
                                                        return false;
                                                }
                                                if(isCheck(otherColor)) {
                                                        if(isCheckmate(otherColor)) {
                                                                if(color==0)
                                                                        System.out.println("Congratulations, Black wins!");
                                                                else
                                                                        System.out.println("Congratulations, White wins!");
                                                                b.display();
                                                                System.exit(0);
                                                        }
                                                }
                                                return true;
                                        }
                                        else {
                                                System.out.println("Invalid move. Try again.");
                                                return false;
                                        }
                                }
                                else {
                                        System.out.println("Cannot play a piece of other color. Try again.");
                                        return false;
                                }
                        }
                        else {
                                System.out.println("Nothing there to move.");
                                return false;
                        }
		}
		else {
			System.out.println("Invalid input(s) entered. Try again.");
			return false;
		}
	}
	
	static boolean isCheck(int color) {
		int kx,ky;
		int[] k=getKing(color);
		kx=k[0];
		ky=k[1];
		Piece p;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				p=b.getPiece(i,j);
				if(p!=null) {
					if(p.color!=color) {
						if(p.validMove(i,j,kx,ky,p)) {
                            checkby[0]=i;
							checkby[1]=j;
							if(p instanceof Pawn)
								System.out.println("Check by pawn from "+(i+1)+""+(char)(j+97)+" to "+(kx+1)+""+(char)(ky+97));
							if(p instanceof Rook)
								System.out.println("Check by rook from "+(i+1)+""+(char)(j+97)+" to "+(kx+1)+""+(char)(ky+97));
							if(p instanceof Knight)
								System.out.println("Check by knight from "+(i+1)+""+(char)(j+97)+" to "+(kx+1)+""+(char)(ky+97));
							if(p instanceof Bishop)
								System.out.println("Check by bishop from "+(i+1)+""+(char)(j+97)+" to "+(kx+1)+""+(char)(ky+97));
							if(p instanceof Queen)
								System.out.println("Check by queen from "+(i+1)+""+(char)(j+97)+" to "+(kx+1)+""+(char)(ky+97));
							if(p instanceof King)
								System.out.println("Check by king from "+(i+1)+""+(char)(j+97)+" to "+(kx+1)+""+(char)(ky+97));
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	static boolean isCheckmate(int color) {
		int kx,ky;
		int[] k=getKing(color);
		kx=k[0];
		ky=k[1];
		Piece p;
		for(int i=kx-1;i<=kx+1;i++) {
			for(int j=ky-1;j<=ky+1;j++) {
				if(i>=0 && j>=0 && i<8 && j<8) {
					p=b.getPiece(i,j);
					if(p!=null) {
						if(p.color==color || ((i==kx) && (j==ky))) 
                            ;
					}
					else {
						b.movePiece(kx, ky, i, j);
							if(!isCheck(color)) {
								b.movePiece(i, j, kx, ky);
								return false;
							}
						b.movePiece(i, j, kx, ky);
					}
				}
			}
		}
		//TODO: checkmate avoided by other pieces of same color
		checkfrom=b.getPiece(checkby[0],checkby[1]);
		boolean isMate=false;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				p=b.getPiece(i,j);
				if(p!=null) {
					if(p.color!=color) {
						if(p.validMove(i, j, checkby[0], checkby[1],p)) {
							b.movePiece(i,j,checkby[0], checkby[1]);
							if(!isCheck(color)) {
								b.undoMove(checkby[0], checkby[1], i, j, checkfrom);
								return false;
							}
							else {
								isMate=true;
							}
						}
					}
				}
				if(i==7 && j==7 && isMate) {
					return true;
				}
			}
		}
		return false;
	}
	
	static int[] getKing(int color) {
		Piece p;
		int[] k=new int[2];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				p=b.getPiece(i,j);
				if(p!=null) {
					if((p.color==color) && (p instanceof King)) {
						k[0]=i;
						k[1]=j;
						return k;
					}
				}
			}
		}
		return null;
	}
}