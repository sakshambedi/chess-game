/**
 * 
 * making a basic game board 
 * using tiles to store each tile
 * each tile should have the corresponding data : 
 * x-axis : a-h;
 * y-axis : 1-8; 
 * chess piece : what chess piece it holds
 * 
*/

// ---------------- importing libraries ------------


public class GameBoard{

    // initialising variabls 
    public static Tile[][] gameBoard; 
    

    /**
     * Purpose : create a 2d array 
     */
    public GameBoard(){ gameBoard = new Tile[8][8]; }


    // accessor method for GameBoard array 
    public Tile[][] getBoard() {return gameBoard;}


    /**
     * Purpose : method that initialises each tile with values 
     */
    public void initiateEachTile(){
        for(int row=0; row< 8; row++){
            for(int column = 0; column <8; column++ ) gameBoard[row][column] =  new Tile(row, column);
        }
        initiateDefaultPosition();
    }



    /**
     * Purpose : load default chess piece at there correct position after each tile has been initiated with default values 
     */
    protected static void initiateDefaultPosition(){
        // for white pawn pieces
        // later one for black pieces 
        for (int i=0; i<8; i++){gameBoard[1][i].setChessPiece("pawn","black") ; 
                                gameBoard[6][i].setChessPiece("pawn","white");}

        //******** placing white pieces first ***********

        // for rook 
        gameBoard[7][0].setChessPiece("rook", "white");
        gameBoard[7][7].setChessPiece("rook", "white");
    
        // for horse 
        gameBoard[7][1].setChessPiece("horse", "white");
        gameBoard[7][6].setChessPiece("horse", "white");

        // for bishop
        gameBoard[7][2].setChessPiece("bishop", "white");
        gameBoard[7][5].setChessPiece("bishop", "white");

        // queen
        gameBoard[7][3].setChessPiece("queen", "white");
         
        // king 
        gameBoard[7][4].setChessPiece("king", "white");


        // *********** placing black pieces now **************** 
         
        // for rook
        gameBoard[0][0].setChessPiece("rook", "black");
        gameBoard[0][7].setChessPiece("rook", "black");
        
        // for horses 
        gameBoard[0][1].setChessPiece("horse", "black");
        gameBoard[0][6].setChessPiece("horse", "black");

        // for bishop 
        gameBoard[0][2].setChessPiece("bishop", "black");
        gameBoard[0][5].setChessPiece("bishop", "black");

        // queen 
        gameBoard[0][4].setChessPiece("queen", "black");
        
        // king 
        gameBoard[0][3].setChessPiece("king", "black"); 
    }


    /**
     * Purpose : print 2d array chess in cli
     */
    private void printCLIchess(){
        GameBoard gb = new GameBoard();
        Tile[][] gbarray = gb.getBoard();
        gb.initiateEachTile();
        for(int i =0 ; i< gbarray.length; i++){ 
            for(int j = 0; j<gbarray[i].length; j++) {
                System.out.printf("[%6s]",gbarray[i][j].getPiece());
            }
                System.out.println("");
        }
    }



    // main method for debugging 
    public static void main(String[] args){ 
        GameBoard gb = new GameBoard();
        gb.initiateEachTile();
    //    Tile[][] gbarray = gb.getBoard();
    //    for(int i =0 ; i< gbarray.length; i++){
    //        for(int j = 0; j<gbarray[i].length; j++) System.out.println(gbarray[i][j].TileDetails());
    //    } 
        gb.printCLIchess();     
    }

}