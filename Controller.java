/*
    public class controller to control the game 


*/

public class Controller {

    // main method 
    public static void main(String[] args){
        // making GameBoard object
        GameBoard gb = new GameBoard();
        JavaDraw jd = new JavaDraw();
        GameBoard.initiateDefaultPosition();
        
        // calling the basic draw structure 
        jd.DrawBasicChess();
        Tile[][] gbarray = gb.getBoard();
        for(int i =0 ; i<8; i++){
            for(int j = 0; j<8; j++){
                System.out.println(gbarray[i][j].TileDetails());
                // String StringAtTile = gbarray[i][j].getPiece();
                // System.out.println(StringAtTile);
                if(gbarray[i][j].getPiece().equals("pawn")) jd.placePawns(i, j);
            }
        }

    }
}