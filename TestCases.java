package chess;

class TestCases {
    static int[] result=new int[2];
    static void testCases() {
        System.out.println("Testing game for test cases...");
        pawnMoves();
        rookMoves();
        bishopMoves();
        knightMoves();
        queenMoves();
        kingMoves();
        System.out.println("Successfully passed "+result[0]+" testcases out of "+result[1]+" testcases.");
    }
    static void pawnMoves() {
        for(int i=0;i<8;i++) {
            if(Pawn.validMove(1, i, 3, i)) {
                result[0]++;
            }
            if(Pawn.validMove(6, i, 4, i)) {
                result[0]++;
            }
            if(Pawn.validMove(1, i, 2, i)) {
                result[0]++;
            }
            if(Pawn.validMove(6, i, 5, i)) {
                result[0]++;
            }
        }
        result[1]+=32;
    }
    static void rookMoves() {
        if(!Rook.validMove(0, 0, 1, 0)) {
            result[0]++;
        }
        if(!Rook.validMove(0, 7, 1, 7)) {
            result[0]++;
        }
        if(!Rook.validMove(7, 0, 7, 1)) {
            result[0]++;
        }
        if(!Rook.validMove(0, 0, 1, 1)) {
            result[0]++;
        }
        result[1]+=4;
    }
    static void bishopMoves() {
        if(!Bishop.validMove(0, 2, 1, 1)) {
            result[0]++;
        }
        if(!Bishop.validMove(0, 2, 1, 3)) {
            result[0]++;
        }
        if(!Bishop.validMove(0, 5, 1, 6)) {
            result[0]++;
        }
        if(!Bishop.validMove(0, 5, 1, 4)) {
            result[0]++;
        }
        if(!Bishop.validMove(7, 2, 6, 1)) {
            result[0]++;
        }
        if(!Bishop.validMove(7, 2, 6, 3)) {
            result[0]++;
        }
        if(!Bishop.validMove(7, 5, 6, 4)) {
            result[0]++;
        }
        if(!Bishop.validMove(7, 5, 6, 6)) {
            result[0]++;
        }
        result[1]+=8;
    }
    static void knightMoves() {
        if(Knight.validMove(0, 1, 2, 0)) {
            result[0]++;
        }
        if(Knight.validMove(0, 6, 2, 5)) {
            result[0]++;
        }
        if(Knight.validMove(0, 1, 2, 2)) {
            result[0]++;
        }
        if(Knight.validMove(0, 6, 2, 7)) {
            result[0]++;
        }
        if(Knight.validMove(7, 1, 5, 0)) {
            result[0]++;
        }
        if(Knight.validMove(7, 6, 5, 5)) {
            result[0]++;
        }
        if(Knight.validMove(7, 1, 5, 2)) {
            result[0]++;
        }
        if(Knight.validMove(7, 6, 5, 7)) {
            result[0]++;
        }
        result[1]+=8;
    }
    static void queenMoves() {
        if(!Queen.validMove(0, 3, 0, 2)) {
            result[0]++;
        }
        if(!Queen.validMove(0, 3, 0, 4)) {
            result[0]++;
        }
        if(!Queen.validMove(0, 3, 1, 2)) {
            result[0]++;
        }
        if(!Queen.validMove(0, 3, 1, 4)) {
            result[0]++;
        }
        if(!Queen.validMove(0, 3, 1, 3)) {
            result[0]++;
        }
        if(!Queen.validMove(7, 3, 7, 2)) {
            result[0]++;
        }
        if(!Queen.validMove(7, 3, 7, 4)) {
            result[0]++;
        }
        if(!Queen.validMove(7, 3, 6, 2)) {
            result[0]++;
        }
        if(!Queen.validMove(7, 3, 6, 4)) {
            result[0]++;
        }
        if(!Queen.validMove(7, 3, 6, 3)) {
            result[0]++;
        }
        result[1]+=10;
    }
    static void kingMoves() {
        if(!King.validMove(0, 4, 0, 3)) {
            result[0]++;
        }
        if(!King.validMove(0, 4, 0, 5)) {
            result[0]++;
        }
        if(!King.validMove(0, 4, 1, 3)) {
            result[0]++;
        }
        if(!King.validMove(0, 4, 1, 5)) {
            result[0]++;
        }
        if(!King.validMove(0, 4, 1, 4)) {
            result[0]++;
        }
        if(!King.validMove(7, 4, 7, 3)) {
            result[0]++;
        }
        if(!King.validMove(7, 4, 7, 5)) {
            result[0]++;
        }
        if(!King.validMove(7, 4, 6, 3)) {
            result[0]++;
        }
        if(!King.validMove(7, 4, 6, 5)) {
            result[0]++;
        }
        if(!King.validMove(7, 4, 6, 4)) {
            result[0]++;
        }
        result[1]+=10;
    }
}